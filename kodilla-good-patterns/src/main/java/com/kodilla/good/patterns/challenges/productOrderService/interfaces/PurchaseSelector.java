package com.kodilla.good.patterns.challenges.productOrderService.interfaces;

import com.kodilla.good.patterns.challenges.productOrderService.productOrderServiceClasses.AvailableGoods;

public interface PurchaseSelector {
    void listAndSelect(AvailableGoods availableGoods);
}
