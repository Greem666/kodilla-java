package com.kodilla.testing.shape;

public class Square implements Shape {
    private Double side;

    public Square(Double side) {
        if (side > 0) {
            this.side = side;
        } else {
            this.side = 0.0;
        }
    }

    public String getShapeName() {
        return "xxx";
    }

    public Double getField() {
        return 10.0;
    }
}
