package com.cocktailbar.cocktail_service.exception;

public class IngredientNotFoundException extends RuntimeException {

    public IngredientNotFoundException(Long id) {
        super("Could not find ingredient " + id);
    }
}