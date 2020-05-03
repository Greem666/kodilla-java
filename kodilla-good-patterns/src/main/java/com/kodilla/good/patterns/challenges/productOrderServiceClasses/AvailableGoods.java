package com.kodilla.good.patterns.challenges.productOrderServiceClasses;

import java.util.HashMap;
import java.util.Map;

public class AvailableGoods {
    private Map<String, Double> goodsPriceMapping = new HashMap<String, Double>()
    {{
        put("Bike", 299.99);
        put("Shoes", 59.45);
        put("Avengers Movie", 12.99);
        put("Game Console PlayBoxOne", 499.89);
    }};

    public Map<String, Double> getGoodsPriceMapping() {
        return goodsPriceMapping;
    }
}
