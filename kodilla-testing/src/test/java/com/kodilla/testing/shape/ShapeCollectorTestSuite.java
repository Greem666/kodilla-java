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

    // Shape tests

    @Test(expected = NonPositiveDimensionsException.class)
    public void testCreateShapesTriangleBaseHeightNegative() throws NonPositiveDimensionsException {
        System.out.println("Triangle creation - base and height negative");

        Triangle triangle = new Triangle(-1.33, -20.0);
    }

    @Test(expected = NonPositiveDimensionsException.class)
    public void testCreateShapesTriangleBaseNegativeHeightZero() throws NonPositiveDimensionsException {
        System.out.println("Triangle creation - base negative and height zero");

        Triangle triangle = new Triangle(-1.33, 0.0);
    }

    @Test(expected = NonPositiveDimensionsException.class)
    public void testCreateShapesTriangleBaseHeightZero() throws NonPositiveDimensionsException {
        System.out.println("Triangle creation - base and height zero");

        Triangle triangle = new Triangle(0.0, 0.0);
    }

    @Test(expected = NonPositiveDimensionsException.class)
    public void testCreateShapesTriangleBaseZeroHeightNegative() throws NonPositiveDimensionsException {
        System.out.println("Triangle creation - base zero and height negative");

        Triangle triangle = new Triangle(0.0, -1.33);
    }

    @Test(expected = NonPositiveDimensionsException.class)
    public void testCreateShapesSquareNegativeSide() throws NonPositiveDimensionsException {
        System.out.println("Square creation - side negative");

        Square square = new Square(-1.33);
    }

    @Test(expected = NonPositiveDimensionsException.class)
    public void testCreateShapesSquareZeroSide() throws NonPositiveDimensionsException {
        System.out.println("Square creation - side zero");

        Square square = new Square(0.0);
    }

    @Test(expected = NonPositiveDimensionsException.class)
    public void testCreateShapesCircleNegativeRadius() throws NonPositiveDimensionsException {
        System.out.println("Circle creation - radius negative");

        Circle circle = new Circle(-1.33);
    }

    @Test(expected = NonPositiveDimensionsException.class)
    public void testCreateShapesCircleZeroRadius() throws NonPositiveDimensionsException {
        System.out.println("Circle creation - radius zero");

        Circle circle = new Circle(0.0);
    }

    @Test
    public void testGetShapeName() {
        System.out.println("Shape getShapeName()");

        // Given
        // Declarations in @Before function

        // When
        String expectedTriangleName = "triangle";
        String expectedSquareName = "square";
        String expectedCircleName = "circle";

        // Then
        Assert.assertEquals(expectedTriangleName, this.triangle.getShapeName());
        Assert.assertEquals(expectedSquareName, this.square.getShapeName());
        Assert.assertEquals(expectedCircleName, this.circle.getShapeName());
    }

    @Test
    public void testGetField() {
        System.out.println("Shape getField()");

        // Given
        // Declarations in @Before function

        // When
        Double expectedTriangleField = 0.5 * 5.0 * 10.0;
        Double expectedSquareField = 10.0 * 10.0;
        Double expectedCircleField = Math.PI * 10 * 10;

        // Then
        Assert.assertEquals(expectedTriangleField, this.triangle.getField());
        Assert.assertEquals(expectedSquareField, this.square.getField());
        Assert.assertEquals(expectedCircleField, this.circle.getField());
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
    }
}
