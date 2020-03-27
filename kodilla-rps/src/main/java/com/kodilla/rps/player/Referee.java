package com.kodilla.rps.player;

import com.kodilla.rps.signs.ISign;
import com.kodilla.rps.signs.SignFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Referee {
    private int humanPlayerScore = 0;
    private int computerPlayerScore = 0;
    private int roundsToWinTheGame = 0;
    private Scanner scanner = new Scanner(System.in);
    SignFactory signFactory = new SignFactory();

    public int chosePlayerAction() {
        List<Integer> allowedInts = new ArrayList<>(signFactory.getSignOptions().keySet());
        List<String> allowedStrs = new ArrayList<>(Arrays.asList("x", "n"));
        String gameOptions = signFactory.getSignOptions().entrySet().stream()
                .map(e -> e.getKey().toString() + " - " + e.getValue().toString())
                .collect(Collectors.joining(", "));

        while(true) {
            System.out.print("(Referee) " + gameOptions + ": ");

            if (scanner.hasNextInt()) {
                int chosenInt = Integer.parseInt(scanner.next());
                scanner.nextLine();

                if (allowedInts.contains(chosenInt)) {
                    return chosenInt;
                } else {
                    System.out.println("(Referee) Incorrect int choice. Try again.");
                }
            } else {
                String chosenStr = scanner.nextLine().toLowerCase();

                if (allowedStrs.contains(chosenStr)) {
                    return chosenStr.equals("x") ? 9 : 0;
                } else {
                    System.out.println("(Referee) Incorrect str choice. Try again.");
                }
            }
//            scanner.nextLine();
        }
    }

    public int askForRoundsToWinGame() {
        int counter = 0;
        while(counter < 3) {
            System.out.print("(Referee) Please enter number of rounds needed to win the game: ");

            try {
                int input = Integer.parseInt(scanner.next());
                if (input > 0 && input <= 10) {
                    this.roundsToWinTheGame = input;
                    break;
                } else {
                    System.out.println("(Referee) Rounds needed for winning the game should be in 0 - 10 range. Try again.");
                }
            } catch (NumberFormatException e){
                System.out.println("(Referee) Incorrect entry, please try again.");
            }

            counter++;
        }

        if (counter == 3) {
            System.out.println("(Referee) No correct entry detected.");
            this.roundsToWinTheGame = -1;
        } else {
            System.out.println("(Referee) Round wins needed to win the game: " + this.roundsToWinTheGame + ".");
        }

        return this.roundsToWinTheGame;
    }

    public AbstractPlayer checkWhoWonTheRound(AbstractPlayer humanPlayer, AbstractPlayer computerPlayer) {
        AbstractPlayer winner = null;

        ISign humanPlayerSign = humanPlayer.getSign();
        ISign computerPlayerSign = computerPlayer.getSign();
        Boolean humanIsVictorious = humanPlayerSign.isStrongerThan(computerPlayerSign);

        if (humanIsVictorious != null) {  // it can be null if both signs are equal
            if (humanIsVictorious) {
                humanPlayer.incrementWinsCount();
                winner = humanPlayer;
            } else if (!humanIsVictorious) {
                computerPlayer.incrementWinsCount();
                winner = computerPlayer;
            }
        }
        return winner;
    }

    public AbstractPlayer checkIfPlayerWonTheGame(AbstractPlayer humanPlayer, AbstractPlayer computerPlayer) {
        AbstractPlayer winner = null;
        humanPlayerScore = humanPlayer.getWinsCount();
        if (humanPlayerScore >= roundsToWinTheGame) {
            winner = humanPlayer;
        }
        computerPlayerScore = computerPlayer.getWinsCount();
        if (computerPlayerScore >= roundsToWinTheGame) {
            winner = computerPlayer;
        }
        return winner;
    }

    public void resetState() {
        this.humanPlayerScore = 0;
        this.computerPlayerScore = 0;
        this.roundsToWinTheGame = 0;
    }

    public int getHumanPlayerScore() {
        return humanPlayerScore;
    }

    public int getComputerPlayerScore() {
        return computerPlayerScore;
    }

    public int getRoundsToWinTheGame() {
        return roundsToWinTheGame;
    }
}
