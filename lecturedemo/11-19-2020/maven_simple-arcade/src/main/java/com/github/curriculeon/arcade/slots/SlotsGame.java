package com.github.curriculeon.arcade.slots;

import com.github.curriculeon.arcade.GameInterface;
import com.github.curriculeon.arcade.PlayerInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GameInterface {
    private List<SlotsPlayer> playerList;

    public SlotsGame() {
        this(new ArrayList<>());
    }

    public SlotsGame(List<SlotsPlayer> playerList) {
        this.playerList = playerList;
    }

    @Override
    public void add(PlayerInterface player) {
        playerList.add((SlotsPlayer)player);
    }

    @Override
    public void remove(PlayerInterface player) {
        playerList.remove(player);
    }

    @Override
    public void run() {
        for(SlotsPlayer player : playerList) {

        }
    }
}
