package com.kodilla.rps.player;

import com.kodilla.rps.signs.*;
import org.junit.*;
import org.mockito.stubbing.Answer;

import java.util.HashMap;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ComputerPlayerTestSuite {
    ComputerPlayer computerPlayer;
    ISign rock;
    ISign paper;
    ISign scissors;
    ISign lizard;
    ISign spock;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("Starting ComputerPlayer class tests...");
    }
    @Before
    public void beforeEachTest() {
        System.out.print("Now testing: ");
        this.computerPlayer = new ComputerPlayer();
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
        System.out.println("Ending ComputerPlayer class tests.");
    }

    @Test
    public void testPickASignWin50Draw25Loss25RatioRock() {
        // Given
        // Declarations in @Before
        System.out.println("Reaction to player sign Rock (expected 50% win ratio, 25% draw and loss ratios).");
        HashMap<ISign,Integer> counter = new HashMap<>();
        counter.put(paper, 0);
        counter.put(rock, 0);
        counter.put(scissors, 0);
        counter.put(lizard, 0);
        counter.put(spock, 0);

        // When
        int testCount = 100000;
        for (int i = 0; i < testCount; i++) {
            ISign result = this.computerPlayer.pickASign(1, false);  // 1 - Rock according to AbstractPlayer's HashMap
            counter.put(result, counter.get(result)+1);
        }

        // Then
        Assert.assertTrue(testCount * 0.12 < counter.get(scissors) && counter.get(scissors) < testCount * 0.13);
        Assert.assertTrue(testCount * 0.12 < counter.get(lizard) && counter.get(lizard) < testCount * 0.13);
        Assert.assertTrue(testCount * 0.24 < counter.get(rock) && counter.get(rock) < testCount * 0.26);
        Assert.assertTrue(testCount * 0.24 < counter.get(paper) && counter.get(paper) < testCount * 0.26);
        Assert.assertTrue(testCount * 0.24 < counter.get(spock) && counter.get(spock) < testCount * 0.26);
    }
    @Test
    public void testPickASignWin50Draw25Loss25RatioPaper() {
        // Given
        // Declarations in @Before
        System.out.println("Reaction to player sign Paper (expected 50% win ratio, 25% draw and loss ratios).");
        HashMap<ISign,Integer> counter = new HashMap<>();
        counter.put(paper, 0);
        counter.put(rock, 0);
        counter.put(scissors, 0);
        counter.put(lizard, 0);
        counter.put(spock, 0);

        // When
        int testCount = 100000;
        for (int i = 0; i < testCount; i++) {
            ISign result = this.computerPlayer.pickASign(2, false);  // 2 - Paper according to AbstractPlayer's HashMap
            counter.put(result, counter.get(result)+1);
        }
        System.out.println(counter);

        // Then
        Assert.assertTrue(testCount * 0.12 < counter.get(rock) && counter.get(rock) < testCount * 0.13);
        Assert.assertTrue(testCount * 0.12 < counter.get(spock) && counter.get(spock) < testCount * 0.13);
        Assert.assertTrue(testCount * 0.24 < counter.get(paper) && counter.get(paper) < testCount * 0.26);
        Assert.assertTrue(testCount * 0.24 < counter.get(scissors) && counter.get(scissors) < testCount * 0.26);
        Assert.assertTrue(testCount * 0.24 < counter.get(lizard) && counter.get(lizard) < testCount * 0.26);
    }
    @Test
    public void testPickASignWin50Draw25Loss25RatioScissors() {
        // Given
        // Declarations in @Before
        System.out.println("Reaction to player sign Scissors (expected 50% win ratio, 25% draw and loss ratios).");
        HashMap<ISign,Integer> counter = new HashMap<>();
        counter.put(paper, 0);
        counter.put(rock, 0);
        counter.put(scissors, 0);
        counter.put(lizard, 0);
        counter.put(spock, 0);

        // When
        int testCount = 100000;
        for (int i = 0; i < testCount; i++) {
            ISign result = this.computerPlayer.pickASign(3, false);  // 3 - Scissors according to AbstractPlayer's HashMap
            counter.put(result, counter.get(result)+1);
        }

        // Then
        Assert.assertTrue(testCount * 0.12 < counter.get(lizard) && counter.get(lizard) < testCount * 0.13);
        Assert.assertTrue(testCount * 0.12 < counter.get(paper) && counter.get(paper) < testCount * 0.13);
        Assert.assertTrue(testCount * 0.24 < counter.get(scissors) && counter.get(scissors) < testCount * 0.26);
        Assert.assertTrue(testCount * 0.24 < counter.get(rock) && counter.get(rock) < testCount * 0.26);
        Assert.assertTrue(testCount * 0.24 < counter.get(spock) && counter.get(spock) < testCount * 0.26);
    }
    @Test
    public void testPickASignWin50Draw25Loss25RatioLizard() {
        // Given
        // Declarations in @Before
        System.out.println("Reaction to player sign Lizard (expected 50% win ratio, 25% draw and loss ratios).");
        HashMap<ISign,Integer> counter = new HashMap<>();
        counter.put(paper, 0);
        counter.put(rock, 0);
        counter.put(scissors, 0);
        counter.put(lizard, 0);
        counter.put(spock, 0);

        // When
        int testCount = 100000;
        for (int i = 0; i < testCount; i++) {
            ISign result = this.computerPlayer.pickASign(4, false);  // 3 - Scissors according to AbstractPlayer's HashMap
            counter.put(result, counter.get(result)+1);
        }

        // Then
        Assert.assertTrue(testCount * 0.12 < counter.get(paper) && counter.get(paper) < testCount * 0.13);
        Assert.assertTrue(testCount * 0.12 < counter.get(spock) && counter.get(spock) < testCount * 0.13);
        Assert.assertTrue(testCount * 0.24 < counter.get(lizard) && counter.get(lizard) < testCount * 0.26);
        Assert.assertTrue(testCount * 0.24 < counter.get(rock) && counter.get(rock) < testCount * 0.26);
        Assert.assertTrue(testCount * 0.24 < counter.get(scissors) && counter.get(scissors) < testCount * 0.26);
    }
    @Test
    public void testPickASignWin50Draw25Loss25RatioSpock() {
        // Given
        // Declarations in @Before
        System.out.println("Reaction to player sign Lizard (expected 50% win ratio, 25% draw and loss ratios).");
        HashMap<ISign,Integer> counter = new HashMap<>();
        counter.put(paper, 0);
        counter.put(rock, 0);
        counter.put(scissors, 0);
        counter.put(lizard, 0);
        counter.put(spock, 0);

        // When
        int testCount = 100000;
        for (int i = 0; i < testCount; i++) {
            ISign result = this.computerPlayer.pickASign(5, false);  // 3 - Scissors according to AbstractPlayer's HashMap
            counter.put(result, counter.get(result)+1);
        }

        // Then
        Assert.assertTrue(testCount * 0.12 < counter.get(scissors) && counter.get(scissors) < testCount * 0.13);
        Assert.assertTrue(testCount * 0.12 < counter.get(rock) && counter.get(rock) < testCount * 0.13);
        Assert.assertTrue(testCount * 0.24 < counter.get(spock) && counter.get(spock) < testCount * 0.26);
        Assert.assertTrue(testCount * 0.24 < counter.get(lizard) && counter.get(lizard) < testCount * 0.26);
        Assert.assertTrue(testCount * 0.24 < counter.get(paper) && counter.get(paper) < testCount * 0.26);
    }

//    @Test
//    public void testPickADrawingSign() {
//        // Given
//        // Declarations in @Before
//        System.out.println("Picking a drawing sign.");
//
//        // When
//        ISign returnedSignAfterRock = this.computerPlayer.pickDrawingSign(rock);
//        ISign returnedSignAfterPaper = this.computerPlayer.pickDrawingSign(paper);
//        ISign returnedSignAfterScissors = this.computerPlayer.pickDrawingSign(scissors);
//
//        // Then
//        Assert.assertEquals(rock, returnedSignAfterRock);
//        Assert.assertEquals(paper, returnedSignAfterPaper);
//        Assert.assertEquals(scissors, returnedSignAfterScissors);
//    }
//
//    @Test
//    public void testPickALosingSign() {
//        // Given
//        // Declarations in @Before
//        System.out.println("Picking a losing sign.");
//
//        // When
//        ISign returnedSignAfterRock = this.computerPlayer.pickLosingSign(rock);
//        ISign returnedSignAfterPaper = this.computerPlayer.pickLosingSign(paper);
//        ISign returnedSignAfterScissors = this.computerPlayer.pickLosingSign(scissors);
//
//        // Then
//        Assert.assertEquals(scissors, returnedSignAfterRock);
//        Assert.assertEquals(rock, returnedSignAfterPaper);
//        Assert.assertEquals(paper, returnedSignAfterScissors);
//    }
//
//    @Test
//    public void testPickAWinningSign() {
//        // Given
//        // Declarations in @Before
//        System.out.println("Picking a winning sign.");
//
//        // When
//        ISign returnedSignAfterRock = this.computerPlayer.pickWinningSign(rock);
//        ISign returnedSignAfterPaper = this.computerPlayer.pickWinningSign(paper);
//        ISign returnedSignAfterScissors = this.computerPlayer.pickWinningSign(scissors);
//
//        // Then
//        Assert.assertEquals(paper, returnedSignAfterRock);
//        Assert.assertEquals(scissors, returnedSignAfterPaper);
//        Assert.assertEquals(rock, returnedSignAfterScissors);
//    }
}
