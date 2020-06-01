package com.kodilla.sudoku.auxiliary;

public class CoordinatesDto {
    private int x;
    private int y;

    public CoordinatesDto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x + 1;
    }

    public int getY() {
        return y + 1;
    }
}
