package com.cocktailbar.cocktail_service.controller;

import com.cocktailbar.cocktail_service.model.Ingredient;
import com.cocktailbar.cocktail_service.repository.IngredientRepository;
import com.cocktailbar.cocktail_service.exception.IngredientNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
class IngredientController {

    private final IngredientRepository repository;

    IngredientController(IngredientRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/ingredients")
    List<Ingredient> getAllIngredients() {
        return (List<Ingredient>) repository.findAll();
    }

    @GetMapping("/ingredients/{id}")
    Ingredient getOneIngredient(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new IngredientNotFoundException(id));
    }

    @PostMapping("/ingredients")
    Ingredient newIngredient(@RequestBody Ingredient newIngredient) {
        return repository.save(newIngredient);
    }

    @PutMapping("/ingredients/{id)")
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