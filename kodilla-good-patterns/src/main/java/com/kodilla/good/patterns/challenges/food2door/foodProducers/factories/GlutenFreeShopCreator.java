package com.kodilla.good.patterns.challenges.food2door.foodProducers.factories;

import com.kodilla.good.patterns.challenges.food2door.foodProducers.products.GlutenFreeShop;
import com.kodilla.good.patterns.challenges.food2door.foodProducers.interfaces.Supplier;

public class GlutenFreeShopCreator extends SupplierFactory {

    public GlutenFreeShopCreator(String orderedGoodsName, int orderedGoodsQty) {
        super(orderedGoodsName, orderedGoodsQty);
    }

    @Override
    public Supplier loadProducer() {
        return new GlutenFreeShop(this.orderedGoodsName, this.orderedGoodsQty);
    }
}
