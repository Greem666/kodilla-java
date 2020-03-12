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

    @Test
    public void testCreateShapes() {
        System.out.println("Shape creation");

        // Given
        // Declarations in @Before function

        // When
        Triangle expectedTriangle = new Triangle(5.0, 10.0);
        Square expectedSquare = new Square(10.0);
        Circle expectedCircle = new Circle(10.0);

        // Then
        Assert.assertEquals(expectedTriangle, this.triangle);
        Assert.assertEquals(expectedSquare, this.square);
        Assert.assertEquals(expectedCircle, this.circle);
    }

    @Test
    public void testCreateShapesIncorrectDimensions() {
        System.out.println("Shape creation - incorrect dimensions");

        // Given
        Triangle triangle1 = new Triangle(-1.33, -20.0);
        Triangle triangle2 = new Triangle(-1.33, 0.0);
        Triangle triangle3 = new Triangle(-1.33, 20.0);
        Triangle triangle4 = new Triangle(0.0, -20.0);
        Triangle triangle5 = new Triangle(1.33, -20.0);

        Square square1 = new Square(-20.0);
        Square square2 = new Square(0.0);

        Circle circle1 = new Circle(-1.33);
        Circle circle2 = new Circle(0.0);

        // When
        Triangle expectedTriangle = new Triangle(0.0, 0.0);
        Square expectedSquare = new Square(0.0);
        Circle expectedCircle = new Circle(0.0);

        // Then
        Assert.assertEquals(expectedTriangle, triangle1);
        Assert.assertEquals(expectedTriangle, triangle2);
        Assert.assertEquals(expectedTriangle, triangle3);
        Assert.assertEquals(expectedTriangle, triangle4);
        Assert.assertEquals(expectedTriangle, triangle5);
        Assert.assertEquals(expectedSquare, square1);
        Assert.assertEquals(expectedSquare, square2);
        Assert.assertEquals(expectedCircle, circle1);
        Assert.assertEquals(expectedCircle, circle1);
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
        Assert.assertTrue(shapeCollector.getShapesList().contains(this.triangle));
        Assert.assertTrue(shapeCollector.getShapesList().contains(this.square));
        Assert.assertTrue(shapeCollector.getShapesList().contains(this.circle));
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
        Assert.assertFalse(shapeCollector.getShapesList().contains(this.triangle));
        Assert.assertFalse(shapeCollector.getShapesList().contains(this.square));
        Assert.assertFalse(shapeCollector.getShapesList().contains(this.circle));
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
