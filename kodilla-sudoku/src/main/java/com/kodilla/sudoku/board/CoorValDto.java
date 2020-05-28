package com.kodilla.sudoku.board;

public class CoorValDto {
    private int colIdx;
    private int rowIdx;
    private int val;

    public CoorValDto(int colIdx, int rowIdx, int val) throws Exception {
        if (InputValidator.isValidInput(colIdx)) {
            this.colIdx = InputValidator.normalizeValue(colIdx);
        } else {
            throw new Exception("Column Index out of range.");
        }

        if (InputValidator.isValidInput(rowIdx)) {
            this.rowIdx = InputValidator.normalizeValue(rowIdx);
        } else {
            throw new Exception("Row Index out of range.");
        }

        if (InputValidator.isValidInput(colIdx)) {
            this.val = InputValidator.normalizeValue(val);
        } else {
            throw new Exception("Value out of range.");
        }
    }

    public int getColIdx() {
        return colIdx;
    }

    public int getRowIdx() {
        return rowIdx;
    }

    public int getVal() {
        return val;
    }
}
