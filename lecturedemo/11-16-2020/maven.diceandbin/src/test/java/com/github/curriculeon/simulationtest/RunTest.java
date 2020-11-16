package com.github.curriculeon.simulationtest;

import com.github.curriculeon.Bin;
import com.github.curriculeon.Bins;
import com.github.curriculeon.Simulation;
import org.junit.Assert;
import org.junit.Test;

public class RunTest {
    private void test(Integer numberOfDie, Integer numberOfTosses) {
        // given
        Simulation simulation = new Simulation(numberOfDie, numberOfTosses);

        // when
        simulation.run();
        Bins bins = simulation.getBins();
        Bin[] binArray = bins.getBins();

        // then
        Integer totalNumberOfOccurrences = 0;
        for (int currentIndex = 0; currentIndex < binArray.length; currentIndex++) {
            Bin bin = binArray[currentIndex];
            Integer numberOfOccurrences = bin.getNumberOfOccurrences();
            totalNumberOfOccurrences += numberOfOccurrences;
        }

        // ensure number of total occurrences is equal to number of total tosses
        Assert.assertEquals(numberOfTosses, totalNumberOfOccurrences);
    }


    @Test(expected = NullPointerException.class)
    public void test0() {
        test(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void test1() {
        test(1, null);
    }

    @Test(expected = NullPointerException.class)
    public void test2() {
        test(null, 1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test3() {
        test(0, null);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test4() {
        test(0, 0);
    }

    @Test(expected = OutOfMemoryError.class)
    public void test5() {
        test(Integer.MAX_VALUE, Integer.MIN_VALUE);
    }


    @Test(expected = NegativeArraySizeException.class)
    public void test6() {
        test(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @Test
    public void test7() {
        test(3, 4);
    }

    @Test
    public void test8() {
        test(4, 3);
    }


    @Test
    public void test9() {
        test(8, 23);
    }

    @Test
    public void test10() {
        test(1, 99);
    }

    @Test
    public void test11() {
        test(99, 1);
    }

    @Test
    public void test12() {
        test(99, 1);
    }

    @Test
    public void test13() {
        test(99, 10);
    }

    @Test
    public void test14() {
        test(9999, 2);
    }

    @Test
    public void test15() {
        test(9999, 5);
    }

    @Test
    public void test16() {
        test(3, 999);
    }

    @Test
    public void test17() {
        test(3, 9999);
    }

    @Test
    public void test18() {
        test(3, 99999);
    }

    @Test
    public void test19() {
        test(3, 999999);
    }

    @Test
    public void test20() {
        test(3, 9999999);
    }


    @Test
    public void test21() {
        test(5, 9999999);
    }


    @Test
    public void test22() {
        test(8, 9999999);
    }

    @Test
    public void test23() {
        test(11, 9999999);
    }

}
