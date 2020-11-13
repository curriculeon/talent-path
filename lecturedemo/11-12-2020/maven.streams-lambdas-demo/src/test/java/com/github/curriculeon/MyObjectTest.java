package com.github.curriculeon;

import org.junit.Test;

import java.util.StringJoiner;
import java.util.function.Consumer;

public class MyObjectTest {
    @Test
    public void testRunnable() {
        Long randomValue = System.nanoTime();
        Runnable someRunnableObject = () -> {
            System.out.println("Hey my randomValue was = " + randomValue);
        };

        MyObject myObject = new MyObject();
        myObject.invokeRunMethod(someRunnableObject);
    }

    @Test
    public void testConsumer() {
        Consumer<String> someConsumer = (String someValueToBeConsumed) -> {
            System.out.println("Hey my randomValue was = " + someValueToBeConsumed);
        };

        MyObject myObject = new MyObject();
        myObject.invokeAcceptMethod(someConsumer, new StringJoiner("\n")
                .add("This is the value that was consumed")
                .add("Yummy. I like consuming values")
                .toString());
    }
}
