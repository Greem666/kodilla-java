package com.kodilla.good.patterns.challenges.food2door.foodProducers.interfaces;

public interface Supplier {
    default void process() {
        System.out.println("***************************\n");
    }
    String getName();
}
