package com.kodilla.sudoku.board;

import com.kodilla.sudoku.auxiliary.UserInputDto;
import com.kodilla.sudoku.solver.*;

import java.util.*;

public class SudokuBoardFactory {
    public final static String EASY_DIFFICULTY = "EASY";
    public final static String MEDIUM_DIFFICULTY = "MEDIUM";
    public final static String HARD_DIFFICULTY = "HARD";
    private static Random random = new Random();

    public static SudokuBoard makeBoard(String difficultyLevel) {
        SudokuBoard board;

        switch (difficultyLevel) {
            case EASY_DIFFICULTY: default:
                board = generateBoard(new BoardDifficultyDto(24, 0, 50));
                break;
            case MEDIUM_DIFFICULTY:
                board = generateBoard(new BoardDifficultyDto(20, 50, 100));
                break;
            case HARD_DIFFICULTY:
                board = generateBoard(new BoardDifficultyDto(17, 100, 200));
                break;
        }

        return board;
    }

    private static SudokuBoard generateBoard(BoardDifficultyDto boardDifficultyDto) {
        SudokuBoard solvableBoardWithRemovedFields;

        while (true) {
            // 1. Fill all the diagonal 3x3 matrices - these 3 3x3 cube sections are decoupled from one-another, and set up
            //   the board nicely for faster generation later on.
            SudokuBoard newBoard = new SudokuBoard();
            populateEmptyBoardSection(1, 1, 3, 3, newBoard);
            populateEmptyBoardSection(4, 4, 6, 6, newBoard);
            populateEmptyBoardSection(7, 7, 9, 9, newBoard);

            // 2. Solve board
            BoardDto solvedBoardDto;
            try {
                solvedBoardDto = SudokuBoardSolver.solveBoard(newBoard);
            } catch (UnsolvableBoardException e) {
//                System.out.println(e);
                continue;
            }
            SudokuBoard solvedBoard = solvedBoardDto.getBoard();
            int backtrackingCounter = solvedBoardDto.getBacktrackingCount();


            // 3. Remove values from cells, until remaining cells with filled in values match desiredFilledFieldsCount
            if (backtrackingCounter < boardDifficultyDto.getMaxBackTrackingCount() &&
                    backtrackingCounter > boardDifficultyDto.getMinBackTrackingCount()) {

                solvableBoardWithRemovedFields = removeFieldsFromBoard(boardDifficultyDto.getDesiredFilledFieldsCount(), solvedBoard);
                break;
            }
        }

        return solvableBoardWithRemovedFields;
    }

    private static void populateEmptyBoardSection(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY, SudokuBoard board) {
        for (int y = topLeftY - 1; y <= bottomRightY - 1; y++) {
            for (int x = topLeftX - 1; x <= bottomRightX - 1; x++) {
                boolean valueInserted = false;
                while (!valueInserted) {
                    int valCandidate = random.nextInt(9) + 1;
                    valueInserted = board.markCellWithNumber(new UserInputDto(y + 1, x + 1, valCandidate));
                }
            }
        }
    }

    private static SudokuBoard removeFieldsFromBoard(int desiredFilledFieldsCount, SudokuBoard board) {
        SudokuBoard newBoard = new SudokuBoard();

        while (desiredFilledFieldsCount > 0) {
            int x = random.nextInt(9);
            int y = random.nextInt(9);

            int oldBoardCellValue = board.getRows().get(y).getCellsInRow().get(x).getCellValue();
            int newBoardCellValue = newBoard.getRows().get(y).getCellsInRow().get(x).getCellValue();

            if (newBoardCellValue == -1) {
                newBoard.markCellWithNumber(new UserInputDto(x + 1, y + 1, oldBoardCellValue));
                desiredFilledFieldsCount--;
            }
        }

        return newBoard;
    }
}
