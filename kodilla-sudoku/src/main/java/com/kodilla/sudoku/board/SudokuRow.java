package com.kodilla.sudoku.board;

import java.util.*;
import java.util.stream.IntStream;

public class SudokuRow {
    private List<SudokuCell> row;
    private Set<Integer> rowMissingValues;

    public SudokuRow() {
        this.row = new ArrayList<>();
        IntStream.range(0, 9).forEach(e -> this.row.add(new SudokuCell()));
        this.rowMissingValues = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    public boolean setCellValue(int cellIdx, int val) {
        return setCellValue(cellIdx, val, false);
    }

    public boolean setCellStartingValue(int cellIdx, int val) {
        return setCellValue(cellIdx, val, true);
    }

    public boolean setCellValue(int cellIdx, int val, boolean isStartingValue) {
        if (rowMissingValues.contains(val)) {

            boolean setWasSuccessful;
            if (isStartingValue) {
                setWasSuccessful = row.get(cellIdx).setStartingValue(val);
            } else {
                setWasSuccessful = row.get(cellIdx).setValue(val);
            }

            if (setWasSuccessful) {
                removeMissingValue(val);
                return true;
            }
        }
        return false;
    }

    private boolean removeMissingValue(int val) {
        removePossibleValueInRowCells(val);
        return rowMissingValues.remove(val);
    }

    private void removePossibleValueInRowCells(int val) {
        for (SudokuCell cell: row) {
            if (cell.getValue() != val) {
                cell.removePossibleValue(val);
            }
        }
    }

    public List<SudokuCell> getCells() {
        return row;
    }

    public Set<Integer> checkMissingValues() {
        return rowMissingValues;
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < row.size(); i++) {
            if (i == 0 || i == 3 || i == 6 || i == 9) {
                output += "|";
            }
            String cellValue = row.get(i).getValue() == -1 ? " " : String.valueOf(row.get(i).getValue());
            output += "|  " + cellValue + "  ";
        }
        output += "||";
        return output;
    }
}
