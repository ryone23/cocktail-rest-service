package com.cocktailbar.cocktail_service.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.cocktailbar.cocktail_service.model.ExactRecipe;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.cocktailbar.cocktail_service.model.Recipe;


@Component
class RecipeModelAssembler implements RepresentationModelAssembler<Recipe,
        EntityModel<Recipe>> {

    @Override
    public EntityModel<Recipe> toModel(Recipe recipe) {
        return EntityModel.of(recipe,
                linkTo(methodOn(RecipeController.class).getAllRecipes()).withRel("recipes"));
    }
}

@Component
class ExactRecipeModelAssembler implements RepresentationModelAssembler<ExactRecipe,
        EntityModel<ExactRecipe>> {

    @Override
    public EntityModel<ExactRecipe> toModel(ExactRecipe exactRecipe) {
        return EntityModel.of(exactRecipe,
                linkTo(methodOn(RecipeController.class).getRecipe(exactRecipe.getDrinkName())).withSelfRel(),
                linkTo(methodOn(RecipeController.class).getAllRecipes()).withRel("recipes"));
    }

}
