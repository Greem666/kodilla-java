package com.kodilla.good.patterns.challenges.food2door.foodProducers.factories;

import com.kodilla.good.patterns.challenges.food2door.foodProducers.products.HealthyShop;
import com.kodilla.good.patterns.challenges.food2door.foodProducers.interfaces.Supplier;

public class HealthyShopCreator extends SupplierFactory {

    public HealthyShopCreator(String orderedGoodsName, int orderedGoodsQty) {
        super(orderedGoodsName, orderedGoodsQty);
    }

    @Override
    public Supplier loadProducer() {
        return new HealthyShop(this.orderedGoodsName);
    }
}
