package com.github.curriculeon.arcade.games.cardgames.utils;

public class Card implements Comparable<Card> {
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

    @Override
    public String toString() {
        return rank
                .name()
                .concat(" of ")
                .concat(suit.name());
    }

    @Override
    public int compareTo(Card card) {
        return this.getRank().getPrimaryValue() - card.getRank().getPrimaryValue();
    }
}
