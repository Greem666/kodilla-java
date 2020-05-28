package com.kodilla.sudoku.board;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuCell {
    private int cellValue;
    private Set<Integer> possibleCellValues;
    public static int EMPTY = -1;

    public SudokuCell() {
        this.cellValue = EMPTY;
        this.possibleCellValues = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    public int getCellValue() {
        return cellValue;
    }

    public boolean setCellValue(int newVal) {
        if (possibleCellValues.contains(newVal)) {
            this.cellValue = newVal;
            return true;
        }
        return false;
    }

    public boolean removePossibleValue(int val) {
        return possibleCellValues.remove(val);
    }

    public Set<Integer> checkPossibleValues() {
        return possibleCellValues;
    }
}
