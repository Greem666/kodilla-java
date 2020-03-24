package com.kodilla.rps.player;

import com.kodilla.rps.signs.ISign;
import com.kodilla.rps.signs.Paper;
import com.kodilla.rps.signs.Rock;
import com.kodilla.rps.signs.Scissors;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.stubbing.Answer;

import java.util.HashMap;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ComputerPlayerTestSuite {
    @Test
    public void testPickASignWin50Draw25Loss25RatioRock() {
        // Given
        ComputerPlayer computerPlayer = new ComputerPlayer();

        Paper paper = new Paper();
        Rock rock = new Rock();
        Scissors scissors = new Scissors();
        HashMap<ISign,Integer> counter = new HashMap<>();
        counter.put(paper, 0);
        counter.put(rock, 0);
        counter.put(scissors, 0);

        // When
        int testCount = 1000000;
        for (int i = 0; i < testCount; i++) {
            ISign result = computerPlayer.pickASign(1);  // 1 - Rock according to AbstractPlayer's HashMap
            counter.put(result, counter.get(result)+1);
        }

        // Then
        System.out.println(counter);
        Assert.assertTrue(testCount * 0.24 < counter.get(scissors) && counter.get(scissors) < testCount * 0.26);
        Assert.assertTrue(testCount * 0.24 < counter.get(rock) && counter.get(rock) < testCount * 0.26);
        Assert.assertTrue(testCount * 0.48 < counter.get(paper) && counter.get(paper) < testCount * 0.52);
    }
    @Test
    public void testPickASignWin50Draw25Loss25RatioPaper() {
        // Given
        ComputerPlayer computerPlayer = new ComputerPlayer();

        Paper paper = new Paper();
        Rock rock = new Rock();
        Scissors scissors = new Scissors();
        HashMap<ISign,Integer> counter = new HashMap<>();
        counter.put(paper, 0);
        counter.put(rock, 0);
        counter.put(scissors, 0);

        // When
        int testCount = 1000000;
        for (int i = 0; i < testCount; i++) {
            ISign result = computerPlayer.pickASign(2);  // 2 - Paper according to AbstractPlayer's HashMap
            counter.put(result, counter.get(result)+1);
        }

        // Then
        System.out.println(counter);
        Assert.assertTrue(testCount * 0.24 < counter.get(paper) && counter.get(paper) < testCount * 0.26);
        Assert.assertTrue(testCount * 0.24 < counter.get(rock) && counter.get(rock) < testCount * 0.26);
        Assert.assertTrue(testCount * 0.48 < counter.get(scissors) && counter.get(scissors) < testCount * 0.52);
    }
    @Test
    public void testPickASignWin50Draw25Loss25RatioScissors() {
        // Given
        ComputerPlayer computerPlayer = new ComputerPlayer();

        Paper paper = new Paper();
        Rock rock = new Rock();
        Scissors scissors = new Scissors();
        HashMap<ISign,Integer> counter = new HashMap<>();
        counter.put(paper, 0);
        counter.put(rock, 0);
        counter.put(scissors, 0);

        // When
        int testCount = 1000000;
        for (int i = 0; i < testCount; i++) {
            ISign result = computerPlayer.pickASign(3);  // 3 - Scissors according to AbstractPlayer's HashMap
            counter.put(result, counter.get(result)+1);
        }

        // Then
        System.out.println(counter);
        Assert.assertTrue(testCount * 0.24 < counter.get(paper) && counter.get(paper) < testCount * 0.26);
        Assert.assertTrue(testCount * 0.24 < counter.get(scissors) && counter.get(scissors) < testCount * 0.26);
        Assert.assertTrue(testCount * 0.48 < counter.get(rock) && counter.get(rock) < testCount * 0.52);
    }
}
