package com.kodilla.sudoku.solver;

import com.kodilla.sudoku.auxiliary.UserInputDto;
import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuCell;
import com.kodilla.sudoku.board.SudokuRow;

import java.util.*;
import java.util.stream.Collectors;

public class SudokuBoardSolver {
    public static boolean solveSudokuPuzzle(SudokuBoard board) throws UnsolvableBoardException, RemainingCellsWithMoreThanOneValueOptionException {
        int missingValuesCount = countMissingValues(board);
        int loopCounter = 0;
        Map<Integer, List<UserInputDto>> possibleValuesCountToUserInputDtosMap;

        while (missingValuesCount > 0) {
            loopCounter++;
            // count of missing values at the start of the loop
            possibleValuesCountToUserInputDtosMap = new HashMap<>();

            // Loop over all cells on the board, and...
            for (int y = 1; y < board.getRows().size(); y++) {
                SudokuRow row = board.getRows().get(y - 1);
                for (int x = 1; x < row.getCellsInRow().size(); x++) {
                    SudokuCell cell = row.getCellsInRow().get(x - 1);

                    // Pay attention only to EMPTY cells
                    if (cell.getCellValue() == -1) {
                        List<Integer> cellPossibleValues = new ArrayList<>(cell.checkPossibleValues());


                        if (cellPossibleValues.size() == 1) {
                            // Only one element possible - fill it in
                            board.markCellWithNumber(new UserInputDto(x, y, cellPossibleValues.get(0)));

                        } else if (cellPossibleValues.size() == 0) {
                            // No options = unsolvable Sudoku board - throw Exception and end solution search
                            throw new UnsolvableBoardException(String.format("Board featured cells with NO value options at %d remaining missing values.", missingValuesCount), board);

                        } else {
                            // More than value possibility for cell - add to Collection for later recursive search
                            List<UserInputDto> listOfCoordinates = possibleValuesCountToUserInputDtosMap.getOrDefault(cellPossibleValues.size(), new ArrayList<UserInputDto>());
                            for (Integer possibleValue: cell.checkPossibleValues()) {
                                listOfCoordinates.add(new UserInputDto(x, y, possibleValue));
                                possibleValuesCountToUserInputDtosMap.put(cellPossibleValues.size(), listOfCoordinates);
                            }
                        }
                    }
                }
            }

            // After one full scan through board's cells: recalculate count of missing values in the board
            int missingValuesCountAfterLoop = countMissingValues(board);

            if (missingValuesCount == missingValuesCountAfterLoop) {
                // If no new values were filled in - algorithm is stuck, and will need to try and guess one value in
                //   one of the cells with least options available

                List<UserInputDto> sortedDtoItemsByPossibleValueCount = possibleValuesCountToUserInputDtosMap.entrySet().stream()
                        .sorted(Map.Entry.<Integer, List<UserInputDto>>comparingByKey())
                        .map(Map.Entry::getValue)
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());

                // Recursive search for solution, but filling in one of possible values into a cell on board clone,
                //   and re-launching this method on that board clone
                boolean solutionFound = false;
                int recursionCounter = 0;
                for (UserInputDto cellPossibleValue: sortedDtoItemsByPossibleValueCount) {
                    SudokuBoard clonedBoard = board.deepCopy();
                    clonedBoard.markCellWithNumber(cellPossibleValue);
                    try {
                        recursionCounter++;
                        solutionFound = solveSudokuPuzzle(clonedBoard);
                    } catch (UnsolvableBoardException e) {
                        System.out.println(String.format("Recursion #%d on board %s did not find a solution. Missing values left: %d",
                                recursionCounter,
                                board.hashCode(),
                                countMissingValues(clonedBoard)));
                    }

                    // If recursively executed solveSudokuPuzzle() method returns true, overwrite board with cloned board and stop looping
                    if (solutionFound) {
                        board = clonedBoard;
                        break;
                    }
                }
//                int missingValuesCountAfterRecursion = countMissingValues(board);
//
//                if (missingValuesCountAfterRecursion < missingValuesCountAfterLoop) {
//                    missingValuesCount = missingValuesCountAfterRecursion;
//                }

//                throw new RemainingCellsWithMoreThanOneValueOptionException(String.format("Board featured remaining cells with more than one value option at %d remaining missing values.", missingValuesCountAfterLoop), board);

            } else {
                missingValuesCount = missingValuesCountAfterLoop;
            }
        }

        return true;
    }

    private static int countMissingValues(SudokuBoard board) {
        return (int) board.getRows().stream()
               .flatMap(row -> row.getCellsInRow().stream())
               .filter(cell -> cell.getCellValue() == -1)
               .count();
    }
}
