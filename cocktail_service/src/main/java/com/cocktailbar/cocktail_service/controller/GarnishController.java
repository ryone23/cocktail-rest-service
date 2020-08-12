package com.cocktailbar.cocktail_service.controller;

import com.cocktailbar.cocktail_service.model.Garnish;
import com.cocktailbar.cocktail_service.repository.GarnishRepository;
import com.cocktailbar.cocktail_service.exception.GarnishNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
class GarnishController {

    private final GarnishRepository repository;

    GarnishController(GarnishRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/garnishes")
    List<Garnish> getAllGarnishes() {
        return (List<Garnish>) repository.findAll();
    }

    @GetMapping("/garnishes/{id}")
    Garnish getOneGarnish(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new GarnishNotFoundException(id));
    }

    @PostMapping("/garnishes")
    Garnish newGarnish(@RequestBody Garnish newGarnish) {
        return repository.save(newGarnish);
    }

    @PutMapping("/garnishes/{id)")
    Optional<Garnish> replaceGarnish(@RequestBody Garnish newGarnish,
                                           @PathVariable Long id) {

        return repository.findById(id)
                .map(garnish -> {
                    garnish.setGarnishName(newGarnish.getGarnishName());
                    garnish.setGarnishCategory(newGarnish.getGarnishCategory());
                    return repository.save(garnish);
                });
    }

    @DeleteMapping("/garnishes/{id}")
    void deleteGarnish(@PathVariable Long id) {
        repository.deleteById(id);
    }
}