package com.jzr.api.serivce.impl;


import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzr.api.service.RoleManagementService;
import com.jzr.netty.base.BaseApiService;
import com.jzr.netty.base.ResponseBase;
import com.jzr.dao.RoleManageDao;
import com.jzr.entity.RoleManage.RoleEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RoleManageServiceImpl extends BaseApiService implements RoleManagementService {

    @Autowired
    private RoleManageDao roleManageDao;

    public ResponseBase hystrixFallback(RoleEntity roleAdd) {
        return setResultError("请求失败.");
    }

    /**
     * 角色添加
     *
     * @param roleAdd
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "hystrixFallback")
    public ResponseBase RolemanageAdd(RoleEntity roleAdd) {

        if (StringUtils.isEmpty(roleAdd.getRoleName())) {
            return setResultError("RoleName不能为空.");
        }
        if (StringUtils.isEmpty(roleAdd.getRoleType())) {
            return setResultError("RoleType不能为空.");
        }
        if(roleAdd.getRoleLeve()==null){
            roleAdd.setRoleLeve(0);
        }
        if(roleAdd.getRoleDisable()==null){
            roleAdd.setRoleDisable(0);
        }

        Integer result = roleManageDao.insertUser(roleAdd);
        if (result <= 0) {
            return setResultError("添加失败.");
        }
        return setResultSuccess("添加成功");
    }

    /**
     * 删除角色
     *
     * @param RoleId
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "hystrixFallback")
    public ResponseBase RolemanageDelete(Long RoleId) {
        if (RoleId == null) {
            return setResultError("RoleId不能为空.");
        }
        Integer result = roleManageDao.delete(RoleId);
        if (result <= 0) {
            return setResultError("删除失败.");
        }
        return setResultSuccess("删除成功");
    }

    /**
     * 禁用角色
     *
     * @param RoleId
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "hystrixFallback")
    public ResponseBase RolemanageDisable(Long RoleId) {
        if (RoleId == null) {
            return setResultError("RoleId不能为空.");
        }
        roleManageDao.roleDisable(RoleId);
        return setResultSuccess("禁用角色成功");

    }

    /**
     * 查找单个角色
     *
     * @param RoleId
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "hystrixFallback")
    public ResponseBase RolemanageFind(Long RoleId) {
        RoleEntity role = roleManageDao.findByID(RoleId);
        if (role == null) {
            return setResultError("未查找到角色信息.");
        }
        return setResultSuccess(role);
    }

    /**
     * 分页查找角色
     *
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "hystrixFallback")
    public ResponseBase RolemanageFindAll(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        Page<RoleEntity> role = roleManageDao.findAll();
        if (role == null) {
            return setResultError("未查找到角色信息.");
        }
        return setResultSuccess(role);
    }



}
