package com.practice.SpringBootBackend.service;

import java.util.List;
import com.practice.SpringBootBackend.model.Person;
import com.practice.SpringBootBackend.repository.PersonRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public List<Person> getAllPeople(){
        return repository.findAll();
    }

    public Person getPersonByID(int id){
        return repository.findById(id).orElse(new Person());
    }

    public void addPerson(Person person){
        repository.save(person);
    }

    public void updatePerson(Person person){
        repository.save(person);
    }

    public void deletePerson(int id){
        Person person = getPersonByID(id);

        repository.delete(person);
    }
    
}
