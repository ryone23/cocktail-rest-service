package com.cocktailbar.cocktail_service.service;

import com.cocktailbar.cocktail_service.model.Ingredient;
import java.util.List;

public interface IIngredientService {
    List<Ingredient> findAll();
}