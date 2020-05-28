package com.kodilla.sudoku.board;

import java.util.*;
import java.util.stream.IntStream;

public class SudokuBoard {
    private List<SudokuRow> rows;
    private final static String HORIZONTAL_BORDER = "-----------------------------------------------------------";
    private final static String HORIZONTAL_DOUBLE_BORDER = "===========================================================";

    public SudokuBoard() {
        this.rows = new ArrayList<>();
        IntStream.range(0, 9).forEach(i -> rows.add(new SudokuRow()));
    }

    public boolean markCellWithNumber(CoorValDto data) {
        int cellColIdx = data.getColIdx();
        int cellRowIdx = data.getRowIdx();
        int val = data.getVal();

        boolean valNotInCol = FieldMarkingValidator.checkColumnValues(cellColIdx, val, this.rows);
        boolean valNotInRow = FieldMarkingValidator.checkRowValues(cellRowIdx, val, this.rows);
        boolean valNotIn3By3Cube = FieldMarkingValidator.check3By3CubeValues(cellColIdx, cellRowIdx, val, this.rows);
        if (valNotInCol && valNotInRow && valNotIn3By3Cube) {
            boolean valueWasSet = rows.get(cellRowIdx).setColumnValue(cellColIdx, val);
            if (valueWasSet) {
                // remove val as a possibility from row, col and 3x3 cube
                List<Integer> valuesForRemoval = Collections.singletonList(val);
                removeCellPossibleValuesInRow(data);
                removeCellPossibleValuesInCol(data);
                removeCellPossibleValuesIn3By3Cube(data);
            }
            return valueWasSet;
        }

        return false;
    }

    public void removeCellPossibleValuesInRow(CoorValDto data) {
        try {
            removeCellPossibleValuesInLine(data, true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void removeCellPossibleValuesInCol(CoorValDto data) {
        try {
            removeCellPossibleValuesInLine(data, false);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void removeCellPossibleValuesInLine(CoorValDto data, boolean inRow) throws Exception{
        int cellColIdx = data.getColIdx();
        int cellRowIdx = data.getRowIdx();
        int valueForRemoval = data.getVal();

        List<Integer> valuesForRemoval = Collections.singletonList(valueForRemoval);
        for (int i = 0; i < 9; i++) {
            if (i != cellColIdx) {
                if (inRow) {
                    removeCellPossibleValues(new CoorValDto(i, cellRowIdx, valueForRemoval), valuesForRemoval);
                } else {
                    removeCellPossibleValues(new CoorValDto(cellColIdx, i, valueForRemoval), valuesForRemoval);
                }
            }
        }
    }

    public void removeCellPossibleValuesIn3By3Cube(CoorValDto data) {
        int cellColIdx = data.getColIdx();
        int cellRowIdx = data.getRowIdx();
        int valueForRemoval = data.getVal();

        List<Integer> valuesForRemoval = Collections.singletonList(valueForRemoval);
        ArrayList<Integer> cubeRows = FieldMarkingValidator.identify3By3CubeIndexes(cellRowIdx);
        ArrayList<Integer> cubeCols = FieldMarkingValidator.identify3By3CubeIndexes(cellColIdx);

        for (int row: cubeRows) {
            for (int col: cubeCols) {
                if (cellColIdx != col && cellRowIdx != row) {
                    removeCellPossibleValues(data, valuesForRemoval);
                }
            }
        }
    }

    public void removeCellPossibleValues(CoorValDto data, List<Integer> values) {
        int cellColIdx = data.getColIdx();
        int cellRowIdx = data.getRowIdx();

        SudokuCell cell = rows.get(cellRowIdx).getCellsInRow().get(cellColIdx);
        for (int value: values) {
            cell.removePossibleValue(value);
        }
    }

    public Set<Integer> checkCellPossibleValues(CoorValDto data) {
        SudokuCell cell = rows.get(data.getRowIdx()).getCellsInRow().get(data.getColIdx());
        return cell.checkPossibleValues();
    }

    public void drawBoard() {
        System.out.println(HORIZONTAL_DOUBLE_BORDER);
        for (int i = 0; i < rows.size(); i++) {
            System.out.println(rows.get(i));
            if (i == 2 || i == 5) {
                System.out.println(HORIZONTAL_DOUBLE_BORDER);
            } else if (i != rows.size() - 1) {
                System.out.println(HORIZONTAL_BORDER);
            }
        }
        System.out.println(HORIZONTAL_DOUBLE_BORDER);
    }
}
