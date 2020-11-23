package com.github.curriculeon;

import com.github.curriculeon.arcade.ArcadeAccount;
import com.github.curriculeon.arcade.ArcadeAccountManager;
import com.github.curriculeon.arcade.games.GameInterface;
import com.github.curriculeon.arcade.games.PlayerInterface;
import com.github.curriculeon.arcade.games.cardgames.highlow.HighLowGame;
import com.github.curriculeon.arcade.games.cardgames.highlow.HighLowPlayer;
import com.github.curriculeon.arcade.games.cardgames.redorblack.RedOrBlackGame;
import com.github.curriculeon.arcade.games.cardgames.redorblack.RedOrBlackPlayer;
import com.github.curriculeon.arcade.games.numberguess.NumberGuessGame;
import com.github.curriculeon.arcade.games.numberguess.NumberGuessPlayer;
import com.github.curriculeon.arcade.games.slots.SlotsGame;
import com.github.curriculeon.arcade.games.slots.SlotsPlayer;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;
import com.github.curriculeon.utils.IOSocketInterface;

import java.util.StringJoiner;

/**
 * Created by leon on 7/21/2020.
 */
public class Arcade implements Runnable, IOSocketInterface {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    @Override
    public void run() {
        ArcadeAccountManager arcadeAccountManager = new ArcadeAccountManager();
        ArcadeAccount testAccount = arcadeAccountManager.createAccount("leon", "hunter");
        arcadeAccountManager.registerAccount(testAccount);
        String arcadeDashBoardInput;
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();
            if ("select-game".equals(arcadeDashBoardInput)) {
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                ArcadeAccount arcadeAccount = arcadeAccountManager.getAccount(accountName, accountPassword);
                boolean isValidLogin = arcadeAccount != null;
                if (isValidLogin) {
                    String gameSelectionInput = getGameSelectionInput().toUpperCase();
                    if ("SLOTS".equalsIgnoreCase(gameSelectionInput)) {
                        play(new SlotsGame(), new SlotsPlayer(arcadeAccount));
                    } else if ("REDORBLACK".equalsIgnoreCase(gameSelectionInput)) {
                        play(new RedOrBlackGame(), new RedOrBlackPlayer(arcadeAccount));
                    } else if ("HIGHLOW".equalsIgnoreCase(gameSelectionInput)) {
                        play(new HighLowGame(), new HighLowPlayer(arcadeAccount));
                    } else if ("NUMBERGUESS".equalsIgnoreCase(gameSelectionInput)) {
                        play(new NumberGuessGame(), new NumberGuessPlayer(arcadeAccount));
                    } else {
                        // TODO - implement better exception handling
                        String errorMessage = "[ %s ] is an invalid game selection";
                        throw new RuntimeException(String.format(errorMessage, gameSelectionInput));
                    }
                } else {
                    // TODO - implement better exception handling
                    String errorMessage = "No account found with name of [ %s ] and password of [ %s ]";
                    throw new RuntimeException(String.format(errorMessage, accountPassword, accountName));
                }
            } else if ("create-account".equals(arcadeDashBoardInput)) {
                console.println("Welcome to the account-creation screen.");
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                ArcadeAccount newAccount = arcadeAccountManager.createAccount(accountName, accountPassword);
                arcadeAccountManager.registerAccount(newAccount);
            }
        } while (!"logout".equals(arcadeDashBoardInput));
    }

    private String getArcadeDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Arcade Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ create-account ], [ select-game ]")
                .toString());
    }

    private String getGameSelectionInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Game Selection Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ SLOTS ], [ NUMBERGUESS ], [ REDORBLACK ], [ HIGHLOW ]")
                .toString());
    }

    private void play(Object gameObject, Object playerObject) {
        IOConsole console = getIOConsole(AnsiColor.GREEN);
        GameInterface game = (GameInterface) gameObject;
        PlayerInterface player = (PlayerInterface) playerObject;
        String userInput;
        do {
            String gameName = game.getClass().getSimpleName();
            String userPrompt = new StringJoiner("\n")
                    .add("Welcome back to the %s menu.")
                    .add("From here, you can enter any of the following:")
                    .add("\t[ play ], [ quit]")
                    .toString();
            userInput = console.getStringInput(userPrompt, gameName);
            game.add(player);
            game.setup();
            game.run();
            game.tearDown();
        } while (!"quit".equalsIgnoreCase(userInput));
    }
}
