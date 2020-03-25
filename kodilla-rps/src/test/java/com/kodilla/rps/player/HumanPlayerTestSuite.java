package com.kodilla.rps.player;

import com.kodilla.rps.signs.ISign;
import com.kodilla.rps.signs.Paper;
import com.kodilla.rps.signs.Rock;
import com.kodilla.rps.signs.Scissors;
import org.junit.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HumanPlayerTestSuite {
    HumanPlayer humanPlayer;
    ISign rock;
    ISign paper;
    ISign scissors;

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
    public void testSignOptionsCorrectContent() {
        // Given
        // Declarations in @Before
        System.out.println("Correct content of signOptions.");

        // When

        // Then
        Assert.assertEquals(3, humanPlayer.signOptions.size());
        Assert.assertEquals(rock, humanPlayer.signOptions.get(1));
        Assert.assertEquals(paper, humanPlayer.signOptions.get(2));
        Assert.assertEquals(scissors, humanPlayer.signOptions.get(3));
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

        ISign signReturnedAfterSelectingNegativeValue = this.humanPlayer.pickASign(-99);
        ISign signHeldInFieldAfterSelectingNegativeValue = this.humanPlayer.getSign();

        ISign signReturnedAfterSelectingZero = this.humanPlayer.pickASign(0);
        ISign signHeldInFieldAfterSelectingZero = this.humanPlayer.getSign();

        ISign signReturnedAfterSelecting4 = this.humanPlayer.pickASign(4);
        ISign signHeldInFieldAfterSelecting4 = this.humanPlayer.getSign();

        ISign signReturnedAfterSelecting1 = this.humanPlayer.pickASign(1);
        ISign signHeldInFieldAfterSelecting1 = this.humanPlayer.getSign();

        ISign signReturnedAfterSelecting2 = this.humanPlayer.pickASign(2);
        ISign signHeldInFieldAfterSelecting2 = this.humanPlayer.getSign();

        ISign signReturnedAfterSelecting3 = this.humanPlayer.pickASign(3);
        ISign signHeldInFieldAfterSelecting3 = this.humanPlayer.getSign();

        // Then
        Assert.assertNull(initialSignAfterInitialization);
        Assert.assertNull(signReturnedAfterSelectingNegativeValue);
        Assert.assertNull(signHeldInFieldAfterSelectingNegativeValue);
        Assert.assertNull(signReturnedAfterSelectingZero);
        Assert.assertNull(signHeldInFieldAfterSelectingZero);
        Assert.assertNull(signReturnedAfterSelecting4);
        Assert.assertNull(signHeldInFieldAfterSelecting4);
        Assert.assertEquals(rock, signReturnedAfterSelecting1);
        Assert.assertEquals(rock, signHeldInFieldAfterSelecting1);
        Assert.assertEquals(paper, signReturnedAfterSelecting2);
        Assert.assertEquals(paper, signHeldInFieldAfterSelecting2);
        Assert.assertEquals(scissors, signReturnedAfterSelecting3);
        Assert.assertEquals(scissors, signHeldInFieldAfterSelecting3);
    }

    @Test
    public void testResetSign() {
        // Given
        // Declarations in @Before
        System.out.println("Correct sign resetting.");

        // When
        this.humanPlayer.pickASign(1);
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
}
