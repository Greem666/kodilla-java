package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class BigMac {
    private final String bun;
    private final int burgersQty;
    private final String sauce;
    private final List<String> ingredients = new ArrayList<>();

    public static class BigMacBuilder {
        private String bun;
        private int burgersQty = 0;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public final int MAX_BURGERS = 4;

        public BigMacBuilder setBun(String bunType) {
            try {
                this.bun = BunFactory.makeBun(bunType);
                return this;
            } catch (IllegalStateException e) {
                System.out.println(e);
            }
            return null;
        }

        public BigMacBuilder addBurger() {
            if (burgersQty < MAX_BURGERS) {
                this.burgersQty += 1;
                return this;
            } else {
                throw new IllegalStateException("No more than 4 burgers are allowed!");
            }
        }

        public BigMacBuilder addSauce(String sauceType) {
            try {
                this.sauce = SauceFactory.makeSauce(sauceType);
                return this;
            } catch (IllegalStateException e) {
                System.out.println(e);
            }
            return null;
        }

        public BigMacBuilder addIngredient(String ingredientType) {
            try {
                this.ingredients.add(IngredientFactory.makeIngredient(ingredientType));
                return this;
            } catch (IllegalStateException e) {
                System.out.println(e);
            }
            return null;
        }

        public BigMac build() {
            if (this.bun != null && this.burgersQty > 0 && this.sauce != null && this.ingredients.size() > 0) {
                return new BigMac(this.bun, this.burgersQty, this.sauce, this.ingredients);
            } else {
                if (this.bun == null) {
                    throw new IllegalStateException("No bun, no BigMac!");
                } else if (this.burgersQty == 0) {
                    throw new IllegalStateException("Meatless BigMac does not compute!");
                } else if (this.sauce == null) {
                    throw new IllegalStateException("Add the sauce, you philistine!");
                } else if (this.ingredients.isEmpty()) {
                    throw new IllegalStateException("What about the health factor? Add extras NOW!");
                } else {
                    throw new IllegalStateException("Something went wrong, build a better BigMax next time!");
                }
            }
        }
    }

    public BigMac(String bun, int burgers, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgersQty = burgers;
        this.sauce = sauce;
        this.ingredients.addAll(ingredients);
    }

    public String getBun() {
        return bun;
    }

    public int getBurgersQty() {
        return burgersQty;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun='" + bun + '\'' +
                ", burgersQty=" + burgersQty +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
