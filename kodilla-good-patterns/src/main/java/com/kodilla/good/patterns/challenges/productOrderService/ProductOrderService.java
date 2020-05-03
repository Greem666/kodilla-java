package com.kodilla.good.patterns.challenges.productOrderService;

import com.kodilla.good.patterns.challenges.productOrderService.productOrderServiceClasses.*;

public class ProductOrderService {
    public static void main(String[] args) {
        User user = new User("Matt");

        OrderProcessor orderProcessor = new OrderProcessor(
                new UserGreeter(user),
                new ProductPurchaseReceiver(user),
                new ProductPurchaseInformer(),
                new ProductPurchaseRepository());

        orderProcessor.process();
    }

}
