package com.kodilla.sudoku.solver;

import com.kodilla.sudoku.board.SudokuBoard;

public class CellValueGuessDto {
    private int x;
    private int y;
    private int val;
    private SudokuBoard board;

    public CellValueGuessDto(int x, int y, int val, SudokuBoard board) {
        this.x = x;
        this.y = y;
        this.val = val;
        this.board = board;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVal() {
        return val;
    }

    public SudokuBoard getBoard() {
        return board;
    }
}
