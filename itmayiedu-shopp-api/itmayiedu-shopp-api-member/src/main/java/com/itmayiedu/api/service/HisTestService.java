package com.itmayiedu.api.service;


import com.apidoc.annotation.*;
import com.apidoc.enumeration.DataType;
import com.apidoc.enumeration.Method;
import com.apidoc.enumeration.ParamType;

import org.springframework.web.bind.annotation.RequestMapping;
@Api(name = "医院His系统", order = 10)
@RequestMapping("/his")
public interface HisTestService {

    @ApiAction(name = "医院His系统", mapping = "his/test", method = Method.GET)
    // 请求参数
    @ApiReqParams(type = ParamType.JSON, value = {
            @ApiParam(name = "deviceno", dataType = DataType.STRING, description = "设备号", required = true),
    })
    // 返回参数
    @ApiRespParams({
            @ApiParam(name = "code", dataType = DataType.NUMBER, defaultValue = "0", description = "状态编码"),
            @ApiParam(name = "message", dataType = DataType.STRING, defaultValue = "操作成功", description = "提示信息"),
    })
    @RequestMapping("/test")
    String Histest();

}
