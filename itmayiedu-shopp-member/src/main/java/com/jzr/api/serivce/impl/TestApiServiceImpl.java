package com.jzr.api.serivce.impl;

import com.jzr.api.service.TestApiService;
import com.jzr.netty.base.BaseApiService;
import com.jzr.netty.base.ResponseBase;
import com.jzr.dao.TestDao;
import com.jzr.mybatis.model.MbTest;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@Service
@RestController
public class TestApiServiceImpl  extends BaseApiService implements TestApiService {


    @Autowired
    TestDao testDao;

	@Override
	@HystrixCommand(fallbackMethod="hystrixFallback")
	public Map<String, Object> test(Integer id, String name) {
		Map<String, Object> result = new HashMap<>();
		result.put("rtnCode", "200");
		result.put("rtnMsg", "success");
		result.put("data", "id:" + id + ",name:" + name);
		return result;
	}

	@Override
//	@HystrixCommand(fallbackMethod="hystrixFallback")
	public ResponseBase testResponseBase(MbTest mbtest) {
        testDao.insertUser(mbtest);

		return setResultSuccess();
	}

	@Override
	@HystrixCommand(fallbackMethod="hystrixFallback")
	public ResponseBase settestRedis(String key, String value) {
		baseRedisService.setString(key, value, null);
		return setResultSuccess();
	}




	public ResponseBase hystrixFallback() {
		return setResultError("请求失败.");
	}

}
