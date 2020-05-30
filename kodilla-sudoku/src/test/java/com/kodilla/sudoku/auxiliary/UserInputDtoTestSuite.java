package com.kodilla.sudoku.auxiliary;

import static org.junit.Assert.*;
import org.junit.Test;

public class UserInputDtoTestSuite {
    @Test
    public void testUserInputDtoValidInputViaConstructor() throws IllegalArgumentException {
        // Given
        UserInputDto validInput = new UserInputDto(1, 2, 3);

        // When
        int retrievedCol = validInput.getColIdx();
        int retrievedRow = validInput.getRowIdx();
        int retrievedVal = validInput.getVal();

        // Then
        assertEquals(0, retrievedCol);
        assertEquals(1, retrievedRow);
        assertEquals(3, retrievedVal);
    }

    @Test
    public void testUserInputDtoValidInput() throws IllegalArgumentException {
        // Given
        UserInputDto validInput = new UserInputDto(1, 2, 3);
        validInput.setColIdx(4);
        validInput.setRowIdx(5);
        validInput.setVal(6);

        // When
        int retrievedCol = validInput.getColIdx();
        int retrievedRow = validInput.getRowIdx();
        int retrievedVal = validInput.getVal();

        // Then
        assertEquals(4, retrievedCol);
        assertEquals(5, retrievedRow);
        assertEquals(6, retrievedVal);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUserInputDtoInvalidLowColInputViaConstructor() throws IllegalArgumentException {
        // Given
        UserInputDto validInput = new UserInputDto(0, 2, 3);

        // When

        // Then
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUserInputDtoInvalidLowRowInputViaConstructor() throws IllegalArgumentException {
        // Given
        UserInputDto validInput = new UserInputDto(1, 0, 3);

        // When

        // Then
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUserInputDtoInvalidLowValInputViaConstructor() throws IllegalArgumentException {
        // Given
        UserInputDto validInput = new UserInputDto(1, 1, 0);

        // When

        // Then
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUserInputDtoInvalidHighColInputViaConstructor() throws IllegalArgumentException {
        // Given
        UserInputDto validInput = new UserInputDto(10, 2, 3);

        // When

        // Then
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUserInputDtoInvalidHighRowInputViaConstructor() throws IllegalArgumentException {
        // Given
        UserInputDto validInput = new UserInputDto(1, 10, 3);

        // When

        // Then
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUserInputDtoInvalidHighValInputViaConstructor() throws IllegalArgumentException {
        // Given
        UserInputDto validInput = new UserInputDto(1, 1, 10);

        // When

        // Then
    }

    @Test
    public void testUserInputDtoValidInputViaConstructorWithAnotherUserInputDto() throws IllegalArgumentException {
        // Given
        UserInputDto validInput = new UserInputDto(1, 2, 3);
        UserInputDto anotherValidInput = new UserInputDto(validInput);

        // When
        int validatedCol = anotherValidInput.getColIdx();
        int validatedRow = anotherValidInput.getRowIdx();
        int validatedVal = anotherValidInput.getVal();

        // Then
        assertEquals(0, validatedCol);
        assertEquals(1, validatedRow);
        assertEquals(3, validatedVal);
    }
}
