package com.kodilla.testing.shape;

import java.util.Objects;

public class Circle implements IShape {
    private Double radius;

    public Circle(Double radius) throws NonPositiveDimensionsException {
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new NonPositiveDimensionsException("Radius cannot be negative.");
        }
    }

    public String getShapeName() {
        return "xxx";
    }

    public Double getField() {
        return 10.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius.equals(circle.radius);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}
