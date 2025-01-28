package com.practice.SpringBootBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.SpringBootBackend.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

    public List<Person> findPeopleByWeightGreaterThan(double weight);

    public List<Person> findPeopleByWeightLessThan(double weight);

    @Query("select p from Person p where p.name like '%a%' order by p.height asc")
    public List<Person> findPeopleByCustomQuery();
    
}
