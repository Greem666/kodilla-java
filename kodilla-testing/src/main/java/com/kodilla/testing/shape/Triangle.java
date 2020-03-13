package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements IShape {
    private Double base;
    private Double height;

    public Triangle(Double base, Double height) throws NonPositiveDimensionsException {
        if (base > 0 && height > 0) {
            this.base = base;
            this.height = height;
        } else {
            throw new NonPositiveDimensionsException("Base and Height cannot be negative.");
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
        Triangle triangle = (Triangle) o;
        return base.equals(triangle.base) &&
                height.equals(triangle.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, height);
    }
}
