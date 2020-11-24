package com.github.curriculeon.arcade.games.slots;

import com.github.curriculeon.arcade.games.AbstractGame;
import com.github.curriculeon.arcade.games.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame extends AbstractGame<SlotsPlayer> {
    SlotsReelImage image1;
    SlotsReelImage image2;
    SlotsReelImage image3;

    @Override
    public void run() {
        for (PlayerInterface player : getPlayerList()) {
            String userInput;
            userInput = player.play();
            if ("pull-lever".equalsIgnoreCase(userInput)) {
                image1 = SlotsReelImage.getRandom();
                image2 = SlotsReelImage.getRandom();
                image3 = SlotsReelImage.getRandom();
            } else if ("view-slots".equalsIgnoreCase(userInput)) {
                getIOConsole().println("|| %s || %s || %s ||", image1, image2, image3);
            } else if ("exit".equalsIgnoreCase(userInput)) {
                break;
            }
        }
    }
}
