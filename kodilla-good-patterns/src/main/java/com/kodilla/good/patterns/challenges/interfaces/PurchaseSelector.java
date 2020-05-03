package com.kodilla.good.patterns.challenges.interfaces;

import com.kodilla.good.patterns.challenges.productOrderServiceClasses.AvailableGoods;

public interface PurchaseSelector {
    void listAndSelect(AvailableGoods availableGoods);
}
