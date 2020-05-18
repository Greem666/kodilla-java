package com.kodilla.patterns.builder.bigmac;

public class IngredientFactory {
    public static final String SALAD_INGREDIENT = "SALAD";
    public static final String ONION_INGREDIENT = "ONION";
    public static final String BACON_INGREDIENT = "BACON";
    public static final String GHERKIN_INGREDIENT = "GHERKIN";
    public static final String CHILI_PEPPER_INGREDIENT = "CHILI PEPPER";
    public static final String CUP_MUSHROOMS_INGREDIENT = "CUP MUSHROOMS";
    public static final String PRAWNS_INGREDIENT = "PRAWNS";
    public static final String CHEESE_INGREDIENT = "CHEESE";

    public static String makeIngredient(String ingredientType) {
        switch (ingredientType) {
            case SALAD_INGREDIENT:
                return SALAD_INGREDIENT;
            case ONION_INGREDIENT:
                return ONION_INGREDIENT;
            case BACON_INGREDIENT:
                return BACON_INGREDIENT;
            case GHERKIN_INGREDIENT:
                return GHERKIN_INGREDIENT;
            case CHILI_PEPPER_INGREDIENT:
                return CHILI_PEPPER_INGREDIENT;
            case CUP_MUSHROOMS_INGREDIENT:
                return CUP_MUSHROOMS_INGREDIENT;
            case PRAWNS_INGREDIENT:
                return PRAWNS_INGREDIENT;
            case CHEESE_INGREDIENT:
                return CHEESE_INGREDIENT;
            default:
                throw new IllegalStateException("Unsupported ingredient: <<" + ingredientType + ">>!");
        }
    }
}
