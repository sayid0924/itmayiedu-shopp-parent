package com.itmayiedu.api.service;


import com.apidoc.annotation.*;
import com.apidoc.enumeration.DataType;
import com.apidoc.enumeration.Method;
import com.apidoc.enumeration.ParamType;
import com.itmayiedu.base.ResponseBase;
import com.itmayiedu.entity.DeviceManage.DeviceEntity;

import org.springframework.web.bind.annotation.RequestMapping;

@Api(name = "设备管理", order = 3)
@RequestMapping("/device")
public interface DeviceService {

    @ApiAction(name = "添加设备", mapping = "device/add", method = Method.GET)
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
    ResponseBase DeviceAdd(DeviceEntity deviceEntity);


    @ApiAction(name = "删除设备", mapping = "device/delete", method = Method.GET)
    // 请求参数
    @ApiReqParams(type = ParamType.JSON, value = {

            @ApiParam(name = "deviceId", dataType = DataType.STRING, description = "设备Id", required = true)

    })
    // 返回参数
    @ApiRespParams({
            @ApiParam(name = "code", dataType = DataType.NUMBER, defaultValue = "0", description = "状态编码"),
            @ApiParam(name = "message", dataType = DataType.STRING, defaultValue = "操作成功", description = "提示信息"),
    })
    // 删除设备
    @RequestMapping("/delete")
    ResponseBase DeviceDelete(Long deviceId);



    @ApiAction(name = "查找单个设备信息", mapping = "device/find", method = Method.GET)
    // 请求参数
    @ApiReqParams(type = ParamType.JSON, value = {

            @ApiParam(name = "deviceId", dataType = DataType.STRING, description = "设备Id", required = true)

    })
    // 返回参数
    @ApiRespParams({
            @ApiParam(name = "code", dataType = DataType.NUMBER, defaultValue = "0", description = "状态编码"),
            @ApiParam(name = "message", dataType = DataType.STRING, defaultValue = "操作成功", description = "提示信息"),

            @ApiParam(name = "data", dataType = DataType.OBJECT, defaultValue = "null", description = "响应数据", object = "user"),
            @ApiParam(name = "deviceno", dataType = DataType.STRING, description = "设备号", required = true,belongTo = "user"),
            @ApiParam(name = "deviceip", dataType = DataType.STRING, description = "设备Ip", required = true,belongTo = "user"),
            @ApiParam(name = "deviceclass", dataType = DataType.STRING, description = "设备科室", required = true,belongTo = "user"),
            @ApiParam(name = "devicearea", dataType = DataType.STRING, description = "设备区域", required = true,belongTo = "user"),
            @ApiParam(name = "devicelocation", dataType = DataType.STRING, description = "设备位置", required = true,belongTo = "user"),
            @ApiParam(name = "devicestart", dataType = DataType.STRING, description = "设备状态", required = true,belongTo = "user")

    })
    // 查找单个设备信息
    @RequestMapping("/find")
    ResponseBase DeviceFind(Long deviceId);


    @ApiAction(name = "更新单个设备信息", mapping = "device/update", method = Method.GET)
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
    // 更新单个设备信息
    @RequestMapping("/update")
    ResponseBase DeviceUpdate(DeviceEntity deviceEntity);


}
