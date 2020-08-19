package com.cocktailbar.cocktail_service.controller;

import com.cocktailbar.cocktail_service.exception.GarnishNotFoundException;
import com.cocktailbar.cocktail_service.model.Garnish;
import com.cocktailbar.cocktail_service.model.Ingredient;
import com.cocktailbar.cocktail_service.repository.IngredientRepository;
import com.cocktailbar.cocktail_service.exception.IngredientNotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
class IngredientController {

    private final IngredientRepository repository;
    private final IngredientModelAssembler assembler;

    IngredientController(IngredientRepository repository, IngredientModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/ingredients")
    CollectionModel<EntityModel<Ingredient>> getAllIngredients() {
        List<EntityModel<Ingredient>>  ingredients = repository.findAllByOrderByIngredientIdAsc().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(ingredients,
                linkTo(methodOn(IngredientController.class).getAllIngredients()).withSelfRel());
    }

    @GetMapping("/ingredients/{id}")
    EntityModel<Ingredient> getOneIngredient(@PathVariable Long id) {
        Ingredient ingredient = repository.findById(id)
                .orElseThrow(() -> new IngredientNotFoundException(id));
        return assembler.toModel(ingredient);
    }

    @PostMapping("/ingredients")
    Ingredient newIngredient(@RequestBody Ingredient newIngredient) {
        return repository.save(newIngredient);
    }

    @PutMapping("/ingredients/{id}")
    Optional<Ingredient> replaceIngredient(@RequestBody Ingredient newIngredient,
                                 @PathVariable Long id) {

        return repository.findById(id)
                .map(ingredient -> {
                    ingredient.setIngredientName(newIngredient.getIngredientName());
                    ingredient.setIngredientCategory(newIngredient.getIngredientCategory());
                    return repository.save(ingredient);
                });
    }

    @DeleteMapping("/ingredients/{id}")
    void deleteIngredient(@PathVariable Long id) {
        repository.deleteById(id);
    }
}