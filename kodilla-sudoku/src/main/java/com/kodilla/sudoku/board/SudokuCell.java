package com.kodilla.sudoku.board;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuCell {
    private int value;
    private Set<Integer> possibleValues;
    private boolean isStartingCell;
    public static int EMPTY = -1;

    public SudokuCell() {
        this.value = EMPTY;
        this.possibleValues = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        this.isStartingCell = false;
    }

    public boolean setStartingValue(int newVal) {
        possibleValues = new HashSet<>();
        this.isStartingCell = true;
        return setValue(newVal);
    }

    public boolean setValue(int newVal) {
        if (possibleValues.contains(newVal)) {
            this.value = newVal;
            return true;
        }
        return false;
    }

    public boolean removePossibleValue(int val) {
        return possibleValues.remove(val);
    }

    public Set<Integer> checkPossibleValues() {
        return possibleValues;
    }

    public int getValue() {
        return value;
    }
}
