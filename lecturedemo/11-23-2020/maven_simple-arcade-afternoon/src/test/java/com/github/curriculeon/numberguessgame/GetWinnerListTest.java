package com.github.curriculeon.numberguessgame;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.games.numberguess.NumberGuessGame;
import com.github.curriculeon.arcade.games.numberguess.NumberGuessPlayer;
import org.junit.Test;

public class GetWinnerListTest {

    @Test
    public void test() {
        // given
        ArcadeAccount arcadeAccount = new ArcadeAccount("leon", "hunter");
        NumberGuessPlayer numberGuessPlayer = new NumberGuessPlayer(arcadeAccount);
        NumberGuessGame numberGuessGame = new NumberGuessGame();
        numberGuessGame.add(numberGuessPlayer);
        numberGuessGame.run();

        // when
        numberGuessGame.getWinnerList();

        // then
    }
}
