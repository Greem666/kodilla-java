package com.kodilla.good.patterns.challenges.food2door.foodProducers.products;

import com.kodilla.good.patterns.challenges.food2door.foodProducers.interfaces.Supplier;

import java.util.Random;

public class GlutenFreeShop implements Supplier {

    private String orderedGoodsName;
    private int orderedGoodsQty;
    private Random random = new Random();

    public GlutenFreeShop(String orderedGoodsName, int orderedGoodsQty) {
        this.orderedGoodsName = orderedGoodsName;
        this.orderedGoodsQty = orderedGoodsQty;
    }

    @Override
    public void process() {
        boolean likesTheBuyer = this.random.nextInt(100) >= 50;

        if (likesTheBuyer) {
            System.out.println("Shop " + this.getName() + "'s owner likes you, and has " + this.orderedGoodsName + " in sufficient quantity.");
            System.out.println("Order has been successful.");
        } else {
            System.out.println("Shop " + this.getName() + "'s owner does NOT likes you, and does not have " + this.orderedGoodsName + ".");
            System.out.println("Order has been unsuccessful.");
        }

        Supplier.super.process();
    }

    @Override
    public String getName() {
        return "GlutenFreeShop";
    }
}
