package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testTestAverage() {
        // Given
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] b = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int[] c = {123, 124, 125, 234, 235, 236, 345, 346, 347};
        int[] d = {};
        int[] e = {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0};

        // When
        double averageA = ArrayOperations.getAverage(a);
        double averageB = ArrayOperations.getAverage(b);
        double averageC = ArrayOperations.getAverage(c);
        double averageD = ArrayOperations.getAverage(d);
        double averageE = ArrayOperations.getAverage(e);

        // Then
        Assert.assertEquals(5.5, averageA, 0.001);
        Assert.assertEquals(55.0, averageB, 0.001);
        Assert.assertEquals(235.0, averageC, 0.001);
        Assert.assertEquals(0.0, averageD, 0.001);
        Assert.assertEquals(-5.0, averageE, 0.001);
    }
}
