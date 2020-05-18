package com.kodilla.patterns.builder.checkers;

import org.junit.Assert;
import org.junit.Test;

public class CheckersTestSuite {
    @Test
    public void testCheckersBuilder() {
        // Given
        Checkers checkers = new Checkers.CheckersBuilder()
                .PlayerOne("Matt")
                .PlayerTwo("Jo")
                .Figure(FigureFactory.PAWN, Figure.BLACK, 3, 0)
                .Figure(FigureFactory.QUEEN, Figure.BLACK, 3, 7)
                .Figure(FigureFactory.PAWN, Figure.WHITE, 4, 2)
                .Figure(FigureFactory.QUEEN, Figure.WHITE, 4, 8)
                .build();
        System.out.println(checkers.getBoard());

        // When
        Figure figureOne = checkers.getBoard().getFigure(3, 0);
        Figure figureTwo = checkers.getBoard().getFigure(3, 7);
        Figure figureThree = checkers.getBoard().getFigure(4, 2);
        Figure figureFour = checkers.getBoard().getFigure(4, 8);
        Figure figureFive = checkers.getBoard().getFigure(1, 8);

        // Then
        Assert.assertEquals(Figure.BLACK, figureOne.getColor());
        Assert.assertEquals(Queen.class, figureTwo.getClass());
        Assert.assertEquals(Pawn.class, figureThree.getClass());
        Assert.assertEquals(Figure.WHITE, figureFour.getColor());
        Assert.assertNull(figureFive);
    }
}
