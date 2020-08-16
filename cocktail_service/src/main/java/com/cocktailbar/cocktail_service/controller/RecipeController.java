package com.cocktailbar.cocktail_service.controller;

import antlr.StringUtils;
import com.cocktailbar.cocktail_service.model.Recipe;
import com.cocktailbar.cocktail_service.repository.RecipeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

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
    List<Recipe> getRecipe(@PathVariable String drinkName) {
        String drinkTitle = drinkName.substring(0, 1).toUpperCase() + drinkName.substring(1).toLowerCase();
        String hql = "SELECT recipes FROM Recipe recipes WHERE recipes.drink_name = '" + drinkTitle + "'";
        TypedQuery<Recipe> query = em.createQuery(hql, Recipe.class);
        List<Recipe> recipe = query.getResultList();
        return recipe;
    }

}