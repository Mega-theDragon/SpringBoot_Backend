package com.practice.SpringBootBackend.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice.SpringBootBackend.model.MyUser;
import com.practice.SpringBootBackend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public MyUser registerUser(MyUser user){
        String password = user.getPassword();
        String encodedPassword = bCryptPasswordEncoder.encode(password);

        user.setPassword(encodedPassword);
        
        return userRepository.save(user);
    }

    public String verifyUser(MyUser user){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if(!authentication.isAuthenticated()){
            return "User not authenticated";
        }

        return jwtService.generateJWT(user.getUsername());
    }

}
