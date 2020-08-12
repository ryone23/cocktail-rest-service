package com.cocktailbar.cocktail_service;

import com.cocktailbar.cocktail_service.model.Ingredient;
import com.cocktailbar.cocktail_service.repository.IngredientRepository;
import java.util.List;

import com.cocktailbar.cocktail_service.service.IIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class IngredientService implements IIngredientService {

    @Autowired
    private IngredientRepository repository;

    @Override
    public List<Ingredient> findAll() {
        var ingredients = (List<Ingredient>) repository.findAll();

        return ingredients;
    }
}