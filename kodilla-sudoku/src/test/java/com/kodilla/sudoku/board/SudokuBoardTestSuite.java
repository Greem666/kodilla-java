package com.kodilla.sudoku.board;

import com.kodilla.sudoku.auxiliary.PossibleValuesHandler;
import com.kodilla.sudoku.auxiliary.UserInputDto;
import org.junit.Assert;
import org.junit.Test;

public class SudokuBoardTestSuite {
    @Test
    public void testSudokuBoardMarkingAvailableCell() throws IllegalArgumentException {
        // Given
        SudokuBoard board = new SudokuBoard();
        int cellX = 2;
        int cellY = 2;
        int cellVal = 1;

        // When
        SudokuCell markedCell = board.getRows().get(cellX - 1).getCellsInRow().get(cellY - 1);
        markedCell.setCellValue(cellVal);

        UserInputDto input = new UserInputDto(cellX, cellY, cellVal);
        PossibleValuesHandler.removeCellValueOptionInColRowCube(input, board);

        boolean result = board.markCellWithNumber(new UserInputDto(4, 4, 1));

        // Then
        Assert.assertTrue(result);
    }

    @Test
    public void testSudokuBoardMarkingNotAvailableCellSameCol() throws IllegalArgumentException {
        // Given
        SudokuBoard board = new SudokuBoard();
        int cellX = 2;
        int cellY = 2;
        int cellVal = 1;

        // When
        SudokuCell markedCell = board.getRows().get(cellX - 1).getCellsInRow().get(cellY - 1);
        markedCell.setCellValue(cellVal);

        UserInputDto input = new UserInputDto(cellX, cellY, cellVal);
        PossibleValuesHandler.removeCellValueOptionInColRowCube(input, board);

        boolean result = board.markCellWithNumber(new UserInputDto(2, 4, 1));

        // Then
        Assert.assertFalse(result);
    }

    @Test
    public void testSudokuBoardMarkingNotAvailableCellSameRow() throws IllegalArgumentException {
        // Given
        SudokuBoard board = new SudokuBoard();
        int cellX = 2;
        int cellY = 2;
        int cellVal = 1;

        // When
        SudokuCell markedCell = board.getRows().get(cellX - 1).getCellsInRow().get(cellY - 1);
        markedCell.setCellValue(cellVal);

        UserInputDto input = new UserInputDto(cellX, cellY, cellVal);
        PossibleValuesHandler.removeCellValueOptionInColRowCube(input, board);

        boolean result = board.markCellWithNumber(new UserInputDto(4, 2, 1));

        // Then
        Assert.assertFalse(result);
    }

    @Test
    public void testSudokuBoardMarkingNotAvailableCellSameCell() throws IllegalArgumentException {
        // Given
        SudokuBoard board = new SudokuBoard();
        int cellX = 2;
        int cellY = 2;
        int cellVal = 1;

        // When
        SudokuCell markedCell = board.getRows().get(cellX - 1).getCellsInRow().get(cellY - 1);
        markedCell.setCellValue(cellVal);

        UserInputDto input = new UserInputDto(cellX, cellY, cellVal);
        PossibleValuesHandler.removeCellValueOptionInColRowCube(input, board);

        boolean result = board.markCellWithNumber(new UserInputDto(2, 2, 1));

        // Then
        Assert.assertFalse(result);
    }

    @Test
    public void testSudokuBoardMarkingNotAvailableCellSameCube() throws IllegalArgumentException {
        // Given
        SudokuBoard board = new SudokuBoard();
        int cellX = 2;
        int cellY = 2;
        int cellVal = 1;

        // When
        SudokuCell markedCell = board.getRows().get(cellX - 1).getCellsInRow().get(cellY - 1);
        markedCell.setCellValue(cellVal);

        UserInputDto input = new UserInputDto(cellX, cellY, cellVal);
        PossibleValuesHandler.removeCellValueOptionInColRowCube(input, board);

        boolean result = board.markCellWithNumber(new UserInputDto(1, 1, 1));

        // Then
        Assert.assertFalse(result);
    }
}
