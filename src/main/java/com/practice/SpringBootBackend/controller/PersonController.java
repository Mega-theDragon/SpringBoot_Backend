package com.practice.SpringBootBackend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.SpringBootBackend.model.Person;
import com.practice.SpringBootBackend.service.PersonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/people")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    // GET

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping("/{id}")
    public Person getPersonByID(@PathVariable int id){
        return personService.getPersonByID(id);
    }

    @GetMapping("/sort")
    public List<Person> getSortedPersonList(@RequestParam(defaultValue = "id") String parameter){
        return personService.getSortedPersonList(parameter);
    }

    @GetMapping("/weight/{value}")
    public List<Person> getPeopleByWeight(@PathVariable double value, @RequestParam(defaultValue = "greater") String range){
        return personService.getPeopleByWeight(value, range);
    }

    @GetMapping("/customQuery")
    public List<Person> getCustomQueryData(){
        return personService.executeCustomQuery();
    }

    // ADD

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    // UPDATE

    @PutMapping
    public void updatePerson(@RequestBody Person person){
        personService.updatePerson(person);
    }

    // DELETE

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable int id){
        personService.deletePerson(id);
    }

    
}
