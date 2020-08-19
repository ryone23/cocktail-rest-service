package com.cocktailbar.cocktail_service.repository;

import com.cocktailbar.cocktail_service.model.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    @Query("SELECT ingredients FROM Ingredient ingredients ORDER BY ingredients.ingredient_id")
    List<Ingredient> findAllByOrderByIngredientIdAsc();
}