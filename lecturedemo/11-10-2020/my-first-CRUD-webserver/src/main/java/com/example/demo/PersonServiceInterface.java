package com.example.demo;

import java.util.List;

public interface PersonServiceInterface {
    List<Person> readAll();

    Person read(Long id);

    Person create(Person person);

    Person updateById(Long id, Person personData);

    Person deleteById(Long id);
}
