package com.practice.SpringBootBackend.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice.SpringBootBackend.model.MyUser;
import com.practice.SpringBootBackend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public MyUser registerUser(MyUser user){
        String password = user.getPassword();
        String encodedPassword = bCryptPasswordEncoder.encode(password);

        user.setPassword(encodedPassword);
        
        return userRepository.save(user);
    }

}
