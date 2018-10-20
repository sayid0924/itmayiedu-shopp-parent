package com.itmayiedu.api.service;


import com.apidoc.annotation.*;
import com.apidoc.enumeration.DataType;
import com.apidoc.enumeration.Method;
import com.apidoc.enumeration.ParamType;
import com.itmayiedu.base.ResponseBase;
import com.itmayiedu.entity.RoleManage.RoleEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(name = "角色管理", order = 2)
@RequestMapping("/rolemanage")
public interface RoleManagementService {


    @ApiAction(name = "添加角色", mapping = "rolemanage/add", method = Method.GET)
    // 请求参数
    @ApiReqParams(type = ParamType.JSON,  value = {
            @ApiParam(name = "RoleAttributes", dataType = DataType.STRING,  description = "角色属性",required = true),
            @ApiParam(name = "RoleDescribe", dataType = DataType.STRING,  description = "角色描述",required = true),
            @ApiParam(name = "RoleType", dataType = DataType.STRING,  description = "角色类型（科室、病区、医生、护士等）",required = true),
            @ApiParam(name = "RoleName", dataType = DataType.STRING, description = "角色名称",required = true)
    })
    // 返回参数
    @ApiRespParams({
            @ApiParam(name = "code", dataType = DataType.NUMBER, defaultValue = "0", description = "状态编码"),
            @ApiParam(name = "message", dataType = DataType.STRING, defaultValue = "操作成功", description = "提示信息"),
    })
    // 添加角色
    @RequestMapping("/add")
    ResponseBase RolemanageAdd(RoleEntity roleAdd);



    @ApiAction(name = "删除角色", mapping = "rolemanage/delete", method = Method.GET)
    // 请求参数
    @ApiReqParams(type = ParamType.JSON,  value = {
            @ApiParam(name = "RoleId", dataType = DataType.STRING,  description = "角色Id",required = true),
    })
    // 返回参数
    @ApiRespParams({
            @ApiParam(name = "code", dataType = DataType.NUMBER, defaultValue = "0", description = "状态编码"),
            @ApiParam(name = "message", dataType = DataType.STRING, defaultValue = "操作成功", description = "提示信息"),
    })
    //删除角色
    @RequestMapping("/delete")
    ResponseBase RolemanageDelete(Long RoleId);



    @ApiAction(name = "禁用角色", mapping = "rolemanage/disable", method = Method.GET)
    // 请求参数
    @ApiReqParams(type = ParamType.JSON,  value = {
            @ApiParam(name = "RoleId", dataType = DataType.STRING,  description = "角色Id",required = true),
    })
    // 返回参数
    @ApiRespParams({
            @ApiParam(name = "code", dataType = DataType.NUMBER, defaultValue = "0", description = "状态编码"),
            @ApiParam(name = "message", dataType = DataType.STRING, defaultValue = "操作成功", description = "提示信息"),
    })
    //禁用角色
    @RequestMapping("/disable")
    ResponseBase RolemanageDisable(Long RoleId);




    @ApiAction(name = "查找单个角色", mapping = "rolemanage/find", method = Method.GET)
    // 请求参数
    @ApiReqParams(type = ParamType.JSON,  value = {
            @ApiParam(name = "RoleId", dataType = DataType.STRING,  description = "角色Id",required = true),
    })
    // 返回参数
    @ApiRespParams({
            @ApiParam(name = "code", dataType = DataType.NUMBER, defaultValue = "0", description = "状态编码"),
            @ApiParam(name = "message", dataType = DataType.STRING, defaultValue = "操作成功", description = "提示信息"),

            @ApiParam(name = "data", dataType = DataType.OBJECT, defaultValue = "null", description = "响应数据", object = "user"),
            @ApiParam(name = "id", dataType = DataType.NUMBER,description = "角色ID",belongTo = "user"),
            @ApiParam(name = "RoleAttributes", dataType = DataType.STRING,description = "角色属性",belongTo = "user"),
            @ApiParam(name = "RoleDescribe", dataType = DataType.STRING,description = "角色描述",belongTo = "user"),
            @ApiParam(name = "RoleType", dataType = DataType.STRING,description = "角色类型",belongTo = "user"),
            @ApiParam(name = "RoleName", dataType = DataType.STRING,description = "角色名称",belongTo = "user"),
            @ApiParam(name = "RoleDisable", dataType = DataType.NUMBER,description = "是否禁用角色   是否禁用角色:  1 是 0 否 ",belongTo = "user"),
            @ApiParam(name = "RoleLeve", dataType = DataType.NUMBER,description = "角色权限  1000 超级管理员 0 普通护士 1 院长 ",belongTo = "user")
    })
    //查找单个角色
    @RequestMapping("/find")
    ResponseBase RolemanageFind(Long RoleId);


    @ApiAction(name = "分页查找角色", mapping = "rolemanage/findall", method = Method.GET)
    // 请求参数
    @ApiReqParams(type = ParamType.JSON,  value = {
            @ApiParam(name = "pageNo", dataType = DataType.NUMBER,  description = "页码",required = true),
            @ApiParam(name = "pageSize", dataType = DataType.NUMBER,  description = "返回条数",required = true)
    })
    // 返回参数
    @ApiRespParams({
            @ApiParam(name = "code", dataType = DataType.NUMBER, defaultValue = "0", description = "状态编码"),
            @ApiParam(name = "message", dataType = DataType.STRING, defaultValue = "操作成功", description = "提示信息"),

            @ApiParam(name = "data", dataType = DataType.OBJECT, defaultValue = "null", description = "响应数据", object = "user"),
            @ApiParam(name = "id", dataType = DataType.NUMBER,description = "角色ID",belongTo = "user"),
            @ApiParam(name = "RoleAttributes", dataType = DataType.STRING,description = "角色属性",belongTo = "user"),
            @ApiParam(name = "RoleDescribe", dataType = DataType.STRING,description = "角色描述",belongTo = "user"),
            @ApiParam(name = "RoleType", dataType = DataType.STRING,description = "角色类型",belongTo = "user"),
            @ApiParam(name = "RoleName", dataType = DataType.STRING,description = "角色名称",belongTo = "user"),
            @ApiParam(name = "RoleDisable", dataType = DataType.NUMBER,description = "是否禁用角色   是否禁用角色:  1 是 0 否 ",belongTo = "user"),
            @ApiParam(name = "RoleLeve", dataType = DataType.NUMBER,description = "角色权限  1000 超级管理员 0 普通护士 1 院长 ",belongTo = "user")
    })
    //分页查找角色
    @RequestMapping("/findall")
    ResponseBase RolemanageFindAll(Integer pageNo, Integer pageSize);


}
