package com.github.curriculeon.card;

import com.github.curriculeon.arcade.games.cardgames.utils.Card;
import com.github.curriculeon.arcade.games.cardgames.utils.Deck;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest {
    @Test
    public void test() {
        List<Card> cardSet = new ArrayList<>();
        Deck deck = new Deck();
        deck.forEach(cardSet::add);

        Collections.sort(cardSet);

        System.out.println(cardSet
                .toString()
                .replace(", ", "\n"));
    }
}
