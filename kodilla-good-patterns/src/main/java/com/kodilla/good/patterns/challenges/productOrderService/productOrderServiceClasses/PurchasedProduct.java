package com.kodilla.good.patterns.challenges.productOrderService.productOrderServiceClasses;

import java.time.LocalDateTime;

public class PurchasedProduct {

    private String goodsName;
    private double goodsPrice;
    private User buyer;
    private LocalDateTime purchasedOn;

    public PurchasedProduct(String goodsName, double goodsPrice, User buyer, LocalDateTime purchasedOn) {
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.buyer = buyer;
        this.purchasedOn = purchasedOn;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public String getBuyerName() {
        return buyer.getName();
    }

    public LocalDateTime getPurchasedOn() {
        return purchasedOn;
    }
}
