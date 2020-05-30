package com.kodilla.sudoku.board;

import com.kodilla.sudoku.auxiliary.UserInputDto;
import com.kodilla.sudoku.auxiliary.PossibleValuesHandler;

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
            default:
                populateBoard(board, 35);
                break;
            case EASY_DIFFICULTY:
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

            boolean fieldIsFilled;
            do {
                UserInputDto randomStartingValue;
                try {
                    int randCol = random.nextInt(8) + 1;
                    int randRow = random.nextInt(8) + 1;
                    int randVal = random.nextInt(8) + 1;
//                    System.out.println(randCol + " " + randRow + " " + randVal);
                    randomStartingValue = new UserInputDto(randCol, randRow, randVal);
                } catch (IllegalArgumentException e) {
                    System.out.println("Exception during attempt to populate new Sudoku board: " + e);
                    fieldIsFilled = false;
                    continue;
                }

                fieldIsFilled = board.markCellWithNumber(randomStartingValue);

                if (fieldIsFilled) {
                    cleanValueOptionsOnMarkedStartingField(randomStartingValue, board);
//                    PossibleValuesHandler.removeCellValueOptionInColRowCube(randomStartingValue, board);
                }

            } while (!fieldIsFilled);

            preFilledFieldsCount--;
        }

//        for (int j = 0; j < board.getRows().size(); j++) {
//            SudokuRow row = board.getRows().get(j);
//            for (int n = 0; n < row.getCellsInRow().size(); n++) {
//                SudokuCell cell = row.getCellsInRow().get(n);
//                System.out.println("(" + (j + 1) + ", " + (n + 1) + ") " + "; value: " + cell.getCellValue() + "; options: " + cell.checkPossibleValues());
//            }
//        }
    }

    private static void cleanValueOptionsOnMarkedStartingField(UserInputDto input, SudokuBoard board) {
        List<Integer> valuesForRemoval = IntStream.rangeClosed(1, 9)
                .filter(val -> val != input.getVal())
                .boxed()
                .collect(Collectors.toList());
        for (int valueForRemoval: valuesForRemoval) {
            try {
                UserInputDto newInput = new UserInputDto(input);
                newInput.setVal(valueForRemoval);
                PossibleValuesHandler.removeCellValueOption(newInput, board);
            } catch (IllegalArgumentException e) {
                System.out.println("Exception during cleaning of value options in a cell with a set starting value: " + e);
            }
        }
    }
}
