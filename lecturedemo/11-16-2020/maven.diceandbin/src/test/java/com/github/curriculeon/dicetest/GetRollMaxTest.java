package com.github.curriculeon.dicetest;

import com.github.curriculeon.Dice;
import org.junit.Assert;
import org.junit.Test;

public class GetRollMaxTest {
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test1() {
        // given
        Integer numberOfFaces = 1;
        Integer numberOfDie = 0;
        Integer expected = numberOfDie * numberOfFaces;

        // when
        Dice dice = new Dice(numberOfDie, numberOfFaces);

        // then
        Integer actual = dice.getRollMax();
        Assert.assertEquals(expected, actual);
    }


    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test2() {
        // given
        Integer numberOfFaces = 2;
        Integer numberOfDie = 0;
        Integer expected = numberOfDie * numberOfFaces;

        // when
        Dice dice = new Dice(numberOfDie, numberOfFaces);

        // then
        Integer actual = dice.getRollMax();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void test3() {
        // given
        Integer numberOfFaces = 1;
        Integer numberOfDie = 1;
        Integer expected = numberOfDie * numberOfFaces;

        // when
        Dice dice = new Dice(numberOfDie, numberOfFaces);

        // then
        Integer actual = dice.getRollMax();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void test4() {
        // given
        Integer numberOfFaces = 1;
        Integer numberOfDie = 2;
        Integer expected = numberOfDie * numberOfFaces;

        // when
        Dice dice = new Dice(numberOfDie, numberOfFaces);

        // then
        Integer actual = dice.getRollMax();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void test5() {
        // given
        Integer numberOfFaces = 2;
        Integer numberOfDie = 1;
        Integer expected = numberOfDie * numberOfFaces;

        // when
        Dice dice = new Dice(numberOfDie, numberOfFaces);

        // then
        Integer actual = dice.getRollMax();
        Assert.assertEquals(expected, actual);
    }
}
