package com.kodilla.sudoku.board;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuRow {
    private List<SudokuCell> row;
    private Set<Integer> missingValues;

    public SudokuRow() {
        this.row = new ArrayList<>();
        IntStream.range(0, 9).forEach(e -> this.row.add(new SudokuCell()));
        this.missingValues = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    public boolean setCellValue(int cellIdx, int val) {
        boolean setWasSuccessful = row.get(cellIdx).setValue(val);
        if (setWasSuccessful) {
            removeMissingValue(val);
        }
        return setWasSuccessful;
    }

    private boolean removeMissingValue(int val) {
        return missingValues.remove(val);
    }

    public Set<Integer> checkMissingValues() {
        return missingValues;
    }

    @Override
    public String toString() {
//        return row.stream()
//                .map(SudokuCell::getValue)
//                .map(String::valueOf)
//                .collect(Collectors.joining(" | ", "| ", " |"));
        String output = "";
        for (int i = 0; i < row.size(); i++) {
            if (i == 0 || i == 3 || i == 6 || i == 9) {
                output += "|";
            }
            String cellValue = row.get(i).getValue() == -1 ? " " : String.valueOf(row.get(i).getValue());
            output += "|  " + cellValue + "  ";
        }
        output += "||";
        return output;
    }
}
