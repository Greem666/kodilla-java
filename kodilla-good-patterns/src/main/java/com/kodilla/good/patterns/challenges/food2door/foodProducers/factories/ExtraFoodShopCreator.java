package com.kodilla.good.patterns.challenges.food2door.foodProducers.factories;

import com.kodilla.good.patterns.challenges.food2door.foodProducers.products.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.food2door.foodProducers.interfaces.Supplier;

public class ExtraFoodShopCreator extends SupplierFactory {

    public ExtraFoodShopCreator(String orderedGoodsName, int orderedGoodsQty) {
        super(orderedGoodsName, orderedGoodsQty);
    }

    @Override
    public Supplier loadProducer() {
        return new ExtraFoodShop(this.orderedGoodsName, this.orderedGoodsQty);
    }
}
