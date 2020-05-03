package com.kodilla.good.patterns.challenges.food2door.foodProducers.factories;

import com.kodilla.good.patterns.challenges.food2door.foodProducers.interfaces.Supplier;

public abstract class SupplierFactory {
    protected String orderedGoodsName;
    protected int orderedGoodsQty;

    public SupplierFactory(String orderedGoodsName, int orderedGoodsQty) {
        this.orderedGoodsName = orderedGoodsName;
        this.orderedGoodsQty = orderedGoodsQty;
    }

    public void processOrder() {
        System.out.println("Loading desired producer...");
        Supplier supplier = loadProducer();

        System.out.println(String.format("Supplier %s loaded. Processing the order for %d pieces of %s.",
                supplier.getName(),
                this.orderedGoodsQty,
                this.orderedGoodsName));
        supplier.process();
    }

    public abstract Supplier loadProducer();
}
