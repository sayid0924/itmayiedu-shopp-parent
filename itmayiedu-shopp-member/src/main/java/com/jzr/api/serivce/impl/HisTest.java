package com.jzr.api.serivce.impl;


import com.jzr.api.service.HisTestService;
import com.jzr.netty.base.ResponseBase;
import com.jzr.utils.HttpClient;
import com.jzr.netty.base.BaseApiService;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HisTest extends BaseApiService implements HisTestService {

    @Autowired
    private HttpClient httpClient;

    @Override
    @HystrixCommand(fallbackMethod="hystrixFallback")
    public String Histest() {
        String url ="http://172.16.0.125:10019/EaiServer";
        HttpMethod method = HttpMethod.GET;
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        String req=  httpClient.client(url,method,params);
        return httpClient.client(url,method,params);
    }


    public ResponseBase hystrixFallback() {
        return setResultError("请求失败.");
    }

}
