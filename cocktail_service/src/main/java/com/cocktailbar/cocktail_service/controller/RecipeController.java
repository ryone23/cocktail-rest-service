package com.cocktailbar.cocktail_service.controller;

import com.cocktailbar.cocktail_service.model.Recipe;
import com.cocktailbar.cocktail_service.model.ExactRecipe;
import com.cocktailbar.cocktail_service.repository.RecipeRepository;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.List;
import java.io.File;

@RestController
class RecipeController {
    private final RecipeRepository repository;

    @PersistenceContext
    private EntityManager em;


    RecipeController(RecipeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/drinks/recipes")
    List<Recipe> getAllRecipes() {
        return repository.findAllByOrderByDrinkNameAsc();
    }

    @GetMapping("/drinks/recipes/{drinkName}")
    ExactRecipe getRecipe(@PathVariable String drinkName) {
        String drinkTitle = drinkName.substring(0, 1).toUpperCase() + drinkName.substring(1).toLowerCase();
        String hql = "SELECT recipes FROM Recipe recipes WHERE recipes.drink_name = '" + drinkTitle + "'";
        TypedQuery<Recipe> query = em.createQuery(hql, Recipe.class);
        List<Recipe> recipe = query.getResultList();
        ExactRecipe exactRecipe = new ExactRecipe(recipe);
        //exactRecipe.displayRecipe();
        return exactRecipe;

    }

    @GetMapping("/drinks/recipes/{drinkName}/raw")
    List<Recipe> getRawRecipe(@PathVariable String drinkName) {
        String drinkTitle = drinkName.substring(0, 1).toUpperCase() + drinkName.substring(1).toLowerCase();
        String hql = "SELECT recipes FROM Recipe recipes WHERE recipes.drink_name = '" + drinkTitle + "'";
        TypedQuery<Recipe> query = em.createQuery(hql, Recipe.class);
        List<Recipe> recipe = query.getResultList();
        return recipe;
    }

}