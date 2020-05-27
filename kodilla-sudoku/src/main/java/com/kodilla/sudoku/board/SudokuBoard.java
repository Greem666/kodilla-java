package com.kodilla.sudoku.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SudokuBoard {
    private List<SudokuRow> rows;
    private final static String HORIZONTAL_BORDER = "-----------------------------------------------------------";
    private final static String HORIZONTAL_DOUBLE_BORDER = "===========================================================";

    public SudokuBoard() {
        this.rows = new ArrayList<>();
        IntStream.range(0, 9).forEach(i -> rows.add(new SudokuRow()));
    }

    public boolean markCellWithNumber(int cellColIdx, int cellRowIdx, int val) {
        return markCellWithNumber(cellColIdx, cellRowIdx, val, false);
    }

    public boolean markCellWithNumber(int cellColIdx, int cellRowIdx, int val, boolean isStartingValue) {
        if (isValidInput(cellColIdx, cellRowIdx, val)) {
            boolean valNotInCol = checkColumnValues(cellColIdx, val);
            boolean valNotInCube = check3By3Cube(cellColIdx, cellRowIdx, val);
            if (valNotInCol && valNotInCube) {
                if (isStartingValue) {
                    return rows.get(cellRowIdx).setCellStartingValue(cellColIdx, val);
                } else {
                    return rows.get(cellRowIdx).setCellValue(cellColIdx, val);
                }
            }
        }

        return false;
    }

    private boolean checkColumnValues(int colIdx, int val) {
        for (SudokuRow row: rows) {
            for (SudokuCell cell: row.getCells()) {
                if (val == cell.getValue()) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean check3By3Cube(int cellColIdx, int cellRowIdx, int val) {
        ArrayList<Integer> cubeRows = identify3By3CubeIndexes(cellRowIdx);
        ArrayList<Integer> cubeCols = identify3By3CubeIndexes(cellColIdx);

        for (Integer rowIdx: cubeRows) {
            for (Integer colIdx: cubeCols) {
                int cellValue = rows.get(rowIdx).getCells().get(colIdx).getValue();
                if (cellValue == val) {
                    return false;
                }
            }
        }

        return true;
    }

    private ArrayList<Integer> identify3By3CubeIndexes(int cellIdx) {
        ArrayList<Integer> colsToCheck = new ArrayList<>();
        if (cellIdx <= 3) {
            colsToCheck.addAll(Arrays.asList(0, 1, 2));
        } else if (cellIdx <= 6) {
            colsToCheck.addAll(Arrays.asList(3, 4, 5));
        } else {
            colsToCheck.addAll(Arrays.asList(6, 7, 8));
        }

        return colsToCheck;
    }

    private boolean isValidInput(int cellColIdx, int cellRowIdx, int val) {
        if (cellColIdx < 1 || cellColIdx > 9 || cellRowIdx < 1 || cellRowIdx > 9 || val < 1 || val > 9) {
            return false;
        }
        return true;
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
