package com.cocktailbar.cocktail_service.controller;

import com.cocktailbar.cocktail_service.exception.RecipeNotFoundException;
import com.cocktailbar.cocktail_service.model.Recipe;
import com.cocktailbar.cocktail_service.model.ExactRecipe;
import com.cocktailbar.cocktail_service.repository.RecipeRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
class RecipeController {

    private final RecipeRepository repository;
    private final RecipeModelAssembler assembler;
    private final ExactRecipeModelAssembler recipeAssembler;

    @PersistenceContext
    private EntityManager em;


    RecipeController(RecipeRepository repository, RecipeModelAssembler assembler, ExactRecipeModelAssembler recipeAssembler) {
        this.repository = repository;
        this.assembler = assembler;
        this.recipeAssembler = recipeAssembler;
    }

    @GetMapping("/drinks/recipes")
    CollectionModel<EntityModel<Recipe>> getAllRecipes() {
        List<EntityModel<Recipe>> recipes = repository.findAllByOrderByDrinkNameAsc().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(recipes,
                linkTo(methodOn(RecipeController.class).getAllRecipes()).withSelfRel());
    }

    @GetMapping("/drinks/recipes/{drinkName}")
    EntityModel<ExactRecipe> getRecipe(@PathVariable String drinkName) {
        String drinkTitle = drinkName.substring(0, 1).toUpperCase() + drinkName.substring(1).toLowerCase();
        String hql = "SELECT recipes FROM Recipe recipes WHERE recipes.drink_name = '" + drinkTitle + "'";
        TypedQuery<Recipe> query = em.createQuery(hql, Recipe.class);
        List<Recipe> recipe = query.getResultList();
        ExactRecipe exactRecipe = new ExactRecipe(recipe);
        return recipeAssembler.toModel(exactRecipe);
    }

    /*
    @GetMapping("/drinks/recipes/{drinkName}/raw")
    List<Recipe> getRawRecipe(@PathVariable String drinkName) {
        String drinkTitle = drinkName.substring(0, 1).toUpperCase() + drinkName.substring(1).toLowerCase();
        String hql = "SELECT recipes FROM Recipe recipes WHERE recipes.drink_name = '" + drinkTitle + "'";
        TypedQuery<Recipe> query = em.createQuery(hql, Recipe.class);
        List<Recipe> recipe = query.getResultList();
        return recipe;
    }

     */

}