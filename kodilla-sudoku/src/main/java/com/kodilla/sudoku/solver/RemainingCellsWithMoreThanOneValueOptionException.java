package com.kodilla.sudoku.solver;

import com.kodilla.sudoku.board.SudokuBoard;

public class RemainingCellsWithMoreThanOneValueOptionException extends Exception {
    private SudokuBoard board;

    public RemainingCellsWithMoreThanOneValueOptionException(String message, SudokuBoard board) {
        super(message);
        this.board = board;
    }

    public SudokuBoard getBoard() {
        return board;
    }
}
