package com.practice.SpringBootBackend.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.SpringBootBackend.model.Person;
import com.practice.SpringBootBackend.service.PersonService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/people")
@AllArgsConstructor
public class PersonController {

    private PersonService personService;

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }
    
}
