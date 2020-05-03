package com.kodilla.good.patterns.challenges.productOrderService.interfaces;

import com.kodilla.good.patterns.challenges.productOrderService.productOrderServiceClasses.PurchasedProduct;

public interface PurchaseInformer {
    boolean inform(PurchasedProduct purchasedProduct);
}
