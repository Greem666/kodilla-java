package com.kodilla.sudoku.solver;

import com.kodilla.sudoku.board.SudokuBoard;

public class BoardSolutionDto {
    private final SudokuBoard board;
    private final int backtrackingCount;

    public BoardSolutionDto(SudokuBoard board, int backtrackingCount) {
        this.board = board;
        this.backtrackingCount = backtrackingCount;
    }

    public SudokuBoard getBoard() {
        return board;
    }

    public int getBacktrackingCount() {
        return backtrackingCount;
    }
}
