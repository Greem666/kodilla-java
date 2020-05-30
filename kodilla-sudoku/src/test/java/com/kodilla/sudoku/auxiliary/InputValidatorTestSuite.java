package com.kodilla.sudoku.auxiliary;

import org.junit.Assert;
import org.junit.Test;

public class InputValidatorTestSuite {
    @Test
    public void testInputValidatorIsValidInput() {
        // Given
        // --

        // When
        boolean validInputLow = InputValidator.isValidInput(1);
        boolean validInputHigh = InputValidator.isValidInput(9);

        boolean invalidInputLow = InputValidator.isValidInput(0);
        boolean invalidInputHigh = InputValidator.isValidInput(10);

        // Then
        Assert.assertTrue(validInputLow);
        Assert.assertTrue(validInputHigh);

        Assert.assertFalse(invalidInputLow);
        Assert.assertFalse(invalidInputHigh);
    }

    @Test
    public void testInputValidatorNormalizeInput() {
        // Given
        // --

        // When
        int lowInput = InputValidator.normalizeValue(1);
        int highInput = InputValidator.normalizeValue(9);

        // Then
        Assert.assertEquals(0, lowInput);
        Assert.assertEquals(8, highInput);
    }
}
