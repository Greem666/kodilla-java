package com.kodilla.good.patterns.challenges.food2door.foodProducers.products;

import com.kodilla.good.patterns.challenges.food2door.foodProducers.GoodsDto;
import com.kodilla.good.patterns.challenges.food2door.foodProducers.InsufficientStockException;
import com.kodilla.good.patterns.challenges.food2door.foodProducers.interfaces.Supplier;

import java.util.HashMap;
import java.util.Map;


public class ExtraFoodShop implements Supplier {
    private Map<String, GoodsDto> availableProducts = new HashMap<String, GoodsDto>()
    {{
        put("Noodles", new GoodsDto("Noodles", 1.99, 100));
        put("Meats", new GoodsDto("Meats", 14.99, 20));
        put("Soup", new GoodsDto("Soup", 0.99, 200));
    }};
    private String orderedGoodsName;
    private int orderedGoodsQty;

    public ExtraFoodShop(String orderedGoodsName, int orderedGoodsQty) {
        this.orderedGoodsName = orderedGoodsName;
        this.orderedGoodsQty = orderedGoodsQty;
    }

    @Override
    public void process() {
        if (availableProducts.containsKey(this.orderedGoodsName)) {
            GoodsDto queriedGoods = availableProducts.get(this.orderedGoodsName);
            try {
                queriedGoods.reduceStock(this.orderedGoodsQty);
                System.out.println("Shop " + this.getName() +
                        " has " + queriedGoods.getName() +
                        " at price " + queriedGoods.getPrice() +
                        " per piece in sufficient quantity (" + this.orderedGoodsQty +
                        ").");
                System.out.println("Order has been successful.");
            } catch (InsufficientStockException e) {
                System.out.println("Shop " + this.getName() + " has " + e.getProductName() + ", but not in sufficient quantity (in stock: " + e.getLeftInStock() + ").");
                System.out.println("Order has been unsuccessful.");
            }
        } else {
            System.out.println("Shop " + this.getName() + " does not have " + this.orderedGoodsName + ".");
            System.out.println("Order has been unsuccessful.");
        }
        Supplier.super.process();
    }

    @Override
    public String getName() {
        return "ExtraFoodShop";
    }
}
