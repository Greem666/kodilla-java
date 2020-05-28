package com.kodilla.sudoku.board;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        int i = 0;
        while (preFilledFieldsCount > 0) {

            boolean fieldIsFilled;
            do {
                int randRow = random.nextInt(8) + 1;
                int randCol = random.nextInt(8) + 1;
                int randVal = random.nextInt(8) + 1;
                fieldIsFilled = board.markCellWithNumber(randCol, randRow, randVal);
                if (fieldIsFilled) {
                    // Clean all possible values on the marked field
                    List<Integer> valuesForRemoval = IntStream.rangeClosed(1, 9)
                            .filter(val -> val != randVal)
                            .boxed()
                            .collect(Collectors.toList());
                    board.removeCellPossibleValues(randCol, randRow, valuesForRemoval);
                }
                System.out.println(i + ". Row: " + randRow + "; Col: " + randCol + "; Val: " + randVal + "; Possible values: " + board.checkCellPossibleValues(randCol, randRow) + ");");
            } while (!fieldIsFilled);

            preFilledFieldsCount--;
            i++;
        }
    }
}
