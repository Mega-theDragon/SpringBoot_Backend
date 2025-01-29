package com.practice.SpringBootBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.SpringBootBackend.model.MyUser;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Integer>{
    
    public MyUser findUserByUsername(String username);

}
