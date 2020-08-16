package com.cocktailbar.cocktail_service.repository;

import com.cocktailbar.cocktail_service.model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    @Query("SELECT recipes FROM Recipe recipes ORDER BY recipes.drink_name")
    List<Recipe> findAllByOrderByDrinkNameAsc();


}
