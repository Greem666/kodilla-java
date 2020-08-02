package com.kodilla.kodillapatterns2.decorator.pizza;

import java.math.BigDecimal;

public class DeepPanPizzaOrder implements PizzaOrder {
    @Override
    public BigDecimal getCost() {
        return new BigDecimal(15);
    }

    @Override
    public String getDescription() {
        return "Deep pan pizza with cheese";
    }
}
