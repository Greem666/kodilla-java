package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements IShape {
    private Double side;

    public Square(Double side) throws NonPositiveDimensionsException {
        if (side > 0) {
            this.side = side;
        } else {
            throw new NonPositiveDimensionsException("Side cannot be negative.");
        }
    }

    public String getShapeName() {
        return "square";
    }

    public Double getField() {
        return this.side * this.side;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return side.equals(square.side);
    }

    @Override
    public int hashCode() {
        return Objects.hash(side);
    }
}
