package com.github.curriculeon;

import java.util.Date;

public class MainApplication {
    public static void main(String[] args) {
        Person leonPersonObject = Person.LEON;
        Person fredPersonObject = Person.FRED;
        Person davidPersonObject = Person.DAVID;

        Person[] personEnumerations = Person.values();
        for (int i = 0; i < personEnumerations.length; i++) {
            Person personEnumeration = personEnumerations[i];
            String strRepresentation = personEnumeration.toString();
            System.out.println(strRepresentation);
        }

        Person somePerson = Person.valueOf("LEON");
        Person.LEON.setBirthDate(new Date());
    }
}
