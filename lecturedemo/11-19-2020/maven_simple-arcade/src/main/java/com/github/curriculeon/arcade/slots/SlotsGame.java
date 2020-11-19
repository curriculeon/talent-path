package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;
import com.github.curriculeon.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GameInterface {
    private List<SlotsPlayer> playerList;
    SlotReel.ReelImage image1;
    SlotReel.ReelImage image2;
    SlotReel.ReelImage image3;
    IOConsole console = new IOConsole();


    public SlotsGame() {
        this(new ArrayList<>());
    }

    public SlotsGame(List<SlotsPlayer> playerList) {
        this.playerList = playerList;
    }

    public void spin() {
        this.image1 = SlotReel.spin();
        this.image2 = SlotReel.spin();
        this.image3 = SlotReel.spin();
    }

    @Override
    public void add(PlayerInterface player) {
        playerList.add((SlotsPlayer) player);
    }

    @Override
    public void remove(PlayerInterface player) {
        playerList.remove(player);
    }

    @Override
    public void run() {
        for (SlotsPlayer player : playerList) {
            String userInput;
            do {
                userInput = player.play();
                switch (userInput.toLowerCase()) {
                    case "pull-lever":
                        spin();
                        break;

                    case "view-slots":
                        console.println("Results: || %s || %s || %s", image1, image2, image3);
                        break;

                    case "exit":
                        break;
                }
            } while(!"exit".equalsIgnoreCase(userInput));
        }
    }
}
