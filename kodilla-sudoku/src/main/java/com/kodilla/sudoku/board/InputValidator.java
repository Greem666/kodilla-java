package com.kodilla.sudoku.board;

public class InputValidator {
    public static boolean isValidInput(int... values) {
        for (int value: values) {
            if (value < 1 || value > 9) {
                return false;
            }
        }
        return true;
    }

    public static int normalizeValue(int value) {
        return value - 1;
    }
}
