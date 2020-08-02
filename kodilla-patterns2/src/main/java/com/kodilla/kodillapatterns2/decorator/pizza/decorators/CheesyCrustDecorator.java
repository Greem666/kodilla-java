package com.kodilla.kodillapatterns2.decorator.pizza.decorators;

import com.kodilla.kodillapatterns2.decorator.pizza.PizzaOrder;

import java.math.BigDecimal;

public class CheesyCrustDecorator extends AbstractPizzaOrderDecorator {
    public CheesyCrustDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(10));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", cheesy crust";
    }
}
