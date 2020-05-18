package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BigMacTestSuite {
    @Test
    public void testBigMacBuild() {
        // Given
        BigMac bigmac = new BigMac.BigMacBuilder()
                .setBun(BunFactory.makeBun(BunFactory.BRIOCHE_BUN))
                .addBurger()
                .addBurger()
                .addSauce(SauceFactory.makeSauce(SauceFactory.ISLANDS_SAUCE))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.BACON_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.CHILI_PEPPER_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.GHERKIN_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.SALAD_INGREDIENT))
                .build();
        System.out.println(bigmac);

        // When
        String bunType = bigmac.getBun();
        String sauceType = bigmac.getSauce();
        int burgerQty = bigmac.getBurgersQty();
        List<String> ingredients = bigmac.getIngredients();

        // Then
        Assert.assertEquals(BunFactory.BRIOCHE_BUN, bunType);
        Assert.assertEquals(SauceFactory.ISLANDS_SAUCE, sauceType);
        Assert.assertEquals(2, burgerQty);
        Assert.assertTrue(ingredients.containsAll(
                Arrays.asList(
                    IngredientFactory.BACON_INGREDIENT,
                    IngredientFactory.CHILI_PEPPER_INGREDIENT,
                    IngredientFactory.GHERKIN_INGREDIENT,
                    IngredientFactory.SALAD_INGREDIENT
                )
            )
        );
    }

    @Test(expected = IllegalStateException.class)
    public void testBigMacBuildIllegalBunType() {
        // Given
        BigMac bigmac = new BigMac.BigMacBuilder()
                .setBun(BunFactory.makeBun("CHOCOLATE_CHALLAH"))
                .addBurger()
                .addBurger()
                .addSauce(SauceFactory.makeSauce(SauceFactory.ISLANDS_SAUCE))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.BACON_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.CHILI_PEPPER_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.GHERKIN_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.SALAD_INGREDIENT))
                .build();
        System.out.println(bigmac);

        // When
        // --

        // Then
        // --
    }

    @Test(expected = IllegalStateException.class)
    public void testBigMacBuildIllegalSauceType() {
        // Given
        BigMac bigmac = new BigMac.BigMacBuilder()
                .setBun(BunFactory.makeBun(BunFactory.BRIOCHE_BUN))
                .addBurger()
                .addBurger()
                .addSauce(SauceFactory.makeSauce("SWEET CHILLI"))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.BACON_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.CHILI_PEPPER_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.GHERKIN_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.SALAD_INGREDIENT))
                .build();
        System.out.println(bigmac);

        // When
        // --

        // Then
        // --
    }

    @Test(expected = IllegalStateException.class)
    public void testBigMacBuildIllegalBurgerQty() {
        // Given
        BigMac bigmac = new BigMac.BigMacBuilder()
                .setBun(BunFactory.makeBun(BunFactory.BRIOCHE_BUN))
                .addBurger()
                .addBurger()
                .addBurger()
                .addBurger()
                .addBurger()
                .addSauce(SauceFactory.makeSauce(SauceFactory.ISLANDS_SAUCE))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.BACON_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.CHILI_PEPPER_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.GHERKIN_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.SALAD_INGREDIENT))
                .build();
        System.out.println(bigmac);

        // When
        // --

        // Then
        // --
    }

    @Test(expected = IllegalStateException.class)
    public void testBigMacBuildIllegalIngredientType() {
        // Given
        BigMac bigmac = new BigMac.BigMacBuilder()
                .setBun(BunFactory.makeBun(BunFactory.BRIOCHE_BUN))
                .addBurger()
                .addBurger()
                .addSauce(SauceFactory.makeSauce(SauceFactory.ISLANDS_SAUCE))
                .addIngredient(IngredientFactory.makeIngredient("GARLIC BUTTER"))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.CHILI_PEPPER_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.GHERKIN_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.SALAD_INGREDIENT))
                .build();
        System.out.println(bigmac);

        // When
        // --

        // Then
        // --
    }

    @Test(expected = IllegalStateException.class)
    public void testBigMacBuildIllegalBuildSetupNoSauce() {
        // Given
        BigMac bigmac = new BigMac.BigMacBuilder()
                .setBun(BunFactory.makeBun(BunFactory.BRIOCHE_BUN))
                .addBurger()
                .addBurger()
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.BACON_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.CHILI_PEPPER_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.GHERKIN_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.SALAD_INGREDIENT))
                .build();
        System.out.println(bigmac);

        // When
        // --

        // Then
        // --
    }

    @Test(expected = IllegalStateException.class)
    public void testBigMacBuildIllegalBuildSetupNoBun() {
        // Given
        BigMac bigmac = new BigMac.BigMacBuilder()
                .addBurger()
                .addBurger()
                .addSauce(SauceFactory.makeSauce(SauceFactory.ISLANDS_SAUCE))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.BACON_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.CHILI_PEPPER_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.GHERKIN_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.SALAD_INGREDIENT))
                .build();
        System.out.println(bigmac);

        // When
        // --

        // Then
        // --
    }

    @Test(expected = IllegalStateException.class)
    public void testBigMacBuildIllegalBuildSetupNoBurgers() {
        // Given
        BigMac bigmac = new BigMac.BigMacBuilder()
                .setBun(BunFactory.makeBun(BunFactory.BRIOCHE_BUN))
                .addSauce(SauceFactory.makeSauce(SauceFactory.ISLANDS_SAUCE))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.BACON_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.CHILI_PEPPER_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.GHERKIN_INGREDIENT))
                .addIngredient(IngredientFactory.makeIngredient(IngredientFactory.SALAD_INGREDIENT))
                .build();
        System.out.println(bigmac);

        // When
        // --

        // Then
        // --
    }

    @Test(expected = IllegalStateException.class)
    public void testBigMacBuildIllegalBuildSetupNoIngredients() {
        // Given
        BigMac bigmac = new BigMac.BigMacBuilder()
                .setBun(BunFactory.makeBun(BunFactory.BRIOCHE_BUN))
                .addBurger()
                .addBurger()
                .addSauce(SauceFactory.makeSauce(SauceFactory.ISLANDS_SAUCE))
                .build();
        System.out.println(bigmac);

        // When
        // --

        // Then
        // --
    }
}
