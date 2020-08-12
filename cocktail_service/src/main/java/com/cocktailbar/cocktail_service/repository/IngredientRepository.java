package com.cocktailbar.cocktail_service.repository;

import com.cocktailbar.cocktail_service.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}