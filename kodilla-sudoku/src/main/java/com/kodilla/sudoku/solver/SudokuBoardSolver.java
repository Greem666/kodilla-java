package com.kodilla.sudoku.solver;

import com.kodilla.sudoku.auxiliary.UserInputDto;
import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuCell;
import com.kodilla.sudoku.board.SudokuRow;

import java.util.*;

public class SudokuBoardSolver {
    private static Random random = new Random();

    public static BoardDto solveBoard(SudokuBoard board) throws UnsolvableBoardException {
        int backtrackingCounter = 0;

        // Stack for backtracking
        Deque<CellValueGuessDto> backtrack = new ArrayDeque<>();

        // Fill recursively cells. For every cell to be filled, try all numbers until a safe number to
        //   be placed is found.
        int rowsCount = board.getRows().size();
        int y = 0;
        while (y < rowsCount) {
            int x = 0;
            while (x < rowsCount) {

                SudokuRow row = board.getRows().get(y);
                SudokuCell cell = row.getCellsInRow().get(x);

                // Only try to fill if cell is empty
                if (cell.getCellValue() == -1) {
                    List<Integer> cellPossibleValues = new ArrayList<Integer>(cell.checkPossibleValues());

                    if (cellPossibleValues.size() > 0) {
                        // Choose available value option
                        int valCandidateIdx = random.nextInt(cellPossibleValues.size());
                        int valCandidate = cellPossibleValues.get(valCandidateIdx);

                        // Save a copy of the board as it is right now
                        SudokuBoard clonedBoard = board.deepCopy();
                        backtrack.push(new CellValueGuessDto(x, y, valCandidate, clonedBoard));

                        board.markCellWithNumber(new UserInputDto(x + 1, y + 1, valCandidate));

                    } else {
                        if (backtrack.size() > 0) {
                            // Go back one step, restore board
                            CellValueGuessDto previousBoardSetup = backtrack.pop();
                            x = previousBoardSetup.getX();
                            y = previousBoardSetup.getY();
                            int valueOptionForRemoval = previousBoardSetup.getVal();
                            board = previousBoardSetup.getBoard();

                            // Remove that value's possibility from possible values pool for the previous cell
                            board.getRows().get(y).getCellsInRow().get(x).removePossibleValue(valueOptionForRemoval);

                            backtrackingCounter++;

                            // Restart value choice for that previous cell, with a reduced possible values pool
                            continue;
                        } else {
                            // No previous steps to rectify, throw an error about this board being unsolvable
                            throw new UnsolvableBoardException("This board is not solvable.", board);
                        }
                    }
                }
                x++;
            }
            y++;
        }
        return new BoardDto(board, backtrackingCounter);
    }
}
