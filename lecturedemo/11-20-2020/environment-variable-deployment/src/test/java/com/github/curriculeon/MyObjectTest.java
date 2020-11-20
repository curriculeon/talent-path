package com.github.curriculeon;

import org.junit.Test;

public class MyObjectTest {
    @Test
    public void test() {
        String secretValue = System.getenv("my-secret-key");
        System.out.println(secretValue);
    }
}