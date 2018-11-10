package com.itmayiedu.api.service;

import com.apidoc.annotation.*;
import com.apidoc.enumeration.DataType;
import com.apidoc.enumeration.Method;
import com.apidoc.enumeration.ParamType;
import com.itmayiedu.base.ResponseBase;
import com.itmayiedu.mybatis.model.MbTest;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Api(name = "测试模块", order = 11)
@RequestMapping("/member")
public interface TestApiService {
	@RequestMapping("/test")
	public Map<String, Object> test(Integer id, String name);


    @ApiAction(name = "添加模版", mapping = "member/testResponseBase", method = Method.GET)
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
    // 添加
	@RequestMapping("/testResponseBase")
	public ResponseBase testResponseBase(MbTest mbtest);

	@RequestMapping("/testRedis")
	public ResponseBase settestRedis(String key,String value);
}
