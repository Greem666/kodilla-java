package com.kodilla.patterns.factory;

import org.junit.Assert;
import org.junit.Test;

public class ShapeFactoryTestSuite {
    @Test
    public void testFactoryCircle() {
        // Given
        ShapeFactory factory = new ShapeFactory();

        // When
        Shape circle = factory.makeShape(ShapeFactory.CIRCLE);

        // Then
        Assert.assertEquals(Math.PI * Math.pow(4.50, 2.0), circle.getArea(), 0);
        Assert.assertEquals("A rounded circle", circle.getName());
    }

    @Test
    public void testFactorySquare() {
        // Given
        ShapeFactory factory = new ShapeFactory();

        // When
        Shape square = factory.makeShape(ShapeFactory.SQUARE);

        // Then
        Assert.assertEquals(Math.pow(7.0, 2.0), square.getArea(), 0);
        Assert.assertEquals("An angular square", square.getName());
    }

    @Test
    public void testFactoryRectangle() {
        // Given
        ShapeFactory factory = new ShapeFactory();

        // When
        Shape rectangle = factory.makeShape(ShapeFactory.RECTANGLE);

        // Then
        Assert.assertEquals(15.0 * 2.50, rectangle.getArea(), 0);
        Assert.assertEquals("A long rectangle", rectangle.getName());
    }
}
