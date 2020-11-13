package com.github.curriculeon;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.function.Supplier;

public class DemonstrateRunnableUsage {
    @Test
    public void testInLine() {
        new MethodTimer().timeMethodInNanoSeconds(() -> {
            String stringToBeManipulated = "The Quick Brown Fox";
            StringManipulator stringManipulator = new StringManipulator(stringToBeManipulated);
            List<String> allSubStrings = stringManipulator.getAllSubStrings();
            System.out.println(allSubStrings);
        });
    }

    @Test
    public void testAsVariable() {
        // given
        Runnable runnable = () -> {
            String stringToBeManipulated = "The Quick Brown Fox";
            StringManipulator stringManipulator = new StringManipulator(stringToBeManipulated);
            List<String> allSubStrings = stringManipulator.getAllSubStrings();
            System.out.println(allSubStrings);
        };
        MethodTimer methodTimer = new MethodTimer();
        Long expectedNanoSeconds = 1500L;

        // when
        Long actualNanoSeconds = methodTimer.timeMethodInNanoSeconds(runnable);

        // then
        Assert.assertEquals(expectedNanoSeconds, actualNanoSeconds, 200);
    }


    @Test
    public void testAsMethodReferenceInline() {
        // given
        String manipulatee = "The Quick Brown Fox";
        StringManipulator stringManipulator = new StringManipulator(manipulatee);
        MethodTimer methodTimer = new MethodTimer();
        Long expectedNanoSeconds = 1500L;
        Supplier<List<String>> result = stringManipulator::getAllSubStrings;
        List<String> resultt = result.get();
        Runnable runnable = ()-> stringManipulator.getAllSubStrings();
        Runnable runnable1 = ()-> System.out.println("Hello world");

        // when
        Long actualNanoSeconds = methodTimer.timeMethodInNanoSeconds(stringManipulator::getAllSubStrings);

        // then
        Assert.assertEquals(expectedNanoSeconds, actualNanoSeconds, 200);
    }
}
