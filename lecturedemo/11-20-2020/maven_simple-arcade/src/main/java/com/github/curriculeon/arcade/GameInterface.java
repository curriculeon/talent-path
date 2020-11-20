package com.github.curriculeon.arcade;

import java.util.List;

/**
 * Created by leon on 7/21/2020.
 */
public interface GameInterface extends Runnable {
    List<PlayerInterface> getPlayerList();

    /**
     * adds a player to the game
     * @param player the player to be removed from the game
     */
    default void add(PlayerInterface player) {
        getPlayerList().add(player);
    }

    /**
     * removes a player from the game
     * @param player the player to be removed from the game
     */
    default void remove(PlayerInterface player) {
        getPlayerList().remove(player);
    }

    /**
     * specifies what to do when the game has began
     */
    default void setup() {

    }

    /**
     * specifies how the game will run
     */
    void run();

    /**
     * specifies what to do when the game is completed
     */
    default void tearDown() {

    }
}