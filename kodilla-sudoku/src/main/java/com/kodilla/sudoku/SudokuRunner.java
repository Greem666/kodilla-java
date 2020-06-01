package com.kodilla.sudoku;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuBoardFactory;
import com.kodilla.sudoku.solver.UnsolvableBoardException;

import java.util.Scanner;

public class SudokuRunner {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SudokuGameService game = new SudokuGameService();
        game.run();



    }
}
