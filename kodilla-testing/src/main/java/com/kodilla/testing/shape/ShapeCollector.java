package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.Iterator;

public class ShapeCollector {
    private ArrayList<IShape> shapesList;

    public ShapeCollector() {
        this.shapesList = new ArrayList<>();
    }

    public boolean addFigure(IShape shape) {
        return shapesList.add(shape);
    }

    public boolean removeFigure(IShape shape) {
        return shapesList.remove(shape);
    }

    public IShape getFigure(int n) {
        IShape result = null;
        if (n < shapesList.size() && n >= 0) {
            result = shapesList.get(n);
        }
        return result;
    }

    public String showFigures() {
        String result = "";
        for (IShape shape: shapesList) {
            result += String.format("%s - %.2f, ", shape.getShapeName(), shape.getField());
        }
        result = result.substring(0, result.length()-2);
        return result;
    }
}
