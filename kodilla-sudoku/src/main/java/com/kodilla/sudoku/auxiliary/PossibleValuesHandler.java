package com.kodilla.sudoku.auxiliary;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuCell;

import java.util.ArrayList;

public class PossibleValuesHandler {
    public static void removeCellValueOptionInColRowCube(UserInputDto data, SudokuBoard board) {
        removeCellValueOptionInRow(data, board);
        removeCellValueOptionInCol(data, board);
        removeCellValueOptionIn3By3Cube(data, board);
    }

    private static void removeCellValueOptionInRow(UserInputDto data, SudokuBoard board) {
        try {
            removeCellValueOptionInRowOrCol(data, board, true);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception during cell value options removal in ROW: " + e);
        }
    }

    private static void removeCellValueOptionInCol(UserInputDto data, SudokuBoard board) {
        try {
            removeCellValueOptionInRowOrCol(data, board, false);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception during cell value options removal in COLUMN: " + e);
        }

    }

    private static void removeCellValueOptionInRowOrCol(UserInputDto data, SudokuBoard board, boolean inRow) throws IllegalArgumentException {
        int cellColIdx = data.getColIdx();
        int cellRowIdx = data.getRowIdx();

        for (int i = 0; i < 9; i++) {
            UserInputDto newData = new UserInputDto(data);
            if (inRow) {
                if (i != cellColIdx) {
                    newData.setColIdx(i);
                    removeCellValueOption(newData, board);
                }
            } else {
                if (i != cellRowIdx) {
                    newData.setRowIdx(i);
                    removeCellValueOption(newData, board);
                }
            }
        }
    }

    private static void removeCellValueOptionIn3By3Cube(UserInputDto data, SudokuBoard board) {
        int cellColIdx = data.getColIdx();
        int cellRowIdx = data.getRowIdx();

        ArrayList<Integer> cubeRows = PresentValuesChecker.identifyCorresponding3By3Cube(cellRowIdx);
        ArrayList<Integer> cubeCols = PresentValuesChecker.identifyCorresponding3By3Cube(cellColIdx);

        for (int row: cubeRows) {
            for (int col: cubeCols) {
                if (cellColIdx != col && cellRowIdx != row) {
                    try {
                        UserInputDto pointForRemoval = new UserInputDto(data);
                        pointForRemoval.setRowIdx(row);
                        pointForRemoval.setColIdx(col);
                        removeCellValueOption(pointForRemoval, board);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Exception during cell value options removal in 3x3 cube: " + e);
                    }
                }
            }
        }
    }

    public static void removeCellValueOption(UserInputDto data, SudokuBoard board) {
        int cellColIdx = data.getColIdx();
        int cellRowIdx = data.getRowIdx();
        int value = data.getVal();

        SudokuCell cell = board.getRows().get(cellRowIdx).getCellsInRow().get(cellColIdx);
        cell.removePossibleValue(value);
    }
}
