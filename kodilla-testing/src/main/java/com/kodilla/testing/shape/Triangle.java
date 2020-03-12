package com.kodilla.testing.shape;

public class Triangle implements Shape{
    private Double base;
    private Double height;

    public Triangle(Double base, Double height) {
        if (base > 0 && height > 0) {
            this.base = base;
            this.height = height;
        } else {
            this.base = 0.0;
            this.height = 0.0;
        }
    }

    public String getShapeName() {
        return "xxx";
    }

    public Double getField() {
        return 10.0;
    }


}
