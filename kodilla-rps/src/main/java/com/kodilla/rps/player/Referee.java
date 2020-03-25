package com.kodilla.rps.player;

import com.kodilla.rps.signs.ISign;

import java.util.List;
import java.util.Scanner;

public class Referee {
    private int humanPlayerScore = 0;
    private int computerPlayerScore = 0;
    private int roundsToWinTheGame = 0;
    private Scanner scanner = new Scanner(System.in);

    public void askForGameWinCount() {
        while(true) {
            System.out.print("(Referee) Please enter number of rounds needed to win the game: ");
            if (scanner.hasNextInt()) {
                this.roundsToWinTheGame = scanner.nextInt();
                break;
            } else {
                System.out.println("(Referee) Incorrect entry, please try again.");
            }
            scanner.nextLine();
        }
        System.out.println("Round wins needed to win the game: " + this.roundsToWinTheGame + ".");
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
}
