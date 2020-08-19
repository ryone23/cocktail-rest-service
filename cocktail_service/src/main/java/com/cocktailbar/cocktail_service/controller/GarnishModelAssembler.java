package com.cocktailbar.cocktail_service.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.cocktailbar.cocktail_service.model.Garnish;

@Component
class GarnishModelAssembler implements RepresentationModelAssembler<Garnish,
        EntityModel<Garnish>> {

    @Override
    public EntityModel<Garnish> toModel(Garnish garnish) {
        return EntityModel.of(garnish,
                linkTo(methodOn(GarnishController.class).getOneGarnish(garnish.getGarnishId())).withSelfRel(),
                linkTo(methodOn(GarnishController.class).getAllGarnishes()).withRel("garnishes"));
    }
}