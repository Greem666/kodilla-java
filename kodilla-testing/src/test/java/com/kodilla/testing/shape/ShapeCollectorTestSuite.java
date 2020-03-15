package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {
    public static int counter = 0;
    public ShapeCollector shapeCollector;
    public Triangle triangle;
    public Square square;
    public Circle circle;

    @Before
    public void beforeEachTest() throws Exception {
        System.out.print("Starting test: ");
        this.shapeCollector = new ShapeCollector();
        this.triangle = new Triangle(5.0, 10.0);
        this.square = new Square(10.0);
        this.circle = new Circle(10.0);
    }

    @BeforeClass
    public static void beforeAllTests() {
        counter++;
        System.out.println("Starting test suite for class ShapeCollector.");
    }

    @After
    public void afterEachTest() {
        System.out.println("Test finished.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("Test suite for ShapeCollector is done.");
    }

    // ShapeCollector tests

    @Test
    public void testAddFigure() {
        System.out.println("addFigure()");

        // Given
        // Declarations in @Before function

        // When
        boolean resultAddTriangle = shapeCollector.addFigure(this.triangle);
        boolean resultAddSquare = shapeCollector.addFigure(this.square);
        boolean resultAddCircle = shapeCollector.addFigure(this.circle);

        // Then
        Assert.assertTrue(resultAddTriangle);
        Assert.assertTrue(resultAddSquare);
        Assert.assertTrue(resultAddCircle);
    }

    @Test
    public void testRemoveFigure() {
        System.out.println("removeFigure()");

        // Given
        // Declarations in @Before function

        // When
        shapeCollector.addFigure(this.triangle);
        shapeCollector.addFigure(this.square);
        shapeCollector.addFigure(this.circle);

        boolean resultRemoveTriangle = shapeCollector.removeFigure(this.triangle);
        boolean resultRemoveSquare = shapeCollector.removeFigure(this.square);
        boolean resultRemoveCircle = shapeCollector.removeFigure(this.circle);

        // Then
        Assert.assertTrue(resultRemoveTriangle);
        Assert.assertTrue(resultRemoveSquare);
        Assert.assertTrue(resultRemoveCircle);
    }

    @Test
    public void testRemoveFigureNonExisting() {
        System.out.println("removeFigure() non-existing");

        // Given
        // Declarations in @Before function

        // When
        boolean resultRemoveTriangle = shapeCollector.removeFigure(this.triangle);
        boolean resultRemoveSquare = shapeCollector.removeFigure(this.square);
        boolean resultRemoveCircle = shapeCollector.removeFigure(this.circle);

        // Then
        Assert.assertFalse(resultRemoveTriangle);
        Assert.assertFalse(resultRemoveSquare);
        Assert.assertFalse(resultRemoveCircle);
    }

    @Test
    public void testGetFigure() {
        System.out.println("getFigure()");

        // Given
        // Declarations in @Before function

        // When
        shapeCollector.addFigure(this.triangle);
        shapeCollector.addFigure(this.square);
        shapeCollector.addFigure(this.circle);

        // Then
        Assert.assertEquals(this.triangle, shapeCollector.getFigure(0));
        Assert.assertEquals(this.square, shapeCollector.getFigure(1));
        Assert.assertEquals(this.circle, shapeCollector.getFigure(2));
    }

    @Test
    public void testGetFigureIndexOutOfBound() {
        System.out.println("getFigure() out of bounds");

        // Given
        // Declarations in @Before function

        // When
        shapeCollector.addFigure(this.triangle);
        shapeCollector.addFigure(this.square);
        shapeCollector.addFigure(this.circle);

        // Then
        Assert.assertNull(shapeCollector.getFigure(3));
        Assert.assertNull(shapeCollector.getFigure(100));
        Assert.assertNull(shapeCollector.getFigure(-100));
    }

    @Test
    public void testShowFigures() {
        // Given
        // Declarations in @Before function

        // When
        shapeCollector.addFigure(this.triangle);
        shapeCollector.addFigure(this.square);
        shapeCollector.addFigure(this.circle);
        String result = shapeCollector.showFigures();
        String expectedOutput = String.format("triangle - %.2f, square - %.2f, circle - %.2f, ",
                0.5 * 5.0 * 10.0, 10.0 * 10.0, Math.PI * 10.0 * 10.0);

        // Then
        Assert.assertEquals(expectedOutput, result);

    }
}
