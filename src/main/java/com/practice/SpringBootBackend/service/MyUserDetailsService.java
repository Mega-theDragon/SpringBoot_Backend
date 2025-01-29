package com.practice.SpringBootBackend.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practice.SpringBootBackend.model.MyUser;
import com.practice.SpringBootBackend.model.MyUserDetails;
import com.practice.SpringBootBackend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService{

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user = userRepository.findUserByUsername(username);

        if(user == null){
            String message = "Username " + username + " was not found";

            System.out.println(message);
            throw new UsernameNotFoundException(message);
        }

        return new MyUserDetails(user);
    }
    
}
