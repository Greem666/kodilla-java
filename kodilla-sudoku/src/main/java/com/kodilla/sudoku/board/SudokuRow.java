package com.kodilla.sudoku.board;

import java.util.*;
import java.util.stream.IntStream;

public class SudokuRow {
    private List<SudokuCell> row;

    public SudokuRow() {
        this.row = new ArrayList<>();
        IntStream.range(0, 9).forEach(e -> this.row.add(new SudokuCell()));
    }

    public boolean setColumnValue(int colIdx, int val) {
        return row.get(colIdx).setCellValue(val);
    }

    public List<SudokuCell> getCellsInRow() {
        return row;
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < row.size(); i++) {
            if (i == 0 || i == 3 || i == 6 || i == 9) {
                output += "|";
            }
            String cellValue = row.get(i).getCellValue() == -1 ? " " : String.valueOf(row.get(i).getCellValue());
            output += "|  " + cellValue + "  ";
        }
        output += "||";
        return output;
    }
}
