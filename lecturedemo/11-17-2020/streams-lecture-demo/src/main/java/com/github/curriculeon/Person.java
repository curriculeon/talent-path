package com.github.curriculeon;

public class Person {
    private Double accountBalance;
    private String name;

    public Person(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "accountBalance=" + accountBalance +
                ", name='" + name + '\'' +
                '}';
    }
}
