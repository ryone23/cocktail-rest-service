package com.cocktailbar.cocktail_service.controller;

import com.cocktailbar.cocktail_service.exception.GarnishNotFoundException;
import com.cocktailbar.cocktail_service.model.Garnish;
import com.cocktailbar.cocktail_service.repository.GarnishRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
class GarnishController {


    private final GarnishRepository repository;
    private final GarnishModelAssembler assembler;

    GarnishController(GarnishRepository repository, GarnishModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/garnishes")
    CollectionModel<EntityModel<Garnish>> getAllGarnishes() {
        List<EntityModel<Garnish>> garnishes = repository.findAllByOrderByGarnishIdAsc().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(garnishes,
                linkTo(methodOn(GarnishController.class).getAllGarnishes()).withSelfRel());
    }
    
    @GetMapping("/garnishes/{id}")
    EntityModel<Garnish> getOneGarnish(@PathVariable Long id) {
        Garnish garnish = repository.findById(id)
                .orElseThrow(() -> new GarnishNotFoundException(id));
        return assembler.toModel(garnish);
    }

    @PostMapping("/garnishes")
    Garnish newGarnish(@RequestBody Garnish newGarnish) {
        return repository.save(newGarnish);
    }

    @PutMapping("/garnishes/{id}")
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