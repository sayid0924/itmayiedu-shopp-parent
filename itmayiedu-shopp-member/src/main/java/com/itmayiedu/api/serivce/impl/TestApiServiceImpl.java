package com.itmayiedu.api.serivce.impl;

import com.itmayiedu.api.service.TestApiService;
import com.itmayiedu.base.BaseApiService;
import com.itmayiedu.base.ResponseBase;
import com.itmayiedu.dao.TestDao;
import com.itmayiedu.mybatis.model.Mbtest;
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
	public ResponseBase testResponseBase(Mbtest mbtest) {
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
