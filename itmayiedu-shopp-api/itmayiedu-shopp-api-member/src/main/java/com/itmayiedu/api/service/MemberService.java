package com.itmayiedu.api.service;


import com.apidoc.annotation.*;
import com.apidoc.enumeration.DataType;
import com.apidoc.enumeration.Method;
import com.apidoc.enumeration.ParamType;
import com.itmayiedu.entity.req.ChangePassword;
import com.itmayiedu.entity.req.ReqUser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itmayiedu.base.ResponseBase;
import com.itmayiedu.entity.UserEntity;


@Api(name = "用户管理", order = 1)
@RequestMapping("/member")
public interface MemberService {

	// 使用userId查找用户信息
	@RequestMapping("/findUserById")
	ResponseBase findUserById(Long userId);
	// 注册用户
	@RequestMapping("/regUser")
	ResponseBase regUser(@RequestBody UserEntity user);

	@ApiAction(name = "用户登录", mapping = "member/login", method = Method.GET)
	// 请求参数
	@ApiReqParams(type = ParamType.JSON,  value = {
			@ApiParam(name = "account", dataType = DataType.STRING,  description = "帐号",required = true),
			@ApiParam(name = "password", dataType = DataType.STRING, description = "密码",required = true)
	})
	// 返回参数
	@ApiRespParams({
			@ApiParam(name = "code", dataType = DataType.NUMBER, defaultValue = "0", description = "状态编码"),
			@ApiParam(name = "message", dataType = DataType.STRING, defaultValue = "操作成功", description = "提示信息"),
			@ApiParam(name = "datas", dataType = DataType.OBJECT, defaultValue = "null", description = "响应数据", object = "user"),
			@ApiParam(name = "id", dataType = DataType.NUMBER,description = "用户ID",belongTo = "user"),
			@ApiParam(name = "username", dataType = DataType.STRING,description = "用户名",belongTo = "user"),
			@ApiParam(name = "password", dataType = DataType.STRING,description = "密码",belongTo = "user"),
			@ApiParam(name = "phone", dataType = DataType.STRING,description = "手机号码",belongTo = "user"),
			@ApiParam(name = "created", dataType = DataType.STRING,description = "创建时间",belongTo = "user"),
			@ApiParam(name = "updated", dataType = DataType.STRING,description = "更新时间",belongTo = "user"),
			@ApiParam(name = "RCToken", dataType = DataType.STRING,description = "RCToken",belongTo = "user"),
			@ApiParam(name = "email", dataType = DataType.STRING,description = "邮箱",belongTo = "user")
	})
	// 用户登录
	@RequestMapping("/login")
	ResponseBase login(ReqUser user);


    // 使用token进行登录
	@RequestMapping("/findByTokenUser")
	ResponseBase findByTokenUser(String token);


	@ApiAction(name = "修改密码", mapping = "member/changepassword", method = Method.GET)
	// 请求参数
	@ApiReqParams(type = ParamType.JSON,  value = {
			@ApiParam(name = "memberId", dataType = DataType.STRING,  description = "用户ID",required = true),
			@ApiParam(name = "oldLoginPwd", dataType = DataType.STRING,  description = "旧密码",required = true),
			@ApiParam(name = "newLoginPwd", dataType = DataType.STRING, description = "新密码",required = true)
	})
	// 返回参数
	@ApiRespParams({
			@ApiParam(name = "code", dataType = DataType.NUMBER, defaultValue = "0", description = "状态编码"),
			@ApiParam(name = "message", dataType = DataType.STRING, defaultValue = "操作成功", description = "提示信息"),
	})
	// 修改密码
	@RequestMapping("/changepassword")
	ResponseBase changePassword(ChangePassword changePassword);


}
