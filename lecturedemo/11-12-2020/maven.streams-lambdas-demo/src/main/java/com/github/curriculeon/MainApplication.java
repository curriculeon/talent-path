package com.github.curriculeon;

import java.util.function.Consumer;

public class MainApplication {
    public static void main(String[] args) {
        Runnable runnable = new MainApplication()::someMethodToBeTimed;
        Runnable runnable1 = () -> new MainApplication().someMethodToBeTimed();
        Consumer<Runnable> consumer = MainApplication::methodTimer;
        methodTimer(runnable);
    }

    public static void methodTimer(Runnable runnable) {
        Long startTime = System.currentTimeMillis();

        runnable.run();

        Long endTime = System.currentTimeMillis();
        Long deltaTime = endTime - startTime;
        System.out.println("Amount of time it took to execute in milliseconds is = " + deltaTime);
    }

    public void firstMethodTimer() {
        Long startTime = System.currentTimeMillis();

        new MainApplication().someMethodToBeTimed(); // method is being invoked here

        Long endTime = System.currentTimeMillis();
        Long deltaTime = endTime - startTime;
        System.out.println("Amount of time it took to execute in milliseconds is = " + deltaTime);
    }

    public void someMethodToBeTimed() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void antherMethodToBeTimed() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
