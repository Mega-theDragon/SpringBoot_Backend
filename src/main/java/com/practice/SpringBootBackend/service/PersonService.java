package com.practice.SpringBootBackend.service;

import java.util.ArrayList;
import java.util.List;
import com.practice.SpringBootBackend.model.Person;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private List<Person> personList;

    public PersonService(){
        personList = new ArrayList<>();

        personList.add(new Person(0, "John", 21, "Game Developer", 1.85, 75));
        personList.add(new Person(1, "Mark", 25, "Software Engineer", 1.7, 80));
    }

    public List<Person> getAllPeople(){
        return personList;
    }

    public Person getPersonByID(int id){
        return personList.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElse(new Person());
    }

    public void addPerson(Person person){
        personList.add(person);
    }

    public void updatePerson(Person person){
        Person oldPerson = getPersonByID(person.getId());

        int index = personList.indexOf(oldPerson);
        if(index != -1){
            personList.set(personList.indexOf(oldPerson), person);
        }else{
            personList.add(person);
        }
    }

    public void deletePerson(int id){
        Person person = getPersonByID(id);

        personList.remove(person);
    }
    
}
