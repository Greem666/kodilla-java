package com.kodilla.rps.player;

import com.kodilla.rps.signs.*;
import org.junit.*;

import javax.swing.table.AbstractTableModel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.NoSuchElementException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RefereeTestSuite {
    Referee referee;
    AbstractPlayer humanPlayer;
    AbstractPlayer computerPlayer;
    AbstractPlayer mockComputerPlayer;

    //    Below entries are copied after the following stackoverflow article about testing of functions with Scanner class
    //    https://stackoverflow.com/questions/1647907/junit-how-to-simulate-system-in-testing
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("Starting Referee class tests...");
    }
    @Before
    public void beforeEachTest() {
        System.out.print("Now testing: ");
        this.referee = new Referee();
        this.humanPlayer = new HumanPlayer("humanPlayer");
        this.computerPlayer = new ComputerPlayer();
        this.mockComputerPlayer = mock(ComputerPlayer.class);  // mock to remove random behaviour of ComputerPlayer's pickASign() method
        when(this.mockComputerPlayer.pickASign(1)).thenReturn(new Rock());
        when(this.mockComputerPlayer.pickASign(2)).thenReturn(new Paper());
        when(this.mockComputerPlayer.pickASign(3)).thenReturn(new Scissors());
        when(this.mockComputerPlayer.pickASign(4)).thenReturn(new Lizard());
        when(this.mockComputerPlayer.pickASign(5)).thenReturn(new Spock());
    }
    //    Below entries are also copied from the following stackoverflow article about testing of functions with Scanner class
    //    https://stackoverflow.com/questions/1647907/junit-how-to-simulate-system-in-testing
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }
    private void provideInput(String data) {
            testIn = new ByteArrayInputStream(data.getBytes());
            System.setIn(testIn);
    }
    private String getOutput() {
        return testOut.toString();
    }


    @After
    public void afterEachTest() {
        System.out.println("Test complete.");
        restoreSystemInputOutput();
    }
    //    Below function is also copied from the following stackoverflow article about testing of functions with Scanner class
    //    https://stackoverflow.com/questions/1647907/junit-how-to-simulate-system-in-testing
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }
    @AfterClass
    public static void afterAllTests() {
        System.out.println("Ending Referee class tests...");
    }

    @Test(expected= NoSuchElementException.class)
    public void testChoosePlayerActionNoValidChoice() {
        // Given
        provideInput("10\n9\n8\n");
        this.referee = new Referee();  // reinitiated regardless of @Before to refresh System.in it is listening to

        System.out.println("Choosing player action - no valid choice.");

        // When
        int result = referee.chosePlayerAction();

        // Then
        // exception
    }

    @Test
    public void testChoosePlayerActionChosen5() {
        // Given
        provideInput("9\n8\n7\n5\n");
        this.referee = new Referee();  // reinitiated regardless of @Before to refresh System.in it is listening to

        System.out.println("Choosing player action - integer 5.");

        // When
        int result = referee.chosePlayerAction();

        // Then
        Assert.assertEquals(5, result);
    }

    @Test
    public void testChoosePlayerActionChosen4() {
        // Given
        provideInput("9\n8\n7\n4\n");
        this.referee = new Referee();  // reinitiated regardless of @Before to refresh System.in it is listening to

        System.out.println("Choosing player action - integer 4.");

        // When
        int result = referee.chosePlayerAction();

        // Then
        Assert.assertEquals(4, result);
    }

    @Test
    public void testChoosePlayerActionChosen3() {
        // Given
        provideInput("9\n8\n7\n3\n");
        this.referee = new Referee();  // reinitiated regardless of @Before to refresh System.in it is listening to

        System.out.println("Choosing player action - integer 3.");

        // When
        int result = referee.chosePlayerAction();

        // Then
        Assert.assertEquals(3, result);
    }

    @Test
    public void testChoosePlayerActionChosen2() {
        // Given
        provideInput("9\n8\n7\n2\n");
        this.referee = new Referee();  // reinitiated regardless of @Before to refresh System.in it is listening to

        System.out.println("Choosing player action - integer 2.");

        // When
        int result = referee.chosePlayerAction();

        // Then
        Assert.assertEquals(2, result);
    }

    @Test
    public void testChoosePlayerActionChosen1() {
        // Given
        provideInput("9\n8\n7\n1\n");
        this.referee = new Referee();  // reinitiated regardless of @Before to refresh System.in it is listening to

        System.out.println("Choosing player action - integer 1.");

        // When
        int result = referee.chosePlayerAction();

        // Then
        Assert.assertEquals(1, result);
    }

    @Test
    public void testChoosePlayerActionChosenLowercaseX() {
        // Given
        provideInput("98\n8\n7\nx");
        this.referee = new Referee();  // reinitiated regardless of @Before to refresh System.in it is listening to

        System.out.println("Choosing player action - lowercase x.");

        // When
        int result = referee.chosePlayerAction();

        // Then
        Assert.assertEquals(9, result);
    }

    @Test
    public void testChoosePlayerActionChosenUppercaseX() {
        // Given
        provideInput("99\n88\n77\nX");
        this.referee = new Referee();  // reinitiated regardless of @Before to refresh System.in it is listening to

        System.out.println("Choosing player action - uppercase X.");

        // When
        int result = referee.chosePlayerAction();

        // Then
        Assert.assertEquals(9, result);
    }

    @Test
    public void testChoosePlayerActionChosenLowercaseN() {
        // Given
        provideInput("99\n88\n77\nN");
        this.referee = new Referee();  // reinitiated regardless of @Before to refresh System.in it is listening to

        System.out.println("Choosing player action - lowercase n.");

        // When
        int result = referee.chosePlayerAction();

        // Then
        Assert.assertEquals(0, result);
    }

    @Test
    public void testChoosePlayerActionChosenUppercaseN() {
        // Given
        provideInput("99\n88\n77\nN");
        this.referee = new Referee();  // reinitiated regardless of @Before to refresh System.in it is listening to

        System.out.println("Choosing player action - uppercase N.");

        // When
        int result = referee.chosePlayerAction();

        // Then
        Assert.assertEquals(0, result);
    }

    @Test
    public void testAskForRoundsToWinGameThreeStringEntries() {
        // Given
        provideInput("aaaaa\naaaaa\naaaaa\n");
        this.referee = new Referee();  // reinitiated regardless of @Before to refresh System.in it is listening to

        System.out.println("Asking for rounds needed to win the game - 3 String types.");

        // When
        int result = referee.askForRoundsToWinGame();

        // Then
        Assert.assertEquals(-1, result);
    }

    @Test
    public void testAskForRoundsToWinGameTwoStringEntries1OutOfRangeInteger() {
        // Given
        provideInput("aaaaa\naaaaa\n11");
        this.referee = new Referee();  // reinitiated regardless of @Before to refresh System.in it is listening to

        System.out.println("Asking for rounds needed to win the game - 2 String types and 1 out of range integer.");

        // When
        int result = referee.askForRoundsToWinGame();

        // Then
        Assert.assertEquals(-1, result);
    }

    @Test
    public void testAskForRoundsToWinGameTwoStringEntries1CorrectInteger() {
        // Given
        provideInput("aaaaa\naaaaa\n5");
        this.referee = new Referee();  // reinitiated regardless of @Before to refresh System.in it is listening to

        System.out.println("Asking for rounds needed to win the game - 2 String types and 1 correct integer.");

        // When
        int result = referee.askForRoundsToWinGame();

        // Then
        Assert.assertEquals(5, result);
    }

    @Test
    public void testCheckWhoWonTheRoundPlayerSignStronger() {
        // Given
        // Declarations in @Before
        System.out.println("Check who won if player sign is stronger.");

        // When
        humanPlayer.pickASign(1);  // 1 - rock
        mockComputerPlayer.pickASign(3);  // 3 - scissors
        when(mockComputerPlayer.getSign()).thenReturn(new Scissors());
        AbstractPlayer winnerRock = referee.checkWhoWonTheRound(humanPlayer, mockComputerPlayer);
        int humanPlayerWinCount1 = humanPlayer.getWinsCount();

        humanPlayer.pickASign(2);  // 2 - paper
        mockComputerPlayer.pickASign(1);  // 1 - rock
        when(mockComputerPlayer.getSign()).thenReturn(new Rock());
        AbstractPlayer winnerPaper = referee.checkWhoWonTheRound(humanPlayer, mockComputerPlayer);
        int humanPlayerWinCount2 = humanPlayer.getWinsCount();

        humanPlayer.pickASign(3);  // 3 - scissors
        mockComputerPlayer.pickASign(2);  // 2 - paper
        when(mockComputerPlayer.getSign()).thenReturn(new Paper());
        AbstractPlayer winnerScissors = referee.checkWhoWonTheRound(humanPlayer, mockComputerPlayer);
        int humanPlayerWinCount3 = humanPlayer.getWinsCount();

        // Then
        Assert.assertEquals(humanPlayer, winnerRock);
        Assert.assertEquals(1, humanPlayerWinCount1);
        Assert.assertEquals(humanPlayer, winnerPaper);
        Assert.assertEquals(2, humanPlayerWinCount2);
        Assert.assertEquals(humanPlayer, winnerScissors);
        Assert.assertEquals(3, humanPlayerWinCount3);
    }

    @Test
    public void testCheckWhoWonTheRoundPlayerSignDrawsComputerSign() {
        // Given
        // Declarations in @Before
        System.out.println("Check who won if player sign draws computer sign.");

        // When
        humanPlayer.pickASign(1);  // 1 - rock
        mockComputerPlayer.pickASign(1);  // 1 - rock
        when(mockComputerPlayer.getSign()).thenReturn(new Rock());
        AbstractPlayer winnerRock = referee.checkWhoWonTheRound(humanPlayer, mockComputerPlayer);


        humanPlayer.pickASign(2);  // 2 - paper
        mockComputerPlayer.pickASign(2);  // 2 - paper
        when(mockComputerPlayer.getSign()).thenReturn(new Paper());
        AbstractPlayer winnerPaper = referee.checkWhoWonTheRound(humanPlayer, mockComputerPlayer);

        humanPlayer.pickASign(3);  // 3 - scissors
        mockComputerPlayer.pickASign(3);  // 3 - scissors
        when(mockComputerPlayer.getSign()).thenReturn(new Scissors());
        AbstractPlayer winnerScissors = referee.checkWhoWonTheRound(humanPlayer, mockComputerPlayer);

        // Then
        Assert.assertNull(winnerRock);
        Assert.assertNull(winnerPaper);
        Assert.assertNull(winnerScissors);
    }

    @Test
    public void testCheckWhoWonTheRoundPlayerSignWeaker() {
        // Given
        // Declarations in @Before
        System.out.println("Check who won if player sign is weaker.");

        // When
        humanPlayer.pickASign(1);  // 1 - rock
        mockComputerPlayer.pickASign(2);  // 2 - paper
        when(mockComputerPlayer.getSign()).thenReturn(new Paper());
        AbstractPlayer winnerRock = referee.checkWhoWonTheRound(humanPlayer, mockComputerPlayer);

        humanPlayer.pickASign(2);  // 2 - paper
        mockComputerPlayer.pickASign(3);  // 3 - scissors
        when(mockComputerPlayer.getSign()).thenReturn(new Scissors());
        AbstractPlayer winnerPaper = referee.checkWhoWonTheRound(humanPlayer, mockComputerPlayer);

        humanPlayer.pickASign(3);  // 3 - scissors
        mockComputerPlayer.pickASign(1);  // 1 - rock
        when(mockComputerPlayer.getSign()).thenReturn(new Rock());
        AbstractPlayer winnerScissors = referee.checkWhoWonTheRound(humanPlayer, mockComputerPlayer);

        // Then
        Assert.assertEquals(mockComputerPlayer, winnerRock);
        Assert.assertEquals(mockComputerPlayer, winnerPaper);
        Assert.assertEquals(mockComputerPlayer, winnerScissors);
    }

    @Test
    public void testCheckIfPlayerWonTheGameHumanPlayerWon() {
        // Given
        provideInput("3");
        this.referee = new Referee();
        this.referee.askForRoundsToWinGame();

        System.out.println("Check if human player won the game.");

        // When
        AbstractPlayer expectedDraw = referee.checkIfPlayerWonTheGame(humanPlayer, computerPlayer);

        humanPlayer.incrementWinsCount();
        computerPlayer.incrementWinsCount();
        AbstractPlayer expectedDraw2 = referee.checkIfPlayerWonTheGame(humanPlayer, computerPlayer);

        humanPlayer.incrementWinsCount();
        humanPlayer.incrementWinsCount();
        AbstractPlayer expectedHumanWin = referee.checkIfPlayerWonTheGame(humanPlayer, computerPlayer);

        // Then
        Assert.assertNull(expectedDraw);
        Assert.assertNull(expectedDraw2);
        Assert.assertEquals(this.humanPlayer, expectedHumanWin);
    }

    @Test
    public void testCheckIfPlayerWonTheGameHumanComputerWon() {
        // Given
        provideInput("5");
        this.referee = new Referee();
        this.referee.askForRoundsToWinGame();

        System.out.println("Check if human player won the game.");

        // When
        AbstractPlayer expectedDraw = referee.checkIfPlayerWonTheGame(humanPlayer, computerPlayer);

        this.computerPlayer.incrementWinsCount();
        this.computerPlayer.incrementWinsCount();
        this.computerPlayer.incrementWinsCount();
        this.computerPlayer.incrementWinsCount();
        this.computerPlayer.incrementWinsCount();
        AbstractPlayer expectedComputerWin = referee.checkIfPlayerWonTheGame(humanPlayer, computerPlayer);

        // Then
        Assert.assertNull(expectedDraw);
        Assert.assertEquals(this.computerPlayer, expectedComputerWin);
    }

    @Test
    public void testResetState() {
        // Given
        provideInput("5");
        this.referee = new Referee();
        this.referee.askForRoundsToWinGame();

        System.out.println("Resetting referee state.");

        // When
        this.computerPlayer.incrementWinsCount();
        this.computerPlayer.incrementWinsCount();
        this.computerPlayer.incrementWinsCount();
        this.computerPlayer.incrementWinsCount();
        this.computerPlayer.incrementWinsCount();
        this.humanPlayer.incrementWinsCount();
        this.humanPlayer.incrementWinsCount();
        referee.checkIfPlayerWonTheGame(this.humanPlayer, this.computerPlayer);

        // Then
        Assert.assertEquals(2, referee.getHumanPlayerScore());
        Assert.assertEquals(5, referee.getComputerPlayerScore());
        Assert.assertEquals(5, referee.getRoundsToWinTheGame());
        referee.resetState();
        Assert.assertEquals(0, referee.getHumanPlayerScore());
        Assert.assertEquals(0, referee.getComputerPlayerScore());
        Assert.assertEquals(0, referee.getRoundsToWinTheGame());
    }
}
