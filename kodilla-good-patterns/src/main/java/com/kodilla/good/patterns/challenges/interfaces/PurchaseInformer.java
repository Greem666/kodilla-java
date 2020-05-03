package com.kodilla.good.patterns.challenges.interfaces;

import com.kodilla.good.patterns.challenges.productOrderServiceClasses.PurchasedProduct;

public interface PurchaseInformer {
    boolean inform(PurchasedProduct purchasedProduct);
}
