package com.cocktailbar.cocktail_service.controller;

import com.cocktailbar.cocktail_service.model.Drink;
import com.cocktailbar.cocktail_service.repository.DrinkRepository;
import com.cocktailbar.cocktail_service.exception.DrinkNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
class DrinkController {


    private final DrinkRepository repository;
    private final DrinkModelAssembler assembler;

    DrinkController(DrinkRepository repository, DrinkModelAssembler assembler) {this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/drinks")
    CollectionModel<EntityModel<Drink>> getAllDrinks() {
        List<EntityModel<Drink>> drinks = repository.findAllByOrderByDrinkIdAsc().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(drinks,
                linkTo(methodOn(DrinkController.class).getAllDrinks()).withSelfRel());
    }


    @GetMapping("/drinks/{id}")
    EntityModel<Drink> getOneDrink(@PathVariable Long id) {

        Drink drink = repository.findById(id)
                .orElseThrow(() -> new DrinkNotFoundException(id));
        return assembler.toModel(drink);
    }

    @PostMapping("/drinks")
    Drink newDrink(@RequestBody Drink newDrink) { return repository.save(newDrink); }

    @PutMapping("/drinks/{id}")
    Optional<Drink> replaceDrink(@RequestBody Drink newDrink, @PathVariable Long id) {

        return repository.findById(id)
                .map(drink -> {
                    drink.setDrinkName(newDrink.getDrinkName());
                    drink.setDrinkDesc(newDrink.getDrinkDesc());
                    drink.setDrinkGlass(newDrink.getDrinkGlass());
                    drink.setDrinkMixMethod(newDrink.getDrinkMixMethod());
                    drink.setDrinkStrain(newDrink.isDrinkStrain());
                    drink.setDrinkIceInGlass(newDrink.isDrinkIceInGlass());
                    drink.setDrinkIsIBA(newDrink.isDrinkIsIBA());
                    return repository.save(drink);
                });
    }

    @DeleteMapping("/drinks/{id}")
    void deleteDrink(@PathVariable Long id) { repository.deleteById(id); }

}
