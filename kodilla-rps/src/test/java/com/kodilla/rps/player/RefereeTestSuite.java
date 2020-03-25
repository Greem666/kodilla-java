package com.kodilla.rps.player;

import com.kodilla.rps.signs.Paper;
import com.kodilla.rps.signs.Rock;
import com.kodilla.rps.signs.Scissors;
import org.junit.*;

import javax.swing.table.AbstractTableModel;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RefereeTestSuite {
    Referee referee;
    AbstractPlayer humanPlayer;
    AbstractPlayer computerPlayer;
    AbstractPlayer mockComputerPlayer;

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
    }
    @After
    public void afterEachTest() {
        System.out.println("Test complete.");
    }
    @AfterClass
    public static void afterAllTests() {
        System.out.println("Ending Referee class tests...");
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

        humanPlayer.pickASign(2);  // 2 - paper
        mockComputerPlayer.pickASign(1);  // 1 - rock
        when(mockComputerPlayer.getSign()).thenReturn(new Rock());
        AbstractPlayer winnerPaper = referee.checkWhoWonTheRound(humanPlayer, mockComputerPlayer);

        humanPlayer.pickASign(3);  // 3 - scissors
        mockComputerPlayer.pickASign(2);  // 2 - paper
        when(mockComputerPlayer.getSign()).thenReturn(new Paper());
        AbstractPlayer winnerScissors = referee.checkWhoWonTheRound(humanPlayer, mockComputerPlayer);

        // Then
        Assert.assertEquals(humanPlayer, winnerRock);
        Assert.assertEquals(humanPlayer, winnerPaper);
        Assert.assertEquals(humanPlayer, winnerScissors);
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
        // Declarations in @Before
        System.out.println("Check if human player won the game.");

        // When
        AbstractPlayer initialWinner = referee.checkIfPlayerWonTheGame(humanPlayer, computerPlayer);
        humanPlayer.incrementWinsCount();
        computerPlayer.incrementWinsCount();
        AbstractPlayer initialWinner = referee.checkIfPlayerWonTheGame(humanPlayer, computerPlayer);

        // Then
        Assert.assertEquals(mockComputerPlayer, winnerRock);
        Assert.assertEquals(mockComputerPlayer, winnerPaper);
        Assert.assertEquals(mockComputerPlayer, winnerScissors);
    }
}
