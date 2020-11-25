package com.github.curriculeon.highlowgame;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.games.cardgames.highlow.HighLowGame;
import com.github.curriculeon.arcade.games.cardgames.highlow.HighLowPlayer;
import com.github.curriculeon.arcade.games.cardgames.utils.Card;
import com.github.curriculeon.arcade.games.cardgames.utils.Deck;
import com.github.curriculeon.arcade.games.cardgames.utils.Rank;
import com.github.curriculeon.arcade.games.cardgames.utils.Suit;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class GetWinnerListTest {

    @Test
    public void test() {
        // given
        Deck deckTobeCloned = new Deck();
        HighLowGame highLowGame = new HighLowGame(deckTobeCloned);
        highLowGame.setup();
        Deck clonedDeck = highLowGame.getDeck().clone();
        Card firstCard = clonedDeck.pop();
        Card secondCard = clonedDeck.pop();


        ArcadeAccount arcadeAccount = new ArcadeAccount("leon", "hunter");
        HighLowPlayer highLowPlayer = new HighLowPlayer(arcadeAccount) {
            @Override
            public String play() {
                boolean isEven = firstCard.equals(secondCard);
                boolean isHigh = firstCard.compareTo(secondCard) < 1;
                // return isEven ? "even" : isHigh ? "high" : "low";
                if(isEven) {
                    return "even";
                } else if(isHigh) {
                    return "high";
                } else {
                    return "low";
                }
            }
        };
        highLowGame.add(highLowPlayer);
        List<HighLowPlayer> winnerList = highLowGame.getWinnerList();
        Assert.assertFalse(winnerList.contains(highLowPlayer));
        highLowGame.run();

        // when
        winnerList = highLowGame.getWinnerList();

        // then
        Assert.assertTrue(winnerList.contains(highLowPlayer));

    }


    @Test
    public void testLow() {
        // given
        Stack<Card> cardStack = new Stack<>();
        cardStack.push(new Card(Suit.CLUBS, Rank.THREE));
        cardStack.push(new Card(Suit.CLUBS, Rank.FOUR));
        Deck deckInTheGame = new Deck(cardStack);
        HighLowGame highLowGame = new HighLowGame(deckInTheGame);

        ArcadeAccount arcadeAccount = new ArcadeAccount("leon", "hunter");
        HighLowPlayer highLowPlayer = new HighLowPlayer(arcadeAccount) {
            @Override
            public String play() {
                return "low";
            }
        };
        highLowGame.add(highLowPlayer);
        List<HighLowPlayer> winnerList = highLowGame.getWinnerList();
        Assert.assertFalse(winnerList.contains(highLowPlayer));
        highLowGame.run();

        // when
        winnerList = highLowGame.getWinnerList();

        // then
        Assert.assertTrue(winnerList.contains(highLowPlayer));

    }


    @Test
    public void testHigh() {
        // given
        Stack<Card> cardStack = new Stack<>();
        cardStack.push(new Card(Suit.CLUBS, Rank.FOUR));
        cardStack.push(new Card(Suit.CLUBS, Rank.THREE));
        Deck deckInTheGame = new Deck(cardStack);
        HighLowGame highLowGame = new HighLowGame(deckInTheGame);

        ArcadeAccount arcadeAccount = new ArcadeAccount("leon", "hunter");
        HighLowPlayer highLowPlayer = new HighLowPlayer(arcadeAccount) {
            @Override
            public String play() {
                return "high";
            }
        };
        highLowGame.add(highLowPlayer);
        List<HighLowPlayer> winnerList = highLowGame.getWinnerList();
        Assert.assertFalse(winnerList.contains(highLowPlayer));
        highLowGame.run();

        // when
        winnerList = highLowGame.getWinnerList();

        // then
        Assert.assertTrue(winnerList.contains(highLowPlayer));

    }


    @Test
    public void testEven() {
        // given
        Stack<Card> cardStack = new Stack<>();
        cardStack.push(new Card(Suit.CLUBS, Rank.THREE));
        cardStack.push(new Card(Suit.CLUBS, Rank.THREE));
        Deck deckInTheGame = new Deck(cardStack);
        HighLowGame highLowGame = new HighLowGame(deckInTheGame);

        ArcadeAccount arcadeAccount = new ArcadeAccount("leon", "hunter");
        HighLowPlayer highLowPlayer = new HighLowPlayer(arcadeAccount) {
            @Override
            public String play() {
                return "even";
            }
        };
        highLowGame.add(highLowPlayer);
        List<HighLowPlayer> winnerList = highLowGame.getWinnerList();
        Assert.assertFalse(winnerList.contains(highLowPlayer));
        highLowGame.run();

        // when
        winnerList = highLowGame.getWinnerList();

        // then
        Assert.assertTrue(winnerList.contains(highLowPlayer));

    }
}
