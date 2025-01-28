package com.practice.SpringBootBackend.service;

import java.util.ArrayList;
import java.util.List;
import com.practice.SpringBootBackend.model.Person;
import com.practice.SpringBootBackend.repository.PersonRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    // GET

    public List<Person> getAllPeople(){
        return repository.findAll();
    }

    public Person getPersonByID(int id){
        return repository.findById(id).orElse(new Person());
    }

    public List<Person> getSortedPersonList(String parameter){
        List<Person> sortedList;
        try{
            sortedList = repository.findAll(Sort.by(parameter).descending());
        }catch(Exception e){
            sortedList = new ArrayList<>();
        }

        return sortedList;
    }

    public List<Person> getPeopleByWeight(double weight, String range){
        List<Person> people;

        if(range.equals("greater")){
            people = repository.findPeopleByWeightGreaterThan(weight);
        }else if(range.equals("lower")){
            people = repository.findPeopleByWeightLessThan(weight);
        }else{
            people = new ArrayList<>();
        }

        return people;
    }

    public List<Person> executeCustomQuery(){
        return repository.findPeopleByCustomQuery();
    }

    // ADD

    public void addPerson(Person person){
        repository.save(person);
    }

    // UPDATE

    public void updatePerson(Person person){
        repository.save(person);
    }

    // DELETE

    public void deletePerson(int id){
        Person person = getPersonByID(id);

        repository.delete(person);
    }
    
}
