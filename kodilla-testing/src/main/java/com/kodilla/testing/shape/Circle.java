package com.kodilla.testing.shape;

public class Circle implements Shape {
    private Double radius;

    public Circle(Double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            this.radius = 0.0;
        }
    }

    public String getShapeName() {
        return "xxx";
    }

    public Double getField() {
        return 10.0;
    }
}
