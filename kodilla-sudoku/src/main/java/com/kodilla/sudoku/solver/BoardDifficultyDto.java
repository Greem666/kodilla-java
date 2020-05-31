package com.kodilla.sudoku.solver;

public class BoardDifficultyDto {
    private int desiredFilledFieldsCount;
    private int minBackTrackingCount;
    private int maxBackTrackingCount;

    public BoardDifficultyDto(int desiredFilledFieldsCount, int minBackTrackingCount, int maxBackTrackingCount) {
        this.desiredFilledFieldsCount = desiredFilledFieldsCount;
        this.minBackTrackingCount = minBackTrackingCount;
        this.maxBackTrackingCount = maxBackTrackingCount;
    }

    public int getDesiredFilledFieldsCount() {
        return desiredFilledFieldsCount;
    }

    public int getMinBackTrackingCount() {
        return minBackTrackingCount;
    }

    public int getMaxBackTrackingCount() {
        return maxBackTrackingCount;
    }
}
