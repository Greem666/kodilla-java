package com.kodilla.good.patterns.challenges.productOrderService.productOrderServiceClasses;

import com.kodilla.good.patterns.challenges.productOrderService.interfaces.PurchaseInformer;

public class ProductPurchaseInformer implements PurchaseInformer {

    @Override
    public boolean inform(PurchasedProduct purchasedProduct) {
        if (purchasedProduct != null) {
            System.out.println(String.format("User \"%s\" has purchased %s for %.2f on %s.",
                    purchasedProduct.getBuyerName(),
                    purchasedProduct.getGoodsName(),
                    purchasedProduct.getGoodsPrice(),
                    purchasedProduct.getPurchasedOn())
            );
            return true;
        } else {
            System.out.println("Purchase was unsuccessful.");
            return false;
        }
    }
}
