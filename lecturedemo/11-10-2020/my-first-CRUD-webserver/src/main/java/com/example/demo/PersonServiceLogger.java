package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServiceLogger implements PersonServiceInterface {
    private PersonServiceInterface serviceImpl;

    @Autowired
    public PersonServiceLogger(PersonServiceInterface serviceImpl) {
        this.serviceImpl = serviceImpl;
    }
    public Logger getLogger() {
        return Logger.getLogger(getClass().getName());
    }

    @Override
    public List<Person> readAll() {
        getLogger().info("Attempting to read all person objects from database");
        List<Person> result =  serviceImpl.readAll();
        getLogger().info("Successfully read all person objects from database");
        getLogger().info("Here is a list of the results:");
        getLogger().info(result.toString());
        return result;
    }

    @Override
    public Person read(Long id) {
        return serviceImpl.read(id);
    }

    @Override
    public Person create(Person person) {
        return serviceImpl.create(person);
    }

    @Override
    public Person updateById(Long id, Person personData) {
        return serviceImpl.updateById(id, personData);
    }

    @Override
    public Person deleteById(Long id) {
        return serviceImpl.deleteById(id);
    }
}
