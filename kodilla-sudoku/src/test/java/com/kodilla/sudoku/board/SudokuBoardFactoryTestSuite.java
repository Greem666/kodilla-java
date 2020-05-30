package com.kodilla.sudoku.board;

import org.junit.Assert;
import org.junit.Test;

public class SudokuBoardFactoryTestSuite {
    @Test
    public void testEasyFactory() {
        // Given
        SudokuBoard board = SudokuBoardFactory.makeBoard("EASY");

        // When
        long markedFieldsCount = board.getRows().stream()
                .flatMap(row -> row.getCellsInRow().stream())
                .map(SudokuCell::getCellValue)
                .filter(val -> val != -1)
                .count();

        long markedFieldsWith1PossibleValue = board.getRows().stream()
                .flatMap(row -> row.getCellsInRow().stream())
                .filter(cell -> cell.getCellValue() != -1)
                .filter(cell -> cell.checkPossibleValues().size() == 1)
                .count();

        // Then
        Assert.assertEquals(24, markedFieldsCount);
        Assert.assertEquals(24, markedFieldsWith1PossibleValue);
    }

    @Test
    public void testMediumFactory() {
        // Given
        SudokuBoard board = SudokuBoardFactory.makeBoard("MEDIUM");

        // When
        long markedFieldsCount = board.getRows().stream()
                .flatMap(row -> row.getCellsInRow().stream())
                .map(SudokuCell::getCellValue)
                .filter(val -> val != -1)
                .count();

        long markedFieldsWith1PossibleValue = board.getRows().stream()
                .flatMap(row -> row.getCellsInRow().stream())
                .filter(cell -> cell.getCellValue() != -1)
                .filter(cell -> cell.checkPossibleValues().size() == 1)
                .count();

        // Then
        Assert.assertEquals(20, markedFieldsCount);
        Assert.assertEquals(20, markedFieldsWith1PossibleValue);
    }

    @Test
    public void testHardFactory() {
        // Given
        SudokuBoard board = SudokuBoardFactory.makeBoard("HARD");

        // When
        long markedFieldsCount = board.getRows().stream()
                .flatMap(row -> row.getCellsInRow().stream())
                .map(SudokuCell::getCellValue)
                .filter(val -> val != -1)
                .count();

        long markedFieldsWith1PossibleValue = board.getRows().stream()
                .flatMap(row -> row.getCellsInRow().stream())
                .filter(cell -> cell.getCellValue() != -1)
                .filter(cell -> cell.checkPossibleValues().size() == 1)
                .count();

        // Then
        Assert.assertEquals(17, markedFieldsCount);
        Assert.assertEquals(17, markedFieldsWith1PossibleValue);
    }
}
