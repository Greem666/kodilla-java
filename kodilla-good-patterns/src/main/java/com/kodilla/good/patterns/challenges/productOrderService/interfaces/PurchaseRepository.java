package com.kodilla.good.patterns.challenges.productOrderService.interfaces;

import com.kodilla.good.patterns.challenges.productOrderService.productOrderServiceClasses.PurchasedProduct;

public interface PurchaseRepository {
    boolean save(PurchasedProduct purchasedProduct);
}
