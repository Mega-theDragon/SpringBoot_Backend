package com.practice.SpringBootBackend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.SpringBootBackend.services.HelloService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class HelloController {

    HelloService helloService;
    
    @RequestMapping("/hello")
    public String sayHello(){
        return helloService.sayHello();
    }

}
