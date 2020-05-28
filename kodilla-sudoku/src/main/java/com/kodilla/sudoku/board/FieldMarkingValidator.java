package com.kodilla.sudoku.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FieldMarkingValidator {
    public static boolean checkColumnValues(int colIdx, int val, List<SudokuRow> rows) {
        for (SudokuRow row: rows) {
            SudokuCell columnCell = row.getCellsInRow().get(colIdx);
            if (val == columnCell.getCellValue()) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkRowValues(int rowIdx, int val, List<SudokuRow> rows) {
        SudokuRow row = rows.get(rowIdx);
        for (SudokuCell rowCell: row.getCellsInRow()) {
            if (val == rowCell.getCellValue()) {
                return false;
            }
        }

        return true;
    }

    public static boolean check3By3CubeValues(int cellColIdx, int cellRowIdx, int val, List<SudokuRow> rows) {
        ArrayList<Integer> cubeRows = identify3By3CubeIndexes(cellRowIdx);
        ArrayList<Integer> cubeCols = identify3By3CubeIndexes(cellColIdx);

        for (Integer rowIdx: cubeRows) {
            for (Integer colIdx: cubeCols) {
                int cellValue = rows.get(rowIdx).getCellsInRow().get(colIdx).getCellValue();
                if (cellValue == val) {
                    return false;
                }
            }
        }

        return true;
    }

    public static ArrayList<Integer> identify3By3CubeIndexes(int cellIdx) {
        ArrayList<Integer> colsToCheck = new ArrayList<>();
        if (cellIdx < 3) {
            colsToCheck.addAll(Arrays.asList(0, 1, 2));
        } else if (cellIdx < 6) {
            colsToCheck.addAll(Arrays.asList(3, 4, 5));
        } else {
            colsToCheck.addAll(Arrays.asList(6, 7, 8));
        }

        return colsToCheck;
    }
}
