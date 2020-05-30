package com.kodilla.sudoku.board;

import com.kodilla.sudoku.auxiliary.PresentValuesChecker;
import com.kodilla.sudoku.auxiliary.UserInputDto;
import com.kodilla.sudoku.auxiliary.PossibleValuesHandler;
import com.kodilla.sudoku.interfaces.Prototype;

import java.util.*;
import java.util.stream.IntStream;

public class SudokuBoard extends Prototype {
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

        boolean valNotInCol = PresentValuesChecker.checkValuesPresentInColumn(cellColIdx, val, this.rows);
        boolean valNotInRow = PresentValuesChecker.checkValuesPresentInRow(cellRowIdx, val, this.rows);
        boolean valNotIn3By3Cube = PresentValuesChecker.checkValuesPresentIn3By3Cube(cellColIdx, cellRowIdx, val, this.rows);

        if (valNotInCol && valNotInRow && valNotIn3By3Cube) {
            boolean valueWasSet = rows.get(cellRowIdx).setColumnValue(cellColIdx, val);
            if (valueWasSet) {
                PossibleValuesHandler.removeCellValueOptionInColRowCube(data, this);
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

    private void setRows(List<SudokuRow> rows) {
        this.rows = rows;
    }

    private SudokuBoard shallowCopy() throws CloneNotSupportedException {
        return (SudokuBoard)super.clone();
    }

    public SudokuBoard deepCopy() {
        SudokuBoard clonedBoard = null;
        try {
            clonedBoard = this.shallowCopy();
            List<SudokuRow> clonedRows = new ArrayList<>();

            for (SudokuRow row: rows) {
                clonedRows.add(row.deepCopy());
            }

            clonedBoard.setRows(clonedRows);
            return clonedBoard;

        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        return null;
    }
}
