package com.kodilla.rps.signs;

import org.junit.*;

public class SignsTestSuite {
    private Paper paper;
    private Rock rock;
    private Scissors scissors;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("Signs test suite START.");
    }

    @Before
    public void beforeEachTest() {
        this.paper = new Paper(true);
        this.rock = new Rock(true);
        this.scissors = new Scissors(true);

        System.out.print("Testing: ");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("Signs test suite END.");
    }

    @Test
    public void testPaperFightSimulation() {
        // Given
        // Declarations in @Before
        System.out.println("Paper Vs the rest.");

        // When
        Boolean paperVsRock = paper.isStrongerThan(rock);
        Boolean paperVsScissors = paper.isStrongerThan(scissors);
        Boolean paperVsPaper = paper.isStrongerThan(paper);
        System.out.println(paperVsRock + " " + paperVsScissors + " " + paperVsPaper);

        // Then
        Assert.assertTrue(paperVsRock);
        Assert.assertNull(paperVsPaper);
        Assert.assertFalse(paperVsScissors);
    }

    @Test
    public void testScissorsFightSimulation() {
        // Given
        // Declarations in @Before
        System.out.println("Scissors Vs the rest.");

        // When
        Boolean scissorsVsRock = scissors.isStrongerThan(rock);
        Boolean scissorsVsScissors = scissors.isStrongerThan(scissors);
        Boolean scissorsVsPaper = scissors.isStrongerThan(paper);

        // Then
        Assert.assertTrue(scissorsVsPaper);
        Assert.assertNull(scissorsVsScissors);
        Assert.assertFalse(scissorsVsRock);
    }
    @Test
    public void testRockFightSimulation() {
        // Given
        // Declarations in @Before
        System.out.println("Rock Vs the rest.");

        // When
        Boolean rockVsRock = rock.isStrongerThan(rock);
        Boolean rockVsScissors = rock.isStrongerThan(scissors);
        Boolean rockVsPaper = rock.isStrongerThan(paper);

        // Then
        Assert.assertTrue(rockVsScissors);
        Assert.assertNull(rockVsRock);
        Assert.assertFalse(rockVsPaper);
    }

}
