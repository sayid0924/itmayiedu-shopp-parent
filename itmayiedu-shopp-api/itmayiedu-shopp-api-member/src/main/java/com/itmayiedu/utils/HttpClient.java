package com.itmayiedu.utils;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpClient {

    public  String  client(String url, HttpMethod method, MultiValueMap<String, String> params){
        RestTemplate template = new RestTemplate();

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("key1", "values");
        requestHeaders.add("key2", "ddd");
        HttpEntity<String> requestEntity = new HttpEntity<>(null, requestHeaders);
        ResponseEntity<String> response = template.exchange(url, HttpMethod.POST, requestEntity, String.class, params);
//        String sttr = response.getBody();
//        ResponseEntity<String> responseEntity = template.getForEntity(url,String.class);
//        return  responseEntity.getBody();
        return   response.getBody();

    }
}
