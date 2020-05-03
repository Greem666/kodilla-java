package com.kodilla.good.patterns.challenges.productOrderServiceClasses;

import com.kodilla.good.patterns.challenges.interfaces.PurchaseReceiver;

import java.time.LocalDateTime;

public class ProductPurchaseReceiver implements PurchaseReceiver {
    private ProductPurchaseSelector productPurchaseSelector = new ProductPurchaseSelector();
    private AvailableGoods availableGoods = new AvailableGoods();
    private User user;

    public ProductPurchaseReceiver(User user) {
        this.user = user;
    }

    @Override
    public PurchasedProduct receive() {
        productPurchaseSelector.listAndSelect(availableGoods);
        String chosenGoodsName = productPurchaseSelector.getChosenGoodsName();

        if (chosenGoodsName != null) {
            Double goodsPrice = availableGoods.getGoodsPriceMapping().get(chosenGoodsName);
            LocalDateTime purchaseTime = LocalDateTime.now();

            return new PurchasedProduct(chosenGoodsName, goodsPrice, this.user, purchaseTime);

        } else {
            return null;
        }
    }
}
