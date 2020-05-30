package com.kodilla.sudoku.auxiliary;

public class UserInputDto {
    private int colIdx;
    private int rowIdx;
    private int val;

    public UserInputDto(UserInputDto userInputDto) throws IllegalArgumentException {
            this.colIdx = userInputDto.getColIdx();
            this.rowIdx = userInputDto.getRowIdx();
            this.val = userInputDto.getVal();
    }

    public UserInputDto(int colIdx, int rowIdx, int val) throws IllegalArgumentException {
        if (InputValidator.isValidInput(colIdx)) {
            this.colIdx = InputValidator.normalizeValue(colIdx);
        } else {
            throw new IllegalArgumentException("UserInputDto constructor: Column Index out of range: " + colIdx + ".");
        }

        if (InputValidator.isValidInput(rowIdx)) {
            this.rowIdx = InputValidator.normalizeValue(rowIdx);
        } else {
            throw new IllegalArgumentException("UserInputDto constructor: Row Index out of range: " + rowIdx + ".");
        }

        if (InputValidator.isValidInput(val)) {
            this.val = val;
        } else {
            throw new IllegalArgumentException("UserInputDto constructor: Value out of range: " + val + ".");
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

    public void setColIdx(int colIdx) {
        this.colIdx = colIdx;
    }

    public void setRowIdx(int rowIdx) {
        this.rowIdx = rowIdx;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
