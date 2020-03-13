package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
    private ArrayList<IShape> shapesList;

    public ShapeCollector() {
        this.shapesList = new ArrayList<>();
    }

    public boolean addFigure(IShape shape) {
        // Add figure shape to shapesList
        return false;
    }

    public boolean removeFigure(IShape shape) {
        // Remove figure shape from shapesList
        return false;
    }

    public IShape getFigure(int n) {
        // return figure from position n in shapesList
        return null;
    }

    public void showFigures() {
        // Iterate through shapesList and print them to console
    }
}
