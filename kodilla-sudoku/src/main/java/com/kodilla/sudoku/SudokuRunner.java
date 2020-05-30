package com.kodilla.sudoku;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuBoardFactory;
import com.kodilla.sudoku.solver.RemainingCellsWithMoreThanOneValueOptionException;
import com.kodilla.sudoku.solver.SudokuBoardSolver;
import com.kodilla.sudoku.solver.UnsolvableBoardException;

import java.util.Scanner;

public class SudokuRunner {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SudokuBoard board = null;
        boolean solvableBoardFound = false;
        int attemptsCounter = 0;

        while (!solvableBoardFound) {
            board = SudokuBoardFactory.makeBoard("");
//            board.drawBoard();
            attemptsCounter++;
            try {
                solvableBoardFound = SudokuBoardSolver.solveSudokuPuzzle(board);
            } catch (UnsolvableBoardException e) {
                System.out.println(attemptsCounter + ": " + e);
//                e.getBoard().drawBoard();
            } catch (RemainingCellsWithMoreThanOneValueOptionException e) {
                System.out.println(attemptsCounter + ": " + e);
//                e.getBoard().drawBoard();
            }
        }

        System.out.println(String.format("Solvable board found after %d attempts.", attemptsCounter));
        board.drawBoard();
//        SudokuBoard board = new SudokuBoard();
//        board.drawBoard();
    }

}
