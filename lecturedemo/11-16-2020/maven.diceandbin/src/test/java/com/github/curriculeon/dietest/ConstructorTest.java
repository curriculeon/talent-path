package com.github.curriculeon.dietest;

import com.github.curriculeon.Die;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorTest {
    @Test
    public void test1() {
        // given
        Integer expectedFaceValue = null;
        Integer expectedNumberOfFaces = null;

        // when
        Die die = new Die(expectedNumberOfFaces);
        Integer actualFaceValue = die.getCurrentFaceValue();
        Integer actualNumberOfFaces = die.getNumberOfFaces();

        // then
        Assert.assertEquals(expectedFaceValue, actualFaceValue);
        Assert.assertEquals(expectedNumberOfFaces, actualNumberOfFaces);
    }

    @Test
    public void test2() {
        // given
        Integer expectedFaceValue = null;
        Integer expectedNumberOfFaces = 3;

        // when
        Die die = new Die(expectedNumberOfFaces);
        Integer actualFaceValue = die.getCurrentFaceValue();
        Integer actualNumberOfFaces = die.getNumberOfFaces();

        // then
        Assert.assertEquals(expectedFaceValue, actualFaceValue);
        Assert.assertEquals(expectedNumberOfFaces, actualNumberOfFaces);
    }


    @Test
    public void test3() {
        // given
        Integer expectedFaceValue = null;
        Integer expectedNumberOfFaces = 4;

        // when
        Die die = new Die(expectedNumberOfFaces);
        Integer actualFaceValue = die.getCurrentFaceValue();
        Integer actualNumberOfFaces = die.getNumberOfFaces();

        // then
        Assert.assertEquals(expectedFaceValue, actualFaceValue);
        Assert.assertEquals(expectedNumberOfFaces, actualNumberOfFaces);
    }
}
