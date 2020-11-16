package com.github.curriculeon.bintest;

import com.github.curriculeon.Bin;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorTest {
    @Test
    public void test1() {
        test(null);
    }


    @Test
    public void test2() {
        test(2);
    }


    @Test
    public void test3() {
        test(3);
    }

    @Test
    public void test4() {
        test(99);
    }

    private void test(Integer expectedFaceValueToTrack) {
        Integer expectedNumberOfOccurrences = 0;

        // when
        Bin bin = new Bin(expectedFaceValueToTrack);
        Integer actualValueToTrack = bin.getFaceValueToTrack();
        Integer actualNumberOfOccurrences = bin.getNumberOfOccurrences();

        // then
        Assert.assertEquals(expectedFaceValueToTrack, actualValueToTrack);
        Assert.assertEquals(expectedNumberOfOccurrences, actualNumberOfOccurrences);

    }
}
