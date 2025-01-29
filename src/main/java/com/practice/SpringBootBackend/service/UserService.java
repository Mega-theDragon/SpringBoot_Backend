package com.practice.SpringBootBackend.service;

import org.springframework.stereotype.Service;

import com.practice.SpringBootBackend.model.MyUser;
import com.practice.SpringBootBackend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;

    public MyUser registerUser(MyUser user){
        return userRepository.save(user);
    }

}
