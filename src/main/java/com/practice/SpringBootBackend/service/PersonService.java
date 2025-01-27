package com.practice.SpringBootBackend.service;

import java.util.ArrayList;
import java.util.List;
import com.practice.SpringBootBackend.model.Person;

import lombok.Getter;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private List<Person> personList;

    public PersonService(){
        personList = new ArrayList<>();

        personList.add(new Person("John", 21, "Game Developer", 1.85, 75));
        personList.add(new Person("Mark", 25, "Software Engineer", 1.7, 80));
    }

    public List<Person> getAllPeople(){
        return personList;
    }
    
}
