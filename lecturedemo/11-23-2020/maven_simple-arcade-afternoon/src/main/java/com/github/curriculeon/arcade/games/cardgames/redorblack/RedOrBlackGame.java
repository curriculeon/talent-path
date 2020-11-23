package com.github.curriculeon.arcade.games.cardgames.redorblack;

import com.github.curriculeon.arcade.games.AbstractGame;
import com.github.curriculeon.arcade.games.PlayerInterface;
import com.github.curriculeon.arcade.games.cardgames.utils.Card;
import com.github.curriculeon.arcade.games.cardgames.utils.Deck;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

public class RedOrBlackGame extends AbstractGame<RedOrBlackPlayer> {
    @Override
    public void run() {
        String userInput = null;
        Deck deck = new Deck();
        IOConsole console = new IOConsole(AnsiColor.CYAN);
        do {
            deck.shuffle();
            Card card = deck.pop();
            for (RedOrBlackPlayer player : getPlayerList()) {
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
                        getWinnerList().add(player);
                    }
                }
            }
            console.println("The value of the card was [ %s ]", card.toString());
            console.println("The following is a list of winners:");
            console.println(getWinnerList().toString());
            deck.push(card);
        } while (!"quit".equalsIgnoreCase(userInput));
    }
}
