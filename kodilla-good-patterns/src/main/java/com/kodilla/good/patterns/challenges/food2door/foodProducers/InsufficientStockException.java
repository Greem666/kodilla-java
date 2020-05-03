package com.kodilla.good.patterns.challenges.food2door.foodProducers;

public class InsufficientStockException extends Exception {
    private String productName;
    private int leftInStock;

    public InsufficientStockException(String message, String productName, int leftInStock) {
        super(message);
        this.productName = productName;
        this.leftInStock = leftInStock;
    }

    public String getProductName() {
        return productName;
    }

    public int getLeftInStock() {
        return leftInStock;
    }
}
