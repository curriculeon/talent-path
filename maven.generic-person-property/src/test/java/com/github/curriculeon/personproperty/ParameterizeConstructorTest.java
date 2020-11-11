package com.github.curriculeon.personproperty;

import com.github.curriculeon.PersonProperty;
import org.junit.Assert;
import org.junit.Test;

public class ParameterizeConstructorTest {
    @Test
    public void testString() {
        // given
        String expected = "String test";

        // when
        PersonProperty<String> personProperty = new PersonProperty<>(expected);
        String actual = (String)personProperty.getValue();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testInteger() {
        // given
        Integer expected = Integer.MAX_VALUE;

        // when
        PersonProperty<Integer> personProperty = new PersonProperty<>(expected);
        Integer actual = (Integer)personProperty.getValue();

        // then
        Assert.assertEquals(expected, actual);
    }

}