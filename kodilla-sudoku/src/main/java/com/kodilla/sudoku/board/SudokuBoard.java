package com.kodilla.sudoku.board;

import com.kodilla.sudoku.auxiliary.CellValueValidator;
import com.kodilla.sudoku.auxiliary.UserInputDto;
import com.kodilla.sudoku.auxiliary.ValueOptionsHandler;

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

    public boolean markCellWithNumber(UserInputDto data) {
        int cellColIdx = data.getColIdx();
        int cellRowIdx = data.getRowIdx();
        int val = data.getVal();

        boolean valNotInCol = CellValueValidator.checkValuesPresentInColumn(cellColIdx, val, this.rows);
        boolean valNotInRow = CellValueValidator.checkValuesPresentInRow(cellRowIdx, val, this.rows);
        boolean valNotIn3By3Cube = CellValueValidator.checkValuesPresentIn3By3Cube(cellColIdx, cellRowIdx, val, this.rows);

        if (valNotInCol && valNotInRow && valNotIn3By3Cube) {
            boolean valueWasSet = rows.get(cellRowIdx).setColumnValue(cellColIdx, val);
            if (valueWasSet) {
                ValueOptionsHandler.removeCellValueOptionInColRowCube(data, this);
            }
            return valueWasSet;
        }

        return false;
    }

    public List<SudokuRow> getRows() {
        return rows;
    }

    public Set<Integer> checkCellValuesOptions(UserInputDto data) {
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
