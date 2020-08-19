package com.cocktailbar.cocktail_service.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.cocktailbar.cocktail_service.model.Drink;

@Component
class DrinkModelAssembler implements RepresentationModelAssembler<Drink,
        EntityModel<Drink>> {

    @Override
    public EntityModel<Drink> toModel(Drink drink) {
        return EntityModel.of(drink,
                linkTo(methodOn(DrinkController.class).getOneDrink(drink.getDrinkId())).withSelfRel(),
                linkTo(methodOn(DrinkController.class).getAllDrinks()).withRel("drinks"));
    }
}
