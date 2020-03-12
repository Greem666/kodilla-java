package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionTestSuite {
    @Before
    public void before() {
        System.out.print("Test starting: ");
    }
    @After
    public void after() {
        System.out.println("Test complete.");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite COLLECTION start.");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite COLLECTION end.");
    }
    @Test
    public void oddNumbersExterminatorEmptyList() {
        // Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        // When
        ArrayList<Integer> emptyList = new ArrayList<>();
        ArrayList<Integer> result = oddNumbersExterminator.exterminate(emptyList);
        System.out.println("empty list");
        // Assert
        Assert.assertEquals(emptyList, result);
    }
    @Test
    public void oddNumbersExterminatorNormalList() {
        // Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        // When
        ArrayList<Integer> normalList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        ArrayList<Integer> result = oddNumbersExterminator.exterminate(normalList);
        ArrayList<Integer> evenNumbersSubGroupList = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        System.out.println("normal list");
        // Assert
        Assert.assertEquals(evenNumbersSubGroupList, result);
    }
}
