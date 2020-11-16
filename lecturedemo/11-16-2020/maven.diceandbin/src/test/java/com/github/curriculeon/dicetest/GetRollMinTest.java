package com.github.curriculeon.dicetest;

import com.github.curriculeon.Dice;
import org.junit.Assert;
import org.junit.Test;

public class GetRollMinTest {
    @Test
    public void test1() {
        // given
        Integer numberOfFaces = 1;
        Integer expected = 0;

        // when
        Dice dice = new Dice(expected, numberOfFaces);

        // then
        Integer actual = dice.getRollMin();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        // given
        Integer numberOfFaces = 1;
        Integer expected = 1;

        // when
        Dice dice = new Dice(expected, numberOfFaces);

        // then
        Integer actual = dice.getRollMin();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        // given
        Integer numberOfFaces = 1;
        Integer expected = 2;

        // when
        Dice dice = new Dice(expected, numberOfFaces);

        // then
        Integer actual = dice.getRollMin();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        // given
        Integer numberOfFaces = 2;
        Integer expected = 3;

        // when
        Dice dice = new Dice(expected, numberOfFaces);

        // then
        Integer actual = dice.getRollMin();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        // given
        Integer numberOfFaces = 2;
        Integer expected = 4;

        // when
        Dice dice = new Dice(expected, numberOfFaces);

        // then
        Integer actual = dice.getRollMin();
        Assert.assertEquals(expected, actual);
    }






}
