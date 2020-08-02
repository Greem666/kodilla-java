package com.kodilla.sudoku.board;

import org.junit.Assert;
import org.junit.Test;

public class SudokuBoardFactoryTestSuite {
    @Test
    public void testEasyFactory() {
        // Given
        SudokuBoard board = SudokuBoardFactory.makeBoard(SudokuBoardFactory.EASY_DIFFICULTY);

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
        Assert.assertEquals(55, markedFieldsCount);
//        Assert.assertEquals(34, markedFieldsWith1PossibleValue);
    }

    @Test
    public void testMediumFactory() {
        // Given
        SudokuBoard board = SudokuBoardFactory.makeBoard(SudokuBoardFactory.MEDIUM_DIFFICULTY);

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
        Assert.assertEquals(45, markedFieldsCount);
//        Assert.assertEquals(13, markedFieldsWith1PossibleValue);
    }

    @Test
    public void testHardFactory() {
        // Given
        SudokuBoard board = SudokuBoardFactory.makeBoard(SudokuBoardFactory.HARD_DIFFICULTY);

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
        Assert.assertEquals(35, markedFieldsCount);
//        Assert.assertEquals(0, markedFieldsWith1PossibleValue);
    }
}
