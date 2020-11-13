package com.github.curriculeon;

public class MethodTimer {
    public Long timeMethodInNanoSeconds(Runnable runnable) {
        Long startTime = System.nanoTime();

        // todo - do something
        runnable.run();

        Long endTime = System.nanoTime();
        Long deltaTime = endTime - startTime;
        return deltaTime;
    }
}
