package com.practice.SpringBootBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    private int id;
    private String name;
    private int age;
    private String profession;
    private double height;
    private double weight;
    
}
