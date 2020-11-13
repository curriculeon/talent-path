package com.github.curriculeon;

import java.util.function.Consumer;

public class MyObject {
    public void invokeRunMethod(Runnable someRunnableObject) {
        someRunnableObject.run();
        someRunnableObject.run();
        someRunnableObject.run();
        someRunnableObject.run();
        someRunnableObject.run();
    }

    public void invokeAcceptMethod(Consumer<String> someConsumer, String someValueToConsume) {
        someConsumer.accept(someValueToConsume);
    }
}
