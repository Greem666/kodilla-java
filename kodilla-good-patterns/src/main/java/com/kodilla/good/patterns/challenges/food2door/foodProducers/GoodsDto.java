package com.kodilla.good.patterns.challenges.food2door.foodProducers;

public class GoodsDto {
    private String name;
    private Double price;
    private int leftInStock;

    public GoodsDto(String name, Double price, int leftInStock) {
        this.name = name;
        this.price = price;
        this.leftInStock = leftInStock;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getLeftInStock() {
        return leftInStock;
    }

    public void reduceStock(int byAmount) throws InsufficientStockException {
        if (this.leftInStock >= byAmount) {
            this.leftInStock -= byAmount;
        } else {
            throw new InsufficientStockException("Insufficient goods available.", this.name, this.leftInStock);
        }

    }
}
