package com.github.curriculeon;

import java.io.FileNotFoundException;

public class MyObject implements Runnable {
    public void run() {
        FilePrinter filePrinter = createFilePrinter();





    }

    private FilePrinter createFilePrinter() {
        try {
            return new FilePrinter("some directory");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
