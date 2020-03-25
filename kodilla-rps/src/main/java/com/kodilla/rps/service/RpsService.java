package com.kodilla.rps.service;

import com.kodilla.rps.player.AbstractPlayer;
import com.kodilla.rps.player.ComputerPlayer;
import com.kodilla.rps.player.HumanPlayer;
import com.kodilla.rps.player.Referee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RpsService {
    private Scanner scanner = new Scanner(System.in);
    private List<AbstractPlayer> players = new ArrayList<>();
    private Referee referee = new Referee();

    public void gameIntroduction() {
        System.out.println("Welcome to Rock Paper Scissors game!");
        createHumanPlayer();
        createComputerPlayer();
        referee.askForGameWinCount();
        displayControls();
    }

    private void gameLoop() {
        boolean gameOn = true;
        while(gameOn) {
            AbstractPlayer humanPlayer = players.get(0);
            AbstractPlayer computerPlayer = players.get(1);

            int playerChoice = promptForChoice();
            humanPlayer.pickASign(playerChoice);
            computerPlayer.pickASign(playerChoice);

            AbstractPlayer winner = referee.checkWhoWonTheRound(humanPlayer, computerPlayer);

        }


    }

    private void createHumanPlayer() {
        String playerName = askForPlayerName();
        players.add(new HumanPlayer(playerName));
    }

    private void createComputerPlayer() {
        players.add(new ComputerPlayer());
    }

    private String askForPlayerName() {
        String playerName;
        while(true) {
            System.out.print("Please enter your name: ");
            if (scanner.hasNextLine()) {
                playerName = scanner.nextLine();
                break;
            } else {
                System.out.println("Incorrect entry, please try again.");
            }
        }
        return playerName;
    }



    private void displayControls() {
        System.out.println("******************************");
        System.out.println("Game controls are as follows:");
        System.out.println("\t1 - Rock");
        System.out.println("\t2 - Paper");
        System.out.println("\t3 - Scissors");
        System.out.println("\tx - Exit game");
        System.out.println("\tn - Restart game");
        System.out.println("******************************");
    }

    private int promptForChoice() {
        int numericalChoice;
        String stringChoice;

        while(true) {
            System.out.println("Pick a sign (1 - Rock, 2 - Paper, 3 - Scissors): ");
            if (scanner.hasNextInt()) {
                numericalChoice = scanner.nextInt();
                if (numericalChoice == 1 || numericalChoice == 2 || numericalChoice == 3) {
                    break;
                } else {
                    scanner.nextLine();
                    System.out.println("Incorrect input, try again.");
                }
            } else if (scanner.hasNextLine()) {
                stringChoice = scanner.nextLine().toLowerCase();
                if (stringChoice.equals("x")) {
                    numericalChoice = 9;
                    break;
                } else if (stringChoice.equals("n")) {
                    numericalChoice = 0;
                    break;
                } else {
                    System.out.println("Incorrect input, try again.");
                }
            }
        }

        return numericalChoice;
    }





}
