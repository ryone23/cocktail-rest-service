package com.cocktailbar.cocktail_service.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.cocktailbar.cocktail_service.model.Ingredient;

@Component
class IngredientModelAssembler implements RepresentationModelAssembler<Ingredient,
        EntityModel<Ingredient>> {

    @Override
    public EntityModel<Ingredient> toModel(Ingredient ingredient) {
        return EntityModel.of(ingredient,
                linkTo(methodOn(IngredientController.class).getOneIngredient(ingredient.getIngredientId())).withSelfRel(),
                linkTo(methodOn(IngredientController.class).getAllIngredients()).withRel("ingredients"));
    }
}

