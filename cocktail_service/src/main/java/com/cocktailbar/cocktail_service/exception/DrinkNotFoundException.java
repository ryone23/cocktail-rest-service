package com.cocktailbar.cocktail_service.exception;

public class DrinkNotFoundException extends RuntimeException {

    public DrinkNotFoundException(Long id) {
        super("Could not find drink " + id);
    }
}