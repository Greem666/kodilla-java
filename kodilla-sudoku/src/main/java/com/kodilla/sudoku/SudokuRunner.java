package com.kodilla.sudoku;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuBoardFactory;

import java.util.Scanner;

public class SudokuRunner {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SudokuBoard board = SudokuBoardFactory.makeBoard("EASY");
        board.drawBoard();

//        SudokuBoard board = new SudokuBoard();
//        board.drawBoard();
    }

}
