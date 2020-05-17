package com.kodilla.patterns.factory;

public class ShapeFactory {
    public static final String CIRCLE = "CIRCLE";
    public static final String SQUARE = "SQUARE";
    public static final String RECTANGLE = "RECTANGLE";

    public final Shape makeShape(final String shape) {
        switch (shape) {
            case CIRCLE:
                return new Circle("A rounded circle", 4.50);
            case SQUARE:
                return new Square("An angular square", 7.0);
            case RECTANGLE:
                return new Rectangle("A long rectangle", 15.0, 2.50);
            default:
                return null;
        }
    }
}
