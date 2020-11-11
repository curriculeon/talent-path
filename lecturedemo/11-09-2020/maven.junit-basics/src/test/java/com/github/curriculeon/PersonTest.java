package com.github.curriculeon;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {
    @Test
    public void testSetName() {
        // given
        String expected = "Leon";
        Person person = new Person();

        // when
        person.setName(expected);

        // then
        Assert.assertEquals(expected, person.getName());
    }
}
