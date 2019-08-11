package com.demo.hackathon.com.demo.hackathon.controller;

import com.demo.hackathon.com.demo.hackathon.service.RipperService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@AllArgsConstructor
public class AppController {


    private final RipperService ripperService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @GetMapping(value = "/update")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {


        ripperService.getSwaggerJson();
        return "hi";
       // return new Greeting(counter.incrementAndGet(),
         //       String.format(template, name));
    }
}