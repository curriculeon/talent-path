package com.github.curriculeon.arcade.games.cardgames.highlow;

import com.github.curriculeon.arcade.games.AbstractGame;
import com.github.curriculeon.arcade.games.cardgames.utils.Card;
import com.github.curriculeon.arcade.games.cardgames.utils.Deck;
import com.github.curriculeon.utils.IOConsole;

public class HighLowGame extends AbstractGame<HighLowPlayer> {
    @Override
    public void run() {
        IOConsole console = new IOConsole();
        Deck deck = new Deck();
        String userInput = null;
        do {
            for (HighLowPlayer player : getPlayerList()) {
                deck.shuffle();
                Card visibleCard = deck.pop();
                int visibleCardValue = visibleCard.getRank().getPrimaryValue();
                console.println("The current visible card is [ %s ]", visibleCard);
                userInput = player.play();
                Card cardToCompareAgainst = deck.pop();
                int cardToCompareAgainstValue = cardToCompareAgainst.getRank().getPrimaryValue();
                boolean cardToCompareAgainstIsEqual = cardToCompareAgainstValue == visibleCardValue;
                boolean cardToCompareAgainstIsHigher = cardToCompareAgainstValue > visibleCardValue;
                boolean cardToCompareAgainstIsLower = (!cardToCompareAgainstIsHigher) && (!cardToCompareAgainstIsEqual);
                boolean hasWonWithEven = "even".equalsIgnoreCase(userInput) && cardToCompareAgainstIsEqual;
                boolean hasWonWithLow = "low".equalsIgnoreCase(userInput) && cardToCompareAgainstIsLower;
                boolean hasWonWithHigh = "high".equalsIgnoreCase(userInput) && cardToCompareAgainstIsHigher;
                boolean hasWon = hasWonWithEven || hasWonWithHigh || hasWonWithLow;

                if (hasWon) {
                    console.println("You win!");
                } else {
                    console.println("You lose.");
                }
                console.println("The next card value was [ %s ]", cardToCompareAgainst);
                deck.push(visibleCard);
                deck.push(cardToCompareAgainst);
            }
        } while(!"quit".equalsIgnoreCase(userInput));
    }
}
