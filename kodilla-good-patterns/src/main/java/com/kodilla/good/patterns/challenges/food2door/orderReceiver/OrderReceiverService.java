package com.kodilla.good.patterns.challenges.food2door.orderReceiver;

import com.kodilla.good.patterns.challenges.food2door.foodProducers.factories.ExtraFoodShopCreator;
import com.kodilla.good.patterns.challenges.food2door.foodProducers.factories.GlutenFreeShopCreator;
import com.kodilla.good.patterns.challenges.food2door.foodProducers.factories.HealthyShopCreator;
import com.kodilla.good.patterns.challenges.food2door.foodProducers.factories.SupplierFactory;

public class OrderReceiverService {
    private String requestedSupplierName;
    private String requestedGoodsName;
    private int requestedQuantity;

    public OrderReceiverService(String requestedSupplierName, String requestedGoodsName, int requestedQuantity) {
        this.requestedSupplierName = requestedSupplierName;
        this.requestedGoodsName = requestedGoodsName;
        this.requestedQuantity = requestedQuantity;
    }

    public void processOrder() {

        SupplierFactory supplier = null;

        switch (this.requestedSupplierName) {
            case "ExtraFoodShop": default:
                supplier = new ExtraFoodShopCreator(this.requestedGoodsName, this.requestedQuantity);
                break;
            case "GlutenFreeShop":
                supplier = new GlutenFreeShopCreator(this.requestedGoodsName, this.requestedQuantity);
                break;
            case "HealthyShop":
                supplier = new HealthyShopCreator(this.requestedGoodsName, this.requestedQuantity);
                break;
        }

        supplier.processOrder();
    }
}
