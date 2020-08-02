package com.kodilla.kodillapatterns2.decorator.pizza;

import com.kodilla.kodillapatterns2.decorator.pizza.decorators.CheesyCrustDecorator;
import com.kodilla.kodillapatterns2.decorator.pizza.decorators.ExtraCheeseToppingDecorator;
import com.kodilla.kodillapatterns2.decorator.pizza.decorators.OlivesToppingDecorator;
import com.kodilla.kodillapatterns2.decorator.pizza.decorators.SalamiToppingDecorator;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {
    @Test
    public void testBasicPizzaOrderGetCost() {
        // Given
        ThinCrustPizzaOrder order = new ThinCrustPizzaOrder();

        // When
        BigDecimal cost = order.getCost();

        // Then
        assertEquals(new BigDecimal(10), cost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        // Given
        ThinCrustPizzaOrder order = new ThinCrustPizzaOrder();

        // When
        String description = order.getDescription();

        // Then
        assertEquals("Thin crust pizza with cheese", description);
    }

    @Test
    public void testPizzaWithSalamiOrderGetCost() {
        // Given
        PizzaOrder order = new ThinCrustPizzaOrder();
        order = new SalamiToppingDecorator(order);

        // When
        BigDecimal cost = order.getCost();

        // Then
        assertEquals(new BigDecimal(15), cost);
    }

    @Test
    public void testPizzaWithSalamiOrderGetDescription() {
        // Given
        PizzaOrder order = new ThinCrustPizzaOrder();
        order = new SalamiToppingDecorator(order);

        // When
        String description = order.getDescription();

        // Then
        assertEquals("Thin crust pizza with cheese, salami", description);
    }

    @Test
    public void testPizzaWithSalamiAndExtraCheeseOrderGetCost() {
        // Given
        PizzaOrder order = new ThinCrustPizzaOrder();
        order = new SalamiToppingDecorator(order);
        order = new ExtraCheeseToppingDecorator(order);

        // When
        BigDecimal cost = order.getCost();

        // Then
        assertEquals(new BigDecimal(25), cost);
    }

    @Test
    public void testPizzaWithSalamiAndExtraCheeseOrderGetDescription() {
        // Given
        PizzaOrder order = new ThinCrustPizzaOrder();
        order = new SalamiToppingDecorator(order);
        order = new ExtraCheeseToppingDecorator(order);

        // When
        String description = order.getDescription();

        // Then
        assertEquals("Thin crust pizza with cheese, salami, extra cheese", description);
    }

    @Test
    public void testPizzaWithSalamiAndExtraCheeseAndOlivesOrderGetCost() {
        // Given
        PizzaOrder order = new ThinCrustPizzaOrder();
        order = new SalamiToppingDecorator(order);
        order = new ExtraCheeseToppingDecorator(order);
        order = new OlivesToppingDecorator(order);

        // When
        BigDecimal cost = order.getCost();

        // Then
        assertEquals(new BigDecimal(27), cost);
    }

    @Test
    public void testPizzaWithSalamiAndExtraCheeseAndOlivesOrderGetDescription() {
        // Given
        PizzaOrder order = new ThinCrustPizzaOrder();
        order = new SalamiToppingDecorator(order);
        order = new ExtraCheeseToppingDecorator(order);
        order = new OlivesToppingDecorator(order);

        // When
        String description = order.getDescription();

        // Then
        assertEquals("Thin crust pizza with cheese, salami, extra cheese, olives", description);
    }

    @Test
    public void testDeepPanPizzaWithSalamiAndExtraCheeseAndOlivesOrderGetCost() {
        // Given
        PizzaOrder order = new DeepPanPizzaOrder();
        order = new SalamiToppingDecorator(order);
        order = new ExtraCheeseToppingDecorator(order);
        order = new OlivesToppingDecorator(order);

        // When
        BigDecimal cost = order.getCost();

        // Then
        assertEquals(new BigDecimal(32), cost);
    }

    @Test
    public void testDeepPanPizzaPanWithSalamiAndExtraCheeseAndOlivesOrderGetDescription() {
        // Given
        PizzaOrder order = new DeepPanPizzaOrder();
        order = new SalamiToppingDecorator(order);
        order = new ExtraCheeseToppingDecorator(order);
        order = new OlivesToppingDecorator(order);

        // When
        String description = order.getDescription();

        // Then
        assertEquals("Deep pan pizza with cheese, salami, extra cheese, olives", description);
    }

    @Test
    public void testDeepPanPizzaWithSalamiAndExtraCheeseAndCheesyCrustOrderGetCost() {
        // Given
        PizzaOrder order = new DeepPanPizzaOrder();
        order = new SalamiToppingDecorator(order);
        order = new ExtraCheeseToppingDecorator(order);
        order = new CheesyCrustDecorator(order);

        // When
        BigDecimal cost = order.getCost();

        // Then
        assertEquals(new BigDecimal(40), cost);
    }

    @Test
    public void testDeepPanPizzaWithSalamiAndExtraCheeseAndCheesyCrustOrderGetDescription() {
        // Given
        PizzaOrder order = new DeepPanPizzaOrder();
        order = new SalamiToppingDecorator(order);
        order = new ExtraCheeseToppingDecorator(order);
        order = new CheesyCrustDecorator(order);

        // When
        String description = order.getDescription();

        // Then
        assertEquals("Deep pan pizza with cheese, salami, extra cheese, cheesy crust", description);
    }
}
