package com.kodilla.rps.signs;

import org.junit.*;

public class SignsTestSuite {
    private Paper paper;
    private Rock rock;
    private Scissors scissors;
    private Lizard lizard;
    private Spock spock;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("Signs test suite START.");
    }

    @Before
    public void beforeEachTest() {
        this.paper = new Paper(true);
        this.rock = new Rock(true);
        this.scissors = new Scissors(true);
        this.lizard = new Lizard(true);
        this.spock = new Spock(true);

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
        Boolean paperVsLizard = paper.isStrongerThan(lizard);
        Boolean paperVsSpock = paper.isStrongerThan(spock);

        // Then
        Assert.assertTrue(paperVsRock);
        Assert.assertTrue(paperVsSpock);
        Assert.assertNull(paperVsPaper);
        Assert.assertFalse(paperVsScissors);
        Assert.assertFalse(paperVsLizard);
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
        Boolean scissorsVsLizard = scissors.isStrongerThan(lizard);
        Boolean scissorsVsSpock = scissors.isStrongerThan(spock);

        // Then
        Assert.assertTrue(scissorsVsPaper);
        Assert.assertTrue(scissorsVsLizard);
        Assert.assertNull(scissorsVsScissors);
        Assert.assertFalse(scissorsVsRock);
        Assert.assertFalse(scissorsVsSpock);
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
        Boolean rockVsLizard = rock.isStrongerThan(lizard);
        Boolean rockVsSpock = rock.isStrongerThan(spock);

        // Then
        Assert.assertTrue(rockVsScissors);
        Assert.assertTrue(rockVsLizard);
        Assert.assertNull(rockVsRock);
        Assert.assertFalse(rockVsPaper);
        Assert.assertFalse(rockVsSpock);
    }
    @Test
    public void testLizardFightSimulation() {
        // Given
        // Declarations in @Before
        System.out.println("Lizard Vs the rest.");

        // When
        Boolean lizardVsRock = lizard.isStrongerThan(rock);
        Boolean lizardVsScissors = lizard.isStrongerThan(scissors);
        Boolean lizardVsPaper = lizard.isStrongerThan(paper);
        Boolean lizardVsLizard = lizard.isStrongerThan(lizard);
        Boolean lizardVsSpock = lizard.isStrongerThan(spock);

        // Then
        Assert.assertTrue(lizardVsPaper);
        Assert.assertTrue(lizardVsSpock);
        Assert.assertNull(lizardVsLizard);
        Assert.assertFalse(lizardVsScissors);
        Assert.assertFalse(lizardVsRock);
    }
    @Test
    public void testSpockFightSimulation() {
        // Given
        // Declarations in @Before
        System.out.println("Spock Vs the rest.");

        // When
        Boolean spockVsRock = spock.isStrongerThan(rock);
        Boolean spockVsScissors = spock.isStrongerThan(scissors);
        Boolean spockVsPaper = spock.isStrongerThan(paper);
        Boolean spockVsLizard = spock.isStrongerThan(lizard);
        Boolean spockVsSpock = spock.isStrongerThan(spock);

        // Then
        Assert.assertTrue(spockVsRock);
        Assert.assertTrue(spockVsScissors);
        Assert.assertNull(spockVsSpock);
        Assert.assertFalse(spockVsPaper);
        Assert.assertFalse(spockVsLizard);
    }
}
