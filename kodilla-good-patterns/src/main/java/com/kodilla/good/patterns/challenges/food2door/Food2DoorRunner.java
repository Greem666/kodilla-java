package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.food2door.orderReceiver.OrderReceiverService;

public class Food2DoorRunner {

    public static void main(String[] args) {
        OrderReceiverService extraFoodShopGoodOrder = new OrderReceiverService("ExtraFoodShop", "Noodles", 50);
        extraFoodShopGoodOrder.processOrder();

        OrderReceiverService extraFoodShopBadOrder = new OrderReceiverService("ExtraFoodShop", "Noodles", 5000);
        extraFoodShopBadOrder.processOrder();

        OrderReceiverService extraFoodShopWorstOrder = new OrderReceiverService("ExtraFoodShop", "Meatballs", 50);
        extraFoodShopWorstOrder.processOrder();

        OrderReceiverService glutenFreeShopChanceOrder = new OrderReceiverService("GlutenFreeShop", "Gluten Free Noodles", 50);
        glutenFreeShopChanceOrder.processOrder();

        OrderReceiverService healthyShopOrder = new OrderReceiverService("HealthyShop", "Healthy Noodles", 50);
        healthyShopOrder.processOrder();
    }
}
