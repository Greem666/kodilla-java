package com.kodilla.sudoku.board;

import com.kodilla.sudoku.interfaces.Prototype;

import java.util.*;

public class SudokuCell extends Prototype {
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
        if (possibleCellValues.contains(newVal) && cellValue == -1) {
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

    private void setPossibleCellValues(Set<Integer> possibleCellValues) {
        this.possibleCellValues = possibleCellValues;
    }

    public SudokuCell shallowCopy() throws CloneNotSupportedException {
        return (SudokuCell)super.clone();
    }

    protected SudokuCell deepCopy() throws CloneNotSupportedException {
        SudokuCell clonedCell = this.shallowCopy();
        Set<Integer> clonedPossibleCellValues = new HashSet<>(possibleCellValues);
        clonedCell.setPossibleCellValues(clonedPossibleCellValues);
        return clonedCell;
    }
}
