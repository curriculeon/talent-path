package com.github.curriculeon.arcade.games.cardgames.highlow;

import com.github.curriculeon.arcade.games.AbstractGame;
import com.github.curriculeon.arcade.games.cardgames.utils.Card;
import com.github.curriculeon.arcade.games.cardgames.utils.Deck;
import com.github.curriculeon.utils.IOConsole;

public class HighLowGame extends AbstractGame<HighLowPlayer> {
    @Override
    public void run() {
        IOConsole console = getIOConsole();
        Deck deck = new Deck();
        String userInput = null;
        for (HighLowPlayer player : getPlayerList()) {
            deck.shuffle();
            Card visibleCard = deck.pop();
            int visibleCardValue = visibleCard.getRank().getPrimaryValue();
            console.println("The current visible card is [ %s ]", visibleCard);
            userInput = player.play();
            Card cardToCompareAgainst = deck.pop();
            int cardToCompareAgainstValue = cardToCompareAgainst.getRank().getPrimaryValue();
            boolean isCardToCompareAgainstEqual = cardToCompareAgainstValue == visibleCardValue;
            boolean isCardToCompareAgainstHigher = cardToCompareAgainstValue > visibleCardValue;
            boolean isCardToCompareAgainstLower = (!isCardToCompareAgainstHigher) && (!isCardToCompareAgainstEqual);
            boolean hasWonWithEven = "even".equalsIgnoreCase(userInput) && isCardToCompareAgainstEqual;
            boolean hasWonWithLow = "low".equalsIgnoreCase(userInput) && isCardToCompareAgainstLower;
            boolean hasWonWithHigh = "high".equalsIgnoreCase(userInput) && isCardToCompareAgainstHigher;
            boolean hasWon = hasWonWithEven || hasWonWithHigh || hasWonWithLow;

            if (hasWon) {
                getWinnerList().add(player);
            } else {
                console.println("You lose.");
            }
            console.println("The next card value was [ %s ]", cardToCompareAgainst);
            deck.push(visibleCard);
            deck.push(cardToCompareAgainst);
        }
    }
}
