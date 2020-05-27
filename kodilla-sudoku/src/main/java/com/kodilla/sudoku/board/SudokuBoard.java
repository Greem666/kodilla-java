package com.kodilla.sudoku.board;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SudokuBoard {
    private List<SudokuRow> rows;
    private final static String HORIZONTAL_BORDER = "-----------------------------------------------------------";
    private final static String HORIZONTAL_DOUBLE_BORDER = "===========================================================";

    public SudokuBoard() {
        this.rows = new ArrayList<>();
        IntStream.range(0, 9).forEach(i -> rows.add(new SudokuRow()));
    }

    public boolean markCellWithNumber(int cellColIdx, int cellRowIdx, int val) {
        if (cellColIdx < 1 || cellColIdx > 9 || cellRowIdx < 1 || cellRowIdx > 9) {
            return false;
        }

        return rows.get(cellRowIdx).setCellValue(cellColIdx, val);
    }

    public void drawBoard() {
        System.out.println(HORIZONTAL_DOUBLE_BORDER);
        for (int i = 0; i < rows.size(); i++) {
            System.out.println(rows.get(i));
            if (i == 2 || i == 5) {
                System.out.println(HORIZONTAL_DOUBLE_BORDER);
            } else if (i != rows.size() - 1) {
                System.out.println(HORIZONTAL_BORDER);
            }
        }
        System.out.println(HORIZONTAL_DOUBLE_BORDER);
    }
}
