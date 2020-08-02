package com.kodilla.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class ThinCrustPizzaOrder implements PizzaOrder {
    @Override
    public BigDecimal getCost() {
        return new BigDecimal(10);
    }

    @Override
    public String getDescription() {
        return "Thin crust pizza with cheese";
    }
}
