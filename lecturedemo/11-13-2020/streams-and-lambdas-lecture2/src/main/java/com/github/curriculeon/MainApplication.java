package com.github.curriculeon;

import java.util.StringJoiner;

@SuppressWarnings("all")
public class MainApplication {
    public static void main(String[] args) {
        new MainApplication().run();
    }

    private void run() {
        IOConsole ioConsole = new IOConsole();
        String userInput = ioConsole.getStringInput(new StringJoiner("\n")
                .add("Hey, welcome to the mock-console-application main menu")
                .add("From here, you can select any of the following options:")
                .add("\t[GoFish, BlackJack, Slots, Poker]")
                .toString());
        MainMenuOption mainMenuOption = MainMenuOption.valueOf(userInput.toUpperCase());
        mainMenuOption.run();
    }
}
