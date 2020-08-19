package com.cocktailbar.cocktail_service.exception;

public class RecipeNotFoundException extends RuntimeException {

    public RecipeNotFoundException(String drinkName) {
        super("Could not find recipe for drink " + drinkName);
    }
}