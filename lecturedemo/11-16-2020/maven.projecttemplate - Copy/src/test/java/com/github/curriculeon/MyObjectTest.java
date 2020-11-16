package com.github.curriculeon;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MyObjectTest {
    @Test
    public void testArrayOfPerson() {
        // given
        int key = 1;
        Person person1 = new Person("Leon");
        Person expected = new Person("Hunter");
        Person[] personArray = new Person[2];
        personArray[0] = person1;
        personArray[key] = expected;

        // when
        Person actual = personArray[key];

        // then
        System.out.println(Arrays.toString(personArray));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMapIntegerToPerson() { // TODO
        int key = 1;
        Map<Number, Person> map = new HashMap<>();
        Person person1 = new Person("Leon");
        Person expected = new Person("Hunter");
        map.put(0, person1);
        map.put(key, expected);

        // when
        Person actual = map.get(key);

        // then
        System.out.println(map);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testMapStringToPerson() { // TODO
        String key = "The Quick Brown Fox";
        Map<String, Person> map = new HashMap<>();
        Person person1 = new Person("Leon");
        Person expected = new Person("Hunter");
        map.put("Jumps over the lazy dog", person1);
        map.put(key, expected);

        // when
        Person actual = map.get(key);


        // then
        System.out.println(map);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMapPhoneNumberToPerson() { // TODO
        PhoneNumber key = new PhoneNumber("515-444-2344");
        PhoneNumber phoneNumber = new PhoneNumber("515-444-2314");

        Map<PhoneNumber, Person> map = new HashMap<>();
        Person person1 = new Person("Leon");
        Person expected = new Person("Hunter");
        map.put(phoneNumber, person1);
        map.put(key, expected);

        // when
        Person actual = map.get(key);

        // then
        System.out.println(map);
        Assert.assertEquals(expected, actual);
    }
}
