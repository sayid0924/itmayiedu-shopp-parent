package com.itmayiedu.api.service;


import com.apidoc.annotation.*;
import com.apidoc.enumeration.DataType;
import com.apidoc.enumeration.Method;
import com.apidoc.enumeration.ParamType;
import com.itmayiedu.base.ResponseBase;
import com.itmayiedu.entity.DeviceManage.DeviceEntity;
import com.itmayiedu.entity.RommCardManage.RoomCardEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(name = "医生诊室门卡管理", order = 4)
@RequestMapping("/doctorroomcard")
public interface DoctorRoomCardService {


    @ApiAction(name = "添加医生诊室门卡", mapping = "doctorroomcard/add", method = Method.GET)
    // 请求参数
    @ApiReqParams(type = ParamType.JSON, value = {
            @ApiParam(name = "roomName", dataType = DataType.STRING, description = "诊室名称", required = true),
            @ApiParam(name = "roomInfo", dataType = DataType.STRING, description = "诊室信息", required = true),
            @ApiParam(name = "roomDeviceIp", dataType = DataType.STRING, description = "诊室门卡IP", required = true),
            @ApiParam(name = "roomDeviceMac", dataType = DataType.STRING, description = "诊室门卡Mac", required = true),
            @ApiParam(name = "roomDoctor", dataType = DataType.STRING, description = "诊室医生", required = true),
            @ApiParam(name = "roomNurse", dataType = DataType.STRING, description = "诊室护士", required = true),
            @ApiParam(name = "roomLocation", dataType = DataType.STRING, description = "诊室位置", required = true),
            @ApiParam(name = "roomDescribe", dataType = DataType.STRING, description = "诊室描述", required = true)

    })
    // 返回参数
    @ApiRespParams({
            @ApiParam(name = "code", dataType = DataType.NUMBER, defaultValue = "0", description = "状态编码"),
            @ApiParam(name = "message", dataType = DataType.STRING, defaultValue = "操作成功", description = "提示信息"),
    })
    // 添加医生诊室门卡
    @RequestMapping("/add")
    ResponseBase DoctorRoomCardAdd(DeviceEntity deviceEntity);

    @ApiAction(name = "删除医生诊室门卡", mapping = "doctorroomcard/delete", method = Method.GET)
    // 请求参数
    @ApiReqParams(type = ParamType.JSON, value = {
            @ApiParam(name = "roomId", dataType = DataType.STRING, description = "诊室Id", required = true)
    })
    // 返回参数
    @ApiRespParams({
            @ApiParam(name = "code", dataType = DataType.NUMBER, defaultValue = "0", description = "状态编码"),
            @ApiParam(name = "message", dataType = DataType.STRING, defaultValue = "操作成功", description = "提示信息"),
    })
    // 删除医生诊室门卡
    @RequestMapping("/delete")
    ResponseBase DoctorRoomCardDelete(Long roomId);


    @ApiAction(name = "查找单个医生诊室门卡", mapping = "doctorroomcard/find", method = Method.GET)
    // 请求参数
    @ApiReqParams(type = ParamType.JSON, value = {
            @ApiParam(name = "deviceId", dataType = DataType.STRING, description = "设备Id", required = true)
    })
    // 返回参数
    @ApiRespParams({
            @ApiParam(name = "code", dataType = DataType.NUMBER, defaultValue = "0", description = "状态编码"),
            @ApiParam(name = "message", dataType = DataType.STRING, defaultValue = "操作成功", description = "提示信息"),

            @ApiParam(name = "data", dataType = DataType.OBJECT, defaultValue = "null", description = "响应数据", object = "roomcard"),
            @ApiParam(name = "id", dataType = DataType.NUMBER, description = "诊室id", required = true, belongTo = "roomcard"),
            @ApiParam(name = "roomName", dataType = DataType.STRING, description = "诊室名称", required = true, belongTo = "roomcard"),
            @ApiParam(name = "roomInfo", dataType = DataType.STRING, description = "诊室信息", required = true, belongTo = "roomcard"),
            @ApiParam(name = "roomDeviceIp", dataType = DataType.STRING, description = "诊室门卡IP", required = true, belongTo = "roomcard"),
            @ApiParam(name = "roomDeviceMac", dataType = DataType.STRING, description = "诊室门卡Mac", required = true, belongTo = "roomcard"),
            @ApiParam(name = "roomDoctor", dataType = DataType.STRING, description = "诊室医生", required = true, belongTo = "roomcard"),
            @ApiParam(name = "roomNurse", dataType = DataType.STRING, description = "诊室护士", required = true, belongTo = "roomcard"),
            @ApiParam(name = "roomLocation", dataType = DataType.STRING, description = "诊室位置", required = true, belongTo = "roomcard"),
            @ApiParam(name = "roomDescribe", dataType = DataType.STRING, description = "诊室描述", required = true, belongTo = "roomcard")


    })
    // 查找单个医生诊室门卡
    @RequestMapping("/find")
    ResponseBase DoctorRoomCardFind(Long deviceId);


    @ApiAction(name = "更新单个医生诊室门卡", mapping = "doctorroomcard/update", method = Method.GET)
    // 请求参数
    @ApiReqParams(type = ParamType.JSON, value = {

            @ApiParam(name = "roomName", dataType = DataType.STRING, description = "诊室名称", required = true),
            @ApiParam(name = "roomInfo", dataType = DataType.STRING, description = "诊室信息", required = true),
            @ApiParam(name = "roomDeviceIp", dataType = DataType.STRING, description = "诊室门卡IP", required = true),
            @ApiParam(name = "roomDeviceMac", dataType = DataType.STRING, description = "诊室门卡Mac", required = true),
            @ApiParam(name = "roomDoctor", dataType = DataType.STRING, description = "诊室医生", required = true),
            @ApiParam(name = "roomNurse", dataType = DataType.STRING, description = "诊室护士", required = true),
            @ApiParam(name = "roomLocation", dataType = DataType.STRING, description = "诊室位置", required = true),
            @ApiParam(name = "roomDescribe", dataType = DataType.STRING, description = "诊室描述", required = true)

    })
    // 返回参数
    @ApiRespParams({
            @ApiParam(name = "code", dataType = DataType.NUMBER, defaultValue = "0", description = "状态编码"),
            @ApiParam(name = "message", dataType = DataType.STRING, defaultValue = "操作成功", description = "提示信息"),


    })
    // 更新单个医生诊室门卡
    @RequestMapping("/update")
    ResponseBase DoctorRoomCardUpdate(RoomCardEntity roomCardEntity);



}
