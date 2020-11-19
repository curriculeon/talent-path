package com.github.curriculeon.arcade;

import com.github.curriculeon.arcade.game.utils.GameSelection;
import com.github.curriculeon.arcade.game.utils.GameSelectionMenu;
import com.github.curriculeon.arcade.profile.ProfileManagerMenu;
import com.github.curriculeon.arcade.profile.ProfileManagerSelection;
import com.github.curriculeon.arcade.utils.DecisionInterface;

import java.util.function.Consumer;

/**
 * Created by leon on 6/25/2020.
 * @ATTENTION_TO_STUDENTS - You are advised against modifying this class
 */
public enum ArcadeDecision implements DecisionInterface {
    MANAGE_PROFILE((arcade) -> {
        ProfileManagerMenu profileManagerMenu = new ProfileManagerMenu();
        ProfileManagerSelection profileManagerSelection = profileManagerMenu.getInput();
        profileManagerSelection.perform(arcade);
    }),

    SELECT_GAME((arcade) -> {
        GameSelectionMenu gameSelectionMenu = new GameSelectionMenu();
        GameSelection gameSelection = gameSelectionMenu.getInput();
        gameSelection.perform();
    }),

    EXIT((arcade) -> {
        arcade.getProfileManager().printProfilesInformation();
    });


    private final Consumer<ArcadeInterface> arcadeConsumer;

    ArcadeDecision(Consumer<ArcadeInterface> arcadeConsumer) {
        this.arcadeConsumer = arcadeConsumer;
    }

    public void perform(ArcadeInterface arcade) {
        arcadeConsumer.accept(arcade);
    }
}