package com.github.curriculeon.arcade.games.cardgames.utils;

import java.awt.*;

public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Boolean isRed() {
        return suit.isRed();
    }

    @Override
    public String toString() {
        return rank
                .name()
                .concat(" of ")
                .concat(suit.name());
    }

    public String getColor() {
        return suit.getColor();
    }
}
