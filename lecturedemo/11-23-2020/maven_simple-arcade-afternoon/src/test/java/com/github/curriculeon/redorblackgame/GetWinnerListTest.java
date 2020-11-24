package com.github.curriculeon.redorblackgame;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.games.AbstractGame;
import com.github.curriculeon.arcade.games.PlayerInterface;
import com.github.curriculeon.arcade.games.cardgames.redorblack.RedOrBlackGame;
import com.github.curriculeon.arcade.games.cardgames.redorblack.RedOrBlackPlayer;
import com.github.curriculeon.arcade.games.cardgames.utils.Card;
import com.github.curriculeon.arcade.games.cardgames.utils.Deck;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

public class GetWinnerListTest {
    @Test
    public void test() {
        // given
        Deck deck = new Deck();
        RedOrBlackGame redOrBlackGame = new RedOrBlackGame(deck);
        redOrBlackGame.setup();
        RedOrBlackPlayer redOrBlackPlayer = new RedOrBlackPlayer(new ArcadeAccount("leon", "hunter")) {
            @Override
            public IOConsole getIOConsole(AnsiColor color, InputStream inputStream, PrintStream printStream) {
                String userInput = redOrBlackGame.getCard().getSuit().getColor();
                byte[] inputBytes = userInput.getBytes();
                ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
                return new IOConsole(color, inputByteArray, printStream) {
                    @Override
                    public String getStringInput(String prompt, Object... args) {
                        new IOConsole().println(userInput);
                        return super.getStringInput(prompt, args);
                    }
                };
            }
        };
        redOrBlackGame.add(redOrBlackPlayer);
        List<RedOrBlackPlayer> actualWinners = redOrBlackGame.getWinnerList();
        Assert.assertFalse(actualWinners.contains(redOrBlackPlayer));
        redOrBlackGame.run();

        // when
        actualWinners = redOrBlackGame.getWinnerList();

        // then
        Assert.assertTrue(actualWinners.contains(redOrBlackPlayer));
    }
}
