package com.github.curriculeon.highlowgame;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.games.cardgames.highlow.HighLowGame;
import com.github.curriculeon.arcade.games.cardgames.highlow.HighLowPlayer;
import com.github.curriculeon.arcade.games.cardgames.utils.Card;
import com.github.curriculeon.arcade.games.cardgames.utils.Deck;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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
                boolean isHigh = firstCard.compareTo(secondCard) < 1;
                return isHigh ? "high" : "low";
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
