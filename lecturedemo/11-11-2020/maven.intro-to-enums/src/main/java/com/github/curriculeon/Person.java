package com.github.curriculeon;

import java.util.Date;

public enum Person {
    LEON(0l, "Leon", "Hunter", new Date()),
    FRED(1L, "Fred", "Zirdung", new Date()),
    DAVID(2l, "David", "S", new Date());

    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;

    Person() {
    }

    Person(Long id, String firstName, String lastName, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
