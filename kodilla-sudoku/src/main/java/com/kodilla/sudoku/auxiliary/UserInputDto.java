package com.kodilla.sudoku.auxiliary;

public class UserInputDto {
    private int colIdx;
    private int rowIdx;
    private int val;

    public UserInputDto(UserInputDto userInputDto) throws Exception {
            this.colIdx = userInputDto.getColIdx();
            this.rowIdx = userInputDto.getRowIdx();
            this.val = userInputDto.getVal();
    }

    public UserInputDto(int colIdx, int rowIdx, int val) throws Exception {
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
            this.val = val;
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
