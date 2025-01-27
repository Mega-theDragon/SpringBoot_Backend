package com.practice.SpringBootBackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {

    String name;
    int age;
    String profession;
    double height;
    double weight;
    
}
