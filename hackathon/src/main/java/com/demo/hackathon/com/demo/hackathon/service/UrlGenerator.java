package com.demo.hackathon.com.demo.hackathon.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UrlGenerator {



    public String getURLString(String region, String env, String app){

        String region1 = region.equalsIgnoreCase("cn")?"cn":"";
        String preprodhost = region.equalsIgnoreCase("cn")?"pp01.cf.ford.com.cn":"pp01.cf.ford.com";
        String api_docs = "/v2/api-docs";
        return new StringBuffer().append("https://").append(app).append("-").append(env).append(".")
                .append(region)
                .append(preprodhost)
                .append(app)
                .append(api_docs).toString();
    }
}
