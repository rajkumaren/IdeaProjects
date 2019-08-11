package com.demo.hackathon.com.demo.hackathon.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class RipperService {

    @Autowired
    RestTemplate restTemplate;



    public String getSwaggerJson(){
        //https://petstore.swagger.io/v2/swagger.json
        //www.google.com
        //





        String json =  restTemplate.exchange("https://www.google.com", HttpMethod.GET,null,String.class, (Object) null).toString();
        return json;
        //return null;
    }

}
