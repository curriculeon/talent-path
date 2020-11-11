package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Date;

@Configuration
public class PersonConfiguration {
    @Autowired
    private PersonServiceImpl service;

    @PostConstruct
    public void setup() {
        Person person1 = new Person(null, "Leon", new Date());
        Person person2 = new Person(null, "Hunter", new Date());
        service.create(person1);
        service.create(person2);
    }
}
