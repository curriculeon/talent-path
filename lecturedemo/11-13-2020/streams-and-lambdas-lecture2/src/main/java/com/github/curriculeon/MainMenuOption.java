package com.github.curriculeon;

import java.util.StringJoiner;

public enum MainMenuOption implements Runnable {
    GOFISH(()-> {
        IOConsole ioConsole = new IOConsole();
        ioConsole.println("Welcome to GoFish!");
        String gofishInput = ioConsole.getStringInput(new StringJoiner("\n")
                .add("From here, you can select any of the following options")
                .add("[ GoFish, [Play-A-Set]")
                .toString());
    }),
    BLACKJACK(()-> {
        IOConsole ioConsole = new IOConsole();
        ioConsole.println("Welcome to BlackJack!");
        String blackjack = ioConsole.getStringInput(new StringJoiner("\n")
                .add("From here, you can select any of the following options")
                .add("[ GoFish, [Play-A-Set]")
                .toString());
    }),
    POKER(()-> {
        IOConsole ioConsole = new IOConsole();
        ioConsole.println("Welcome to Slots!");
        String slots = ioConsole.getStringInput(new StringJoiner("\n")
                .add("From here, you can select any of the following options")
                .add("[ GoFish, [Play-A-Set]")
                .toString());
    }),
    SLOTS(()-> {
        IOConsole ioConsole = new IOConsole();
        ioConsole.println("Welcome to Poker!");
        String poker = ioConsole.getStringInput(new StringJoiner("\n")
                .add("From here, you can select any of the following options")
                .add("[ GoFish, [Play-A-Set]")
                .toString());
    });
    private Runnable runnable;

    MainMenuOption(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void run() {
        IOConsole ioConsole = new IOConsole();
        ioConsole.println("Welcome to Slots!");
        String slots = ioConsole.getStringInput(new StringJoiner("\n")
                .add("From here, you can select any of the following options")
                .add("[ GoFish, [Play-A-Set]")
                .toString());
    }
}
