package com.github.curriculeon.arcade.games.cardgames.utils;

import java.awt.*;

public enum Suit {
    HEARTS(true),
    DIAMONDS(true),
    SPADES,
    CLUBS;

    private final boolean isRed;

    Suit() {
        this(false);
    }

    Suit(boolean isRed) {
        this.isRed = isRed;
    }

    public String getColor() {
        if(isRed()) {
            return "RED";
        } else {
            return "BLACK";
        }
    }

    public boolean isRed() {
        return isRed;
    }
}
