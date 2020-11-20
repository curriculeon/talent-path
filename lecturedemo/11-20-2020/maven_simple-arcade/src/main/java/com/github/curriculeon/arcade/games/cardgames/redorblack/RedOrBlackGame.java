package com.github.curriculeon.arcade.games.cardgames.redorblack;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.arcade.games.cardgames.utils.Card;
import com.github.curriculeon.arcade.games.cardgames.utils.Deck;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;

public class RedOrBlackGame implements GameInterface {
    private final Deck deck = new Deck();
    private final List<PlayerInterface> playerList;

    public RedOrBlackGame() {
        this(new ArrayList<>());
    }

    public RedOrBlackGame(List<PlayerInterface> playerList) {
        this.playerList = playerList;
    }

    @Override
    public void add(PlayerInterface player) {
        playerList.add(player);
    }

    @Override
    public void remove(PlayerInterface player) {
        playerList.remove(player);
    }

    @Override
    public void run() {
        IOConsole console = new IOConsole(AnsiColor.CYAN);
        String userInput = null;
        do {
            deck.shuffle();
            Card card = deck.pop();
            for (PlayerInterface player : playerList) {
                userInput = player.play();
                boolean userInputIsRed = "red".equalsIgnoreCase(userInput);
                boolean userInputIsBlack = "black".equalsIgnoreCase(userInput);
                boolean userInputIsValid = userInputIsRed || userInputIsBlack;
                boolean cardIsRed = card.isRed();
                boolean userIsCorrectAboutRed = cardIsRed && userInputIsRed;
                boolean userIsCorrectAboutBlack = (!cardIsRed) && userInputIsBlack;
                boolean userIsCorrect = userIsCorrectAboutBlack || userIsCorrectAboutRed;

                if (userInputIsValid) {
                    if (userIsCorrect) {
                        console.println("You were correct!");
                    } else {
                        console.println("You were incorrect!");
                    }
                    console.println("The value of the card was [ %s ]", card.toString());
                }
            }
            deck.push(card);
        } while (!"quit".equalsIgnoreCase(userInput));
    }
}
