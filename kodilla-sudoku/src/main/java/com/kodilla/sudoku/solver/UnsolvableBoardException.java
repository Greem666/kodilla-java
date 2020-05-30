package com.kodilla.sudoku.solver;

import com.kodilla.sudoku.board.SudokuBoard;

public class UnsolvableBoardException extends Exception {
    private SudokuBoard board;
    public UnsolvableBoardException(String message, SudokuBoard board) {
        super(message);
        this.board = board;
    }

    public SudokuBoard getBoard() {
        return board;
    }
}
