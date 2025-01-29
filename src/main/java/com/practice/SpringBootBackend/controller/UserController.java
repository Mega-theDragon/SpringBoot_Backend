package com.practice.SpringBootBackend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.SpringBootBackend.model.MyUser;
import com.practice.SpringBootBackend.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    
    @PostMapping("/register")
    public MyUser registerUser(@RequestBody MyUser user){
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody MyUser user){
        return userService.verifyUser(user);
    }

}
