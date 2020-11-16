package com.github.curriculeon.dicetest;

import com.github.curriculeon.Dice;
import org.junit.Test;

public class ConstructorTest {
    @Test(expected = NullPointerException.class)
    public void test0() {
        // given
        // when
        Dice dice = new Dice(null, null);
    }

}
