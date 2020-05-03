package com.kodilla.good.patterns.challenges.productOrderServiceClasses;

import com.kodilla.good.patterns.challenges.interfaces.PurchaseRepository;

public class ProductPurchaseRepository implements PurchaseRepository {
    @Override
    public boolean save(PurchasedProduct purchasedProduct) {
        boolean purchaseOccurred = purchasedProduct != null;

        if (purchaseOccurred) {
            System.out.println("Saving information about the purchase to the Database...");
        }

        return purchaseOccurred;
    }
}
