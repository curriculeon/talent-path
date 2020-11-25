package com.github.curriculeon.arcade.games.cardgames.highlow;

import com.github.curriculeon.arcade.games.AbstractGame;
import com.github.curriculeon.arcade.games.cardgames.utils.Card;
import com.github.curriculeon.arcade.games.cardgames.utils.Deck;
import com.github.curriculeon.utils.IOConsole;

public class HighLowGame extends AbstractGame<HighLowPlayer> {
    private final Deck deck;

    public HighLowGame() {
        this(new Deck());
    }

    public HighLowGame(Deck deck) {
        this.deck = deck;
    }

    @Override
    public void setup() {
        getDeck().shuffle();
    }

    @Override
    public void run() {
        IOConsole console = getIOConsole();
        String userInput = null;
        for (HighLowPlayer player : getPlayerList()) {
            Card visibleCard = getDeck().pop();
            console.println("The current visible card is [ %s ]", visibleCard);
            userInput = player.play();
            Card cardToCompareAgainst = getDeck().pop();
            int visibleCardValue = visibleCard.getRank().getPrimaryValue();
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
            getDeck().push(visibleCard);
            getDeck().push(cardToCompareAgainst);
        }
    }
    public Deck getDeck() {
        return deck;
    }
}
