package com.kodilla.patterns.builder.pizza;

import org.junit.Assert;
import org.junit.Test;

public class PizzaTestSuite {
    @Test
    public void testPizzaNew() {
        // Given
        Pizza pizza = new Pizza.PizzaBuilder()
                .bottom("thin")
                .sauce("tomato")
                .ingredients("ham")
                .ingredients("onion")
                .ingredients("pineapple")
                .build();
        System.out.println(pizza);

        // When
        int howManyIngredients = pizza.getIngredients().size();

        // Then
        Assert.assertEquals(3, howManyIngredients);
    }
}
