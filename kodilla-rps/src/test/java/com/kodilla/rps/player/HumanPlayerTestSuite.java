package com.kodilla.rps.player;

import com.kodilla.rps.signs.*;
import org.junit.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HumanPlayerTestSuite {
    HumanPlayer humanPlayer;
    ISign rock;
    ISign paper;
    ISign scissors;
    ISign lizard;
    ISign spock;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("Starting HumanPlayer class tests...");
    }
    @Before
    public void beforeEachTest() {
        System.out.print("Now testing: ");
        this.humanPlayer = new HumanPlayer("humanPlayer");
        this.rock = new Rock();
        this.paper = new Paper();
        this.scissors = new Scissors();
        this.lizard = new Lizard();
        this.spock = new Spock();
    }
    @After
    public void afterEachTest() {
        System.out.println("Test complete.");
    }
    @AfterClass
    public static void afterAllTests() {
        System.out.println("Ending HumanPlayer class tests.");
    }

    @Test
    public void testWinsCountIncrementation() {
        // Given
        // Declarations in @Before
        System.out.println("Wins count incrementation.");

        // When
        int initialWinsCount = this.humanPlayer.getWinsCount();
        this.humanPlayer.incrementWinsCount();
        this.humanPlayer.incrementWinsCount();
        this.humanPlayer.incrementWinsCount();
        int after3IncrementationsWinsCount = this.humanPlayer.getWinsCount();

        // Then
        Assert.assertEquals(0, initialWinsCount);
        Assert.assertEquals(3, after3IncrementationsWinsCount);
    }

    @Test
    public void testPickASign() {
        // Given
        // Declarations in @Before
        System.out.println("Correct sign picking.");

        // When
        ISign initialSignAfterInitialization = this.humanPlayer.getSign();

        //        Incorrect values
        ISign signReturnedAfterSelectingNegativeValue = this.humanPlayer.pickASign(-99, false);
        ISign signHeldInFieldAfterSelectingNegativeValue = this.humanPlayer.getSign();

        ISign signReturnedAfterSelectingZero = this.humanPlayer.pickASign(0, false);
        ISign signHeldInFieldAfterSelectingZero = this.humanPlayer.getSign();

        ISign signReturnedAfterSelecting6 = this.humanPlayer.pickASign(6, false);
        ISign signHeldInFieldAfterSelecting6 = this.humanPlayer.getSign();

        //      Correct values
        ISign signReturnedAfterSelecting1 = this.humanPlayer.pickASign(1, false);
        ISign signHeldInFieldAfterSelecting1 = this.humanPlayer.getSign();

        ISign signReturnedAfterSelecting2 = this.humanPlayer.pickASign(2, false);
        ISign signHeldInFieldAfterSelecting2 = this.humanPlayer.getSign();

        ISign signReturnedAfterSelecting3 = this.humanPlayer.pickASign(3, false);
        ISign signHeldInFieldAfterSelecting3 = this.humanPlayer.getSign();

        ISign signReturnedAfterSelecting4 = this.humanPlayer.pickASign(4, false);
        ISign signHeldInFieldAfterSelecting4 = this.humanPlayer.getSign();

        ISign signReturnedAfterSelecting5 = this.humanPlayer.pickASign(5, false);
        ISign signHeldInFieldAfterSelecting5 = this.humanPlayer.getSign();

        // Then
        Assert.assertNull(initialSignAfterInitialization);
        Assert.assertNull(signReturnedAfterSelectingNegativeValue);
        Assert.assertNull(signHeldInFieldAfterSelectingNegativeValue);
        Assert.assertNull(signReturnedAfterSelectingZero);
        Assert.assertNull(signHeldInFieldAfterSelectingZero);
        Assert.assertNull(signReturnedAfterSelecting6);
        Assert.assertNull(signHeldInFieldAfterSelecting6);
        Assert.assertEquals(rock, signReturnedAfterSelecting1);
        Assert.assertEquals(rock, signHeldInFieldAfterSelecting1);
        Assert.assertEquals(paper, signReturnedAfterSelecting2);
        Assert.assertEquals(paper, signHeldInFieldAfterSelecting2);
        Assert.assertEquals(scissors, signReturnedAfterSelecting3);
        Assert.assertEquals(scissors, signHeldInFieldAfterSelecting3);
        Assert.assertEquals(lizard, signReturnedAfterSelecting4);
        Assert.assertEquals(lizard, signHeldInFieldAfterSelecting4);
        Assert.assertEquals(spock, signReturnedAfterSelecting5);
        Assert.assertEquals(spock, signHeldInFieldAfterSelecting5);
    }

    @Test
    public void testResetSign() {
        // Given
        // Declarations in @Before
        System.out.println("Correct sign resetting.");

        // When
        this.humanPlayer.pickASign(1, false);
        this.humanPlayer.resetSign();
        ISign signHeldInFieldAfterResettingSign = this.humanPlayer.getSign();


        // Then
        Assert.assertNull(signHeldInFieldAfterResettingSign);
    }

    @Test
    public void testGetName() {
        // Given
        this.humanPlayer = new HumanPlayer("humanPlayer");
        System.out.println("Getting instance name.");

        // When
        String returnedName = this.humanPlayer.getName();

        // Then
        Assert.assertEquals("humanPlayer", returnedName);
    }

    @Test
    public void testToString() {
        // Given
        // Declarations in @Before
        System.out.println("Correct instance printing.");

        // When
        String initialInstanceString = this.humanPlayer.toString();
        String expectedInstanceString = "Player: humanPlayer (wins: 0)";

        this.humanPlayer.incrementWinsCount();
        this.humanPlayer.incrementWinsCount();
        this.humanPlayer.incrementWinsCount();

        String instanceStringAfter3WinsIncrementations = this.humanPlayer.toString();
        String expectedInstanceStringAfter3WinsIncrementations = "Player: humanPlayer (wins: 3)";


        // Then
        Assert.assertEquals(expectedInstanceString, initialInstanceString);
        Assert.assertEquals(expectedInstanceStringAfter3WinsIncrementations, instanceStringAfter3WinsIncrementations);
    }

    @Test
    public void testResetWinsCount() {
        // Given
        // Declarations in @Before
        System.out.println("Wins count resetting.");

        // When
        humanPlayer.incrementWinsCount();
        humanPlayer.incrementWinsCount();
        humanPlayer.incrementWinsCount();

        // Then
        Assert.assertEquals(3, humanPlayer.getWinsCount());
        humanPlayer.resetWinsCount();
        Assert.assertEquals(0, humanPlayer.getWinsCount());

    }
}
