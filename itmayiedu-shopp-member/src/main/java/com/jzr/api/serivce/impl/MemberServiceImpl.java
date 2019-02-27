package com.jzr.api.serivce.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzr.entity.req.ChangePassword;
import com.jzr.entity.req.ReqUser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.jzr.api.service.MemberService;
import com.jzr.netty.base.BaseApiService;
import com.jzr.netty.base.ResponseBase;
import com.jzr.constants.Constants;
import com.jzr.dao.MemberDao;
import com.jzr.entity.UserEntity;
import com.jzr.mq.RegisterMailboxProducer;
import com.jzr.utils.MD5Util;
import com.jzr.utils.TokenUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MemberServiceImpl extends BaseApiService implements MemberService {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private RegisterMailboxProducer registerMailboxProducer;
	@Value("${messages.queue}")
	private String MESSAGESQUEUE;



	@Override
	@HystrixCommand(fallbackMethod="hystrixFallback")
	public ResponseBase findUserById(Long userId) {
		UserEntity user = memberDao.findByID(userId);
		if (user == null) {
			return setResultError("未查找到用户信息.");
		}
		String memberToken = (String) baseRedisService.getString(String.valueOf(user.getId()));
		user.setRCToken(memberToken);
		return setResultSuccess(user);
	}

	@Override
	@HystrixCommand(fallbackMethod="hystrixFallback")
	public ResponseBase regUser(@RequestBody UserEntity user) {
		// 参数验证
		String password = user.getPassword();
		if (StringUtils.isEmpty(password)) {
			return setResultError("密码不能为空.");
		}

		String newPassword = MD5Util.MD5(password);
		user.setPassword(newPassword);
		Integer result = memberDao.insertUser(user);
		if (result <= 0) {
			return setResultError("添加用户信息失败.");
		}

		// 采用异步方式发送消息
//		String email = user.getEmail();
//		String json = emailJson(email);
//		log.info("####会员服务推送消息到消息服务平台####json:{}", json);
//		sendMsg(json);

		return setResultSuccess("用户添加成功.");

	}

	private String emailJson(String email) {

		JSONObject rootJson = new JSONObject();
		JSONObject header = new JSONObject();
		header.put("interfaceType", Constants.MSG_EMAIL);
		JSONObject content = new JSONObject();
		content.put("email", email);
		rootJson.put("header", header);
		rootJson.put("content", content);
		return rootJson.toJSONString();

	}

	private void sendMsg(String json) {

		ActiveMQQueue activeMQQueue = new ActiveMQQueue(MESSAGESQUEUE);
		registerMailboxProducer.sendMsg(activeMQQueue, json);

	}

	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	@Override
	@HystrixCommand(fallbackMethod="hystrixFallback")
	public ResponseBase login(ReqUser user) {
		// 1.验证参数
		String username = user.getAccount();
		if (StringUtils.isEmpty(username)) {
			return setResultError("用戶名称不能为空!");
		}
		String password = user.getPassword();
		if (StringUtils.isEmpty(password)) {
			return setResultError("密码不能为空!");
		}
		// 2.数据库查找账号密码是否正确
//		String newPassWrod = MD5Util.MD5(password);
		UserEntity userEntity = memberDao.login(username, password);
		if (userEntity == null) {
			return setResultError("账号或者密码不正确");
		}
		// 3.如果账号密码正确，对应生成token
		String memberToken = TokenUtils.getMemberToken();
		// 4.存放在redis中，key为token value 为 userid
		Integer userId = userEntity.getId();
		log.info("####用户信息token存放在redis中... key为:{},value", memberToken, userId);
		baseRedisService.setString(String.valueOf(userId), memberToken, Constants.TOKEN_MEMBER_TIME);
		// 5.直接返回token
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("memberToken", memberToken);

		userEntity.setRCToken(memberToken);

//		String json = emailJson("我是谁");
//		sendMsg(json);

		return setResultSuccess(userEntity);

	}

	@Override
	@HystrixCommand(fallbackMethod="hystrixFallback")
	public ResponseBase findByTokenUser(String token) {
		// 1.验证参数
		if (StringUtils.isEmpty(token)) {
			return setResultError("token不能为空!");
		}
		// 2.从redis中 使用token 查找对应 userid
		String strUserId = (String) baseRedisService.getString(token);
		if (StringUtils.isEmpty(strUserId)) {
			return setResultError("token无效或者已经过期!");
		}
		// 3.使用userid数据库查询用户信息返回给客户端
		Long userId = Long.parseLong(strUserId);
		UserEntity userEntity = memberDao.findByID(userId);
		if (userEntity == null) {
			return setResultError("为查找到该用户信息");
		}
		userEntity.setPassword(null);
		return setResultSuccess(userEntity);

	}

	/**
	 * 修改密码
	 * @param changePassword
	 * @return
	 */
	@Override
	@HystrixCommand(fallbackMethod="hystrixFallback")
	public ResponseBase changePassword(ChangePassword changePassword) {

		if (StringUtils.isEmpty(String.valueOf(changePassword.getMemberId()))) {
			return setResultError("MemberId不能为空!");
		}
		if (StringUtils.isEmpty(changePassword.getOldLoginPwd())) {
			return setResultError("OldLoginPwd不能为空!");
		}
		if (StringUtils.isEmpty(changePassword.getNewLoginPwd())) {
			return setResultError("NewLoginPwd不能为空!");
		}
		UserEntity userEntity = memberDao.findByID( changePassword.getMemberId());
		if(changePassword.getOldLoginPwd().equals(userEntity.getPassword())){
			// 密码相同
            memberDao.changePassword(changePassword.getMemberId(),changePassword.getNewLoginPwd());
            return setResultSuccess("修改成功");
		}else {
			// 密码不相同
			return setResultError("用户名密码不一致，没更新的权限");

		}
	}

	@Override
	@HystrixCommand(fallbackMethod="hystrixFallback")
	public ResponseBase FindAllUser(Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		Page<UserEntity> userEntities = memberDao.findAll();
		if (userEntities == null) {
			return setResultError("未查找到角色信息.");
		}
		return setResultSuccess(userEntities);
	}


	public ResponseBase hystrixFallback() {
		return setResultError("请求失败.");
	}


}
