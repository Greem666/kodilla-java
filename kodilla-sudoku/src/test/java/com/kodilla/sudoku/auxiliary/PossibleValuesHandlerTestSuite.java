package com.kodilla.sudoku.auxiliary;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuCell;
import com.kodilla.sudoku.board.SudokuRow;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PossibleValuesHandlerTestSuite {
    private SudokuBoard board;
    private List<SudokuCell> row1;
    private List<SudokuCell> row2;
    private List<SudokuCell> row3;
    private List<SudokuCell> row4;
    private List<SudokuCell> row5;
    private List<SudokuCell> row6;
    private List<SudokuCell> row7;
    private List<SudokuCell> row8;
    private List<SudokuCell> row9;

    private List<List<SudokuCell>> rows;

    @Before
    public void beforeEachTest() {
        board = new SudokuBoard();

        row1 = assembleRow(1, board);
        row2 = assembleRow(2, board);
        row3 = assembleRow(3, board);
        row4 = assembleRow(4, board);
        row5 = assembleRow(5, board);
        row6 = assembleRow(6, board);
        row7 = assembleRow(7, board);
        row8 = assembleRow(8, board);
        row9 = assembleRow(9, board);

        rows = Arrays.asList(row1, row2, row3, row4, row5, row6, row7, row8, row9);
    }

    @Test
    public void testTopLeftSingleValue() {
        // Given
        int cellX = 2;
        int cellY = 2;
        int cellVal = 1;

        // When & Then
        testPossibleValuesAfterMarkingCell(cellX, cellY, cellVal);
    }

    @Test
    public void testTopCenterSingleValue() {
        // Given
        int cellX = 5;
        int cellY = 2;
        int cellVal = 1;

        // When & Then
        testPossibleValuesAfterMarkingCell(cellX, cellY, cellVal);
    }

    @Test
    public void testTopRightSingleValue() {
        // Given
        int cellX = 8;
        int cellY = 2;
        int cellVal = 1;

        // When & Then
        testPossibleValuesAfterMarkingCell(cellX, cellY, cellVal);
    }

    @Test
    public void testMiddleLeftSingleValue() {
        // Given
        int cellX = 2;
        int cellY = 5;
        int cellVal = 1;

        // When & Then
        testPossibleValuesAfterMarkingCell(cellX, cellY, cellVal);
    }

    @Test
    public void testMiddleCenterSingleValue() {
        // Given
        int cellX = 5;
        int cellY = 5;
        int cellVal = 1;

        // When & Then
        testPossibleValuesAfterMarkingCell(cellX, cellY, cellVal);
    }

    @Test
    public void testMiddleRightSingleValue() {
        // Given
        int cellX = 8;
        int cellY = 5;
        int cellVal = 1;

        // When & Then
        testPossibleValuesAfterMarkingCell(cellX, cellY, cellVal);
    }

    @Test
    public void testBottomLeftSingleValue() {
        // Given
        int cellX = 2;
        int cellY = 8;
        int cellVal = 1;

        // When & Then
        testPossibleValuesAfterMarkingCell(cellX, cellY, cellVal);
    }

    @Test
    public void testBottomCenterSingleValue() {
        // Given
        int cellX = 5;
        int cellY = 8;
        int cellVal = 1;

        // When & Then
        testPossibleValuesAfterMarkingCell(cellX, cellY, cellVal);
    }

    @Test
    public void testBottomRightSingleValue() {
        // Given
        int cellX = 8;
        int cellY = 8;
        int cellVal = 1;

        // When & Then
        testPossibleValuesAfterMarkingCell(cellX, cellY, cellVal);
    }

    private void testPossibleValuesAfterMarkingCell(int cellX, int cellY, int cellVal) {
        // When
        SudokuCell markedCell = board.getRows().get(cellX - 1).getCellsInRow().get(cellY - 1);
        markedCell.setCellValue(cellVal);

        UserInputDto input = new UserInputDto(cellX, cellY, cellVal);
        PossibleValuesHandler.removeCellValueOptionInColRowCube(input, board);

        // Then
        for (int y = 0; y < rows.size(); y++) {
            List<SudokuCell> row = rows.get(y);
            for (int x = 0; x < row.size(); x++) {
                SudokuCell cell = row.get(x);
                if (x == (cellX - 1) && y == (cellY - 1)) {
                    // This cell
                    Assert.assertEquals(9, cell.checkPossibleValues().size());
                    Assert.assertTrue(cell.checkPossibleValues().contains(cellVal));
                } else if (x != (cellX - 1) && y == (cellY - 1)) {
                    // Cells in the same row
                    Assert.assertEquals(8, cell.checkPossibleValues().size());
                    Assert.assertFalse(cell.checkPossibleValues().contains(cellVal));
                } else if (x == (cellX - 1) && y != (cellY - 1)) {
                    // Cells in the same col
                    Assert.assertEquals(8, cell.checkPossibleValues().size());
                    Assert.assertFalse(cell.checkPossibleValues().contains(cellVal));
                } else if (identify3By3CubeCoordinates((cellX - 1)).contains(x) && identify3By3CubeCoordinates((cellY - 1)).contains(y)) {
                    // Cells in the same 3x3 cube
                    Assert.assertEquals(8, cell.checkPossibleValues().size());
                    Assert.assertFalse(cell.checkPossibleValues().contains(cellVal));
                } else {
                    // Other cells
                    Assert.assertEquals(9, cell.checkPossibleValues().size());
                    Assert.assertTrue(cell.checkPossibleValues().contains(cellVal));
                }
            }
        }
    }

    private List<SudokuCell> assembleRow(int row, SudokuBoard board) {
        return board.getRows().get(row - 1).getCellsInRow();
    }

    private List<SudokuCell> assembleCol(int col, SudokuBoard board) {
        return board.getRows().stream()
                .map(row -> row.getCellsInRow().get(col - 1))
                .collect(Collectors.toList());
    }

    public ArrayList<Integer> identify3By3CubeCoordinates(int cellIdx) {
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
