package com.practice.SpringBootBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.SpringBootBackend.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
    
}
