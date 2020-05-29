package com.kodilla.sudoku.auxiliary;

import com.kodilla.sudoku.board.SudokuCell;
import com.kodilla.sudoku.board.SudokuRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CellValueValidator {
    public static boolean checkValuesPresentInColumn(int colIdx, int val, List<SudokuRow> rows) {
        for (SudokuRow row: rows) {
            SudokuCell columnCell = row.getCellsInRow().get(colIdx);
            if (val == columnCell.getCellValue()) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkValuesPresentInRow(int rowIdx, int val, List<SudokuRow> rows) {
        SudokuRow row = rows.get(rowIdx);
        for (SudokuCell rowCell: row.getCellsInRow()) {
            if (val == rowCell.getCellValue()) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkValuesPresentIn3By3Cube(int cellColIdx, int cellRowIdx, int val, List<SudokuRow> rows) {
        ArrayList<Integer> cubeRows = identifyCorresponding3By3Cube(cellRowIdx);
        ArrayList<Integer> cubeCols = identifyCorresponding3By3Cube(cellColIdx);

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

    public static ArrayList<Integer> identifyCorresponding3By3Cube(int cellIdx) {
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
