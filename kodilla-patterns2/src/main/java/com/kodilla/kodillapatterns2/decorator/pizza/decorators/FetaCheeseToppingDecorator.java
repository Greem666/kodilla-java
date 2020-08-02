package com.kodilla.kodillapatterns2.decorator.pizza.decorators;

import com.kodilla.kodillapatterns2.decorator.pizza.PizzaOrder;

import java.math.BigDecimal;

public class FetaCheeseToppingDecorator extends AbstractPizzaOrderDecorator {
    public FetaCheeseToppingDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(7));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", feta cheese";
    }
}
