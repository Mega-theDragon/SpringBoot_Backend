package com.practice.SpringBootBackend.services;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    
    public String sayHello(){
        return "Hello there";
    }
}
