package com.kodilla.rps.service;

import com.kodilla.rps.player.AbstractPlayer;
import com.kodilla.rps.player.ComputerPlayer;
import com.kodilla.rps.player.HumanPlayer;
import com.kodilla.rps.player.Referee;
import com.kodilla.rps.signs.SignFactory;

import java.util.Scanner;
import java.util.stream.Collectors;

public class RpsManager {
    private Scanner scanner = new Scanner(System.in);
    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;
    private Referee referee = new Referee();
    private SignFactory signFactory = new SignFactory();

    public void runGame() {
        gameIntroduction();
        while(true) {
            // Start game
            String gameStatus = gameLoop();

            // On Game end, or interrupts...
            if (gameStatus.equals("gameEnd")) {
                String endProgram = yesNoQuery("(Game controller) Would you like to play again?[y/n]", "restartGame");
                if (endProgram != null) {
                    resetGameState();
                    System.out.println("(Game controller) Starting a new game...");
                } else {
                    break;
                }
            } else if (gameStatus.equals("restartGame")) {
                resetGameState();
                System.out.println("(Game controller) Restarting game...");
            } else if (gameStatus.equals("quitGame")) {
                break;
            }
        }
        System.out.println(String.format("(Game controller) Quitting the game. Good bye, %s!", humanPlayer.getName()));
    }

    private void gameIntroduction() {
        String gameName = this.signFactory.getSignOptions().entrySet().stream()
                .map(e -> e.getValue().toString())
                .collect(Collectors.joining(" "));
        System.out.println("(Game controller) Welcome to " + gameName + " game!");
        createHumanPlayer();
        createComputerPlayer();
        referee.askForRoundsToWinGame();
        displayControls();
    }

    private String gameLoop() {
        boolean gameOn = true;
        String gameLoopOutput = null;
        int roundNo = 1;
        boolean skipChoice = false;
        Integer playerChoice = null;
        String answer = null;

        while(gameOn) {
            if (!skipChoice) {
                System.out.println("\nRound " + roundNo);
                playerChoice = referee.chosePlayerAction();
            }

            skipChoice = false;

            if (playerChoice > 0 && playerChoice <= signFactory.getSignOptions().size()) {

                // Pick signs
                humanPlayer.pickASign(playerChoice);
                computerPlayer.pickASign(playerChoice);

                // Check who won and increment + report their score
                AbstractPlayer roundWinner = referee.checkWhoWonTheRound(humanPlayer, computerPlayer);
                if (roundWinner != null) {
                    System.out.println(String.format("(Game controller) %s won this round!", roundWinner.getName()));
                } else {
                    System.out.println("Draw!");
                }
                reportPlayerScores();

                // Check if someone won the game
                AbstractPlayer gameWinner = referee.checkIfPlayerWonTheGame(humanPlayer, computerPlayer);
                if (gameWinner != null) {
                    System.out.println(String.format("(Game controller) %s won the game!", gameWinner.getName()));
                    gameOn = false;
                    gameLoopOutput = "gameEnd";
                }

                // Go to next round
                roundNo++;

            // Interrupts
            } else if (playerChoice == 9) {
                answer = yesNoQuery("(Game controller) Are you sure you want to quit?[y/n]", "quitGame");
            } else if (playerChoice == 0) {
                answer = yesNoQuery("(Game controller) Are you sure you want to restart the game?[y/n]", "restartGame");
            }

            if (answer != null) {
                gameLoopOutput = answer;
                break;
            } else {
                System.out.println("\nRound " + roundNo);
                playerChoice = referee.chosePlayerAction();
                skipChoice = true;
            }
        }
        return gameLoopOutput;
    }

    private String yesNoQuery(String msg, String outputIfYes) {
        System.out.println(msg);
        if (scanner.hasNextLine() && scanner.nextLine().toLowerCase().equals("y")) {
            return outputIfYes;
        }
        return null;
    }

    private void reportPlayerScores() {
        System.out.println(String.format("(Game controller) %s score: %d / %d rounds won.", humanPlayer.getName(),
                humanPlayer.getWinsCount(), referee.getRoundsToWinTheGame()));
        System.out.println(String.format("(Game controller) %s score: %d / %d rounds won.", computerPlayer.getName(),
                computerPlayer.getWinsCount(), referee.getRoundsToWinTheGame()));
    }

    private void resetGameState() {
        System.out.println("Resetting game state...");
        this.humanPlayer.resetSign();
        this.humanPlayer.resetWinsCount();

        this.computerPlayer.resetSign();
        this.computerPlayer.resetWinsCount();

        this.referee.resetState();
        this.referee.askForRoundsToWinGame();
    }

    private void createHumanPlayer() {
        String playerName = askForPlayerName();
        this.humanPlayer = new HumanPlayer(playerName);
    }

    private void createComputerPlayer() {
        this.computerPlayer = new ComputerPlayer();
    }

    private String askForPlayerName() {
        String playerName;
        while(true) {
            System.out.print("(Game controller) Please enter your name: ");
            if (scanner.hasNextLine()) {
                playerName = scanner.nextLine();
                break;
            } else {
                System.out.println("(Game controller) Incorrect entry, please try again.");
            }
        }
        return playerName;
    }

    private void displayControls() {
        System.out.println("******************************");
        System.out.println("Game controls are as follows:");
        this.signFactory.getSignOptions().entrySet().stream()
                .forEach(e -> System.out.println("\t" + e.getKey() + " - " + e.getValue().getName()));
        System.out.println("\tx - Exit game");
        System.out.println("\tn - Restart game");
        System.out.println("******************************");
    }







}
