package com.github.curriculeon.persontest;

import com.github.curriculeon.Person;
import com.github.curriculeon.PersonProperty;
import org.junit.Assert;

import java.util.Date;

public class ParameterizedConstructorTest {
    // given
    private void test(Long expectedId, String expectedName, Date expectedBirthDate) {
        // when
        Person person = new Person(expectedId, expectedName, expectedBirthDate);
        PersonProperty idProperty = person.id;
        PersonProperty nameProperty = person.name;
        PersonProperty birthDateProperty = person.birthdate;

        Long actualId =

        Object actual = personProperty.getValue();

        // then
        Assert.assertEquals(expectedId, actual);
    }

}
