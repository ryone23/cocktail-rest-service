package com.cocktailbar.cocktail_service.exception;

public class RecipeNotFoundException extends RuntimeException {

    public RecipeNotFoundException(Long id) {
        super("Could not find recipe for drink" + id);
    }
}