package com.kodilla.sudoku.board;

import java.util.Random;

public class SudokuBoardFactory {
    public final static String EASY_DIFFICULTY = "EASY";
    public final static String MEDIUM_DIFFICULTY = "MEDIUM";
    public final static String HARD_DIFFICULTY = "HARD";

    public static SudokuBoard makeBoard(String difficultyLevel) {
        SudokuBoard board = new SudokuBoard();
        switch (difficultyLevel) {
            case EASY_DIFFICULTY: default:
                populateBoard(board, 24);
                break;
            case MEDIUM_DIFFICULTY:
                populateBoard(board, 20);
                break;
            case HARD_DIFFICULTY:
                populateBoard(board, 17);
                break;
        }
        return board;
    }

    private static void populateBoard(SudokuBoard board, int preFilledFieldsCount) {
        Random random = new Random();

        while (preFilledFieldsCount > 0) {
            int randX = random.nextInt(8) + 1;
            int randY = random.nextInt(8) + 1;
            int val = random.nextInt(8) + 1;

            boolean fieldWasEmpty = true;
            do {
                fieldWasEmpty = board.markCellWithNumber(randX, randY, val);
            } while (fieldWasEmpty);

            preFilledFieldsCount--;
        }
    }
}
