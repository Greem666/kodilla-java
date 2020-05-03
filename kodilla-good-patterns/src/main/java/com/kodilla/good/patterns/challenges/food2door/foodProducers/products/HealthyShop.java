package com.kodilla.good.patterns.challenges.food2door.foodProducers.products;

import com.kodilla.good.patterns.challenges.food2door.foodProducers.interfaces.Supplier;

import java.util.Scanner;

public class HealthyShop implements Supplier {

    private String orderedGoodsName;
    private Scanner scanner = new Scanner(System.in);

    public HealthyShop(String orderedGoodsName) {
        this.orderedGoodsName = orderedGoodsName;
    }

    @Override
    public void process() {
        System.out.println("Do you like eating healthy?(y/n) ");

        if (scanner.hasNextLine()) {
            if (scanner.nextLine().toLowerCase().equals("y")) {
                System.out.println("Shop " + this.getName() + " has " + this.orderedGoodsName + " in sufficient quantity.");
                System.out.println("Order has been successful.");
            } else {
                System.out.println("Shop " + this.getName() + " does not have " + this.orderedGoodsName + ".");
                System.out.println("Order has been unsuccessful.");
            }
        } else {
            System.out.println("Shop " + this.getName() + " does not have " + this.orderedGoodsName + ".");
            System.out.println("Order has been unsuccessful.");
        }

        Supplier.super.process();
    }

    @Override
    public String getName() {
        return "HealthyShop";
    }
}
