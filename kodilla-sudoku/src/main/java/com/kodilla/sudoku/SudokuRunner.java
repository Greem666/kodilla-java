package com.kodilla.sudoku;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuBoardFactory;

public class SudokuRunner {

    public static void main(String[] args) {
        SudokuBoard board = SudokuBoardFactory.makeBoard("EASY");

        board.drawBoard();

//        SudokuBoard board = new SudokuBoard();
//        board.drawBoard();
    }

}
