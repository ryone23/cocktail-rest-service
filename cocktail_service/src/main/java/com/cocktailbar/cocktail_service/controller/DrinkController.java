package com.cocktailbar.cocktail_service.controller;

import com.cocktailbar.cocktail_service.model.Drink;
import com.cocktailbar.cocktail_service.repository.DrinkRepository;
import com.cocktailbar.cocktail_service.exception.DrinkNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
class DrinkController {


    private final DrinkRepository repository;

    DrinkController(DrinkRepository repository) {this.repository = repository; }

    @GetMapping("/drinks")
    List<Drink> getAllDrinks() {
            return repository.findAllByOrderByDrinkIdAsc();
    }
    @GetMapping("/drinks/{id}")
    Drink getOneDrink(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new DrinkNotFoundException(id));
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
