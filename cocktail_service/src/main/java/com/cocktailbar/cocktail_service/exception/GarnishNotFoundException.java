package com.cocktailbar.cocktail_service.exception;

public class GarnishNotFoundException extends RuntimeException {

    public GarnishNotFoundException(Long id) {
        super("Could not find garnish " + id);
    }
}