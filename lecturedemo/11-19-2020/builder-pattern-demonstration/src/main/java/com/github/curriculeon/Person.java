package com.github.curriculeon;

import java.io.Serializable;

public class Person implements Identifiable {
    @Override
    public Serializable getId() {
        return System.nanoTime();
    }
}
