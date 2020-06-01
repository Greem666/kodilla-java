package com.kodilla.sudoku;

import com.kodilla.sudoku.auxiliary.CoordinatesDto;
import com.kodilla.sudoku.auxiliary.UserInputDto;
import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.board.SudokuBoardFactory;
import com.kodilla.sudoku.solver.SudokuBoardSolver;
import com.kodilla.sudoku.solver.UnsolvableBoardException;

import java.util.*;

public class SudokuGameService {
    Scanner scanner = new Scanner(System.in);
    private static final Map<Integer, String> availableDifficultySettings = new HashMap<Integer, String>()
    {{
        put(1, "EASY");
        put(2, "MEDIUM");
        put(3, "HARD");
    }};
    private SudokuBoard boardStartingState;

    public void run() {
        class GoodByeMessage {
            private void print() {
                System.out.println("Good bye!");
            }
        }
        GoodByeMessage goodByeMessage = new GoodByeMessage();

        System.out.println("Welcome to Sudoku game!");
        SudokuBoard board = chooseDifficultyAndGenerateBoard();

        if (board == null) {
            goodByeMessage.print();
        } else {
            boardStartingState = board.deepCopy();

            boolean playerWantsToQuit = false;
            while (true) {
                board.drawBoard();

                String[] userInput = readInUserInput();
                String userInputToString = String.join("", userInput);
                if (userInputToString.toUpperCase().equals("QUIT")) {
                    goodByeMessage.print();
                    playerWantsToQuit = true;
                    break;

                } else if (userInputToString.toUpperCase().equals("SUDOKU")) {
                    // solve board
                    solveBoard(boardStartingState);
                    break;

                } else {
                    UserInputDto input = null;
                    try {
                        input = new UserInputDto(Integer.parseInt(userInput[0]), Integer.parseInt(userInput[1]), Integer.parseInt(userInput[2]));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Incorrect coordinates or value given, please try again.");
                    }

                    boolean hasGameEnded = processUserInput(input, board);
                    if (!hasGameEnded) {
                        break;
                    }
                }
            }

            if (!playerWantsToQuit) {
                System.out.print("Would you like to play again?[Y/N] ");
                if (readInYesNoUserInput()) {
                    run();
                } else {
                    goodByeMessage.print();
                }
            }
        }
    }

    private boolean processUserInput(UserInputDto input, SudokuBoard board) {
        if (input != null) {
            if (!board.markCellWithNumber(input)) {
                System.out.println("WARNING: Cannot mark field " + (input.getColIdx() + 1) + ", " + (input.getRowIdx() + 1) + " with value " + input.getVal() + ".");
            } else {
                if (board.checkIfBoardIsSolved()) {
                    // End game
                    System.out.println("You won!");
                    board.drawBoard();
                    return false;
                } else if (!board.checkIfBoardHasEmptyCellsWithAvailableValueOptions()) {
                    // Game over - player lost
                    System.out.println("You lost - board is not solved!");
                    board.drawBoard();
                    System.out.println("Would you like to see a solution?[Y/N] ");
                    if (readInYesNoUserInput()) {
                        solveBoard(boardStartingState);
                    }
                    return false;
                }
            }
            printListOfCellsWithNoAvailableValueOptions(board);
        }
        return true;
    }

    private void printListOfCellsWithNoAvailableValueOptions(SudokuBoard board) {
        List<CoordinatesDto> cellsWithNoAvailableValueOptions = board.getCellsWithNoAvailableValueOptions();
        if (cellsWithNoAvailableValueOptions.size() > 0) {
            System.out.println("WARNING: The following cells do not have any available value options (Col, Row):");
            for (CoordinatesDto coordinatesDto: cellsWithNoAvailableValueOptions) {
                System.out.println(String.format("\t- (%d, %d)", coordinatesDto.getX(), coordinatesDto.getY()));
            }
        }
    }

    private void solveBoard(SudokuBoard board) {
        try {
            SudokuBoardSolver.solveBoard(board);
        } catch (UnsolvableBoardException e) {
            // Not possible, so no action here
        }
        System.out.println("Board solution: \n");
        board.drawBoard();
    }

    private String[] readInUserInput() {
        class IncorrectInputMessage {
            private void print() {
                System.out.println("Incorrect input, please enter one of the following:");
                System.out.println("\t- New value guess in format X,Y,Val");
                System.out.println("\t- SUDOKU to see solution of the board");
                System.out.println("\t- QUIT to end game.");
            }
        }
        IncorrectInputMessage incorrectInputMessage = new IncorrectInputMessage();

        while (true) {
            System.out.print("Your next input: ");
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (input.split(",").length == 3 || input.equals("SUDOKU") || input.equals("QUIT")) {
                    // Correct value guess
                    return input.split(",");
                } else {
                    incorrectInputMessage.print();
                }
            } else {
                incorrectInputMessage.print();
            }
        }

    }

    private boolean readInYesNoUserInput() {
        class IncorrectInputMessage {
            private void print() {
                System.out.println("Incorrect input, please enter one of the following:");
                System.out.println("\t- Y");
                System.out.println("\t- N");
            }
        }
        IncorrectInputMessage incorrectInputMessage = new IncorrectInputMessage();

        while (true) {
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (input.toUpperCase().equals("Y")) {
                    return true;
                } else if (input.toUpperCase().equals("N")){
                    return false;
                }
            } else {
                incorrectInputMessage.print();
            }
        }
    }

    private SudokuBoard chooseDifficultyAndGenerateBoard() {

        while (true) {
            System.out.println("Please choose your difficulty:");
            listOutDifficultySettings();
            System.out.print("Your choice: ");

            if (scanner.hasNextInt()) {
                int chosenDifficulty = scanner.nextInt();
                if (availableDifficultySettings.containsKey(chosenDifficulty)) {
                    System.out.println("You have chosen: " + availableDifficultySettings.get(chosenDifficulty));
                    SudokuBoard board = SudokuBoardFactory.makeBoard(chosenDifficulty);
                    scanner.nextLine();
                    return board;
                } else {
                    System.out.println("Incorrect input, please try again, or enter QUIT to end game.");
                }
            } else if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (input.equals("QUIT")) {
                    scanner.nextLine();
                    return null;
                } else {
                    System.out.println("Incorrect input, please try again, or enter QUIT to end game.");
                }
            }
        }
    }

    private void listOutDifficultySettings() {
        for (Map.Entry<Integer, String> difficulty: availableDifficultySettings.entrySet()) {
            System.out.println("\t" + difficulty.getKey() + ". " + difficulty.getValue());
        }
    }
}
