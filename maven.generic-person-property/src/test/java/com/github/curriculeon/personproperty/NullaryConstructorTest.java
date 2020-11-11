package com.github.curriculeon.personproperty;

import com.github.curriculeon.PersonProperty;
import com.github.curriculeon.PersonPropertyInterface;
import org.junit.Assert;
import org.junit.Test;

public class NullaryConstructorTest {
    @Test
    public void testObject() {
        // given
        Object expected = null;

        // when
        Object personPropertyObject = new PersonProperty();
        PersonPropertyInterface personPropertyInterface = (PersonPropertyInterface)personPropertyObject;
        Object actual = personPropertyInterface.get();

        // then
        Assert.assertEquals(expected, actual);
    }
}
