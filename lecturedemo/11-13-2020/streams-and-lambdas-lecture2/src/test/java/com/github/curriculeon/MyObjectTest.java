package com.github.curriculeon;

import org.junit.Assert;
import org.junit.Test;

public class MyObjectTest {
    @Test
    public void testRun() { // TODO
        // Given
        StringManipulator myObject = new StringManipulator("");

        // when
//        myObject.run();

        //then
        Assert.assertNotNull(myObject.toString());
    }
}
