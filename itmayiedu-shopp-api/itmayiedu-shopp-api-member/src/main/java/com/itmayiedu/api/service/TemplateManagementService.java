package com.itmayiedu.api.service;


import com.apidoc.annotation.*;
import com.apidoc.enumeration.DataType;
import com.apidoc.enumeration.Method;
import com.apidoc.enumeration.ParamType;
import com.itmayiedu.base.ResponseBase;
import com.itmayiedu.entity.DeviceManage.DeviceEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(name = "模版管理", order = 7)
@RequestMapping("/template")
public interface TemplateManagementService {

    @ApiAction(name = "添加模版", mapping = "template/add", method = Method.GET)
    // 请求参数
    @ApiReqParams(type = ParamType.JSON, value = {
            @ApiParam(name = "deviceno", dataType = DataType.STRING, description = "设备号", required = true),
            @ApiParam(name = "deviceip", dataType = DataType.STRING, description = "设备Ip", required = true),
            @ApiParam(name = "deviceclass", dataType = DataType.STRING, description = "设备科室", required = true),
            @ApiParam(name = "devicearea", dataType = DataType.STRING, description = "设备区域", required = true),
            @ApiParam(name = "devicelocation", dataType = DataType.STRING, description = "设备位置", required = true),
            @ApiParam(name = "devicestart", dataType = DataType.STRING, description = "设备状态", required = true)
    })
    // 返回参数
    @ApiRespParams({
            @ApiParam(name = "code", dataType = DataType.NUMBER, defaultValue = "0", description = "状态编码"),
            @ApiParam(name = "message", dataType = DataType.STRING, defaultValue = "操作成功", description = "提示信息"),
    })
    // 添加设备
    @RequestMapping("/add")
    ResponseBase TemplateAdd(DeviceEntity deviceEntity);



    @ApiAction(name = "删除模版", mapping = "template/delete", method = Method.GET)
    // 请求参数
    @ApiReqParams(type = ParamType.JSON,  value = {
            @ApiParam(name = "RoleId", dataType = DataType.STRING,  description = "角色Id",required = true),
    })
    // 返回参数
    @ApiRespParams({
            @ApiParam(name = "code", dataType = DataType.NUMBER, defaultValue = "0", description = "状态编码"),
            @ApiParam(name = "message", dataType = DataType.STRING, defaultValue = "操作成功", description = "提示信息"),
    })
    //删除模版
    @RequestMapping("/delete")
    ResponseBase TemplateDelete(Long RoleId);



    @ApiAction(name = "查找单个模版", mapping = "template/find", method = Method.GET)
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
    //查找单个模版
    @RequestMapping("/find")
    ResponseBase TemplateFind(Long RoleId);


    @ApiAction(name = "更新模版", mapping = "template/update", method = Method.GET)
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
    //更新模版
    @RequestMapping("/update")
    ResponseBase TemplateUpdate(Long RoleId);

}
