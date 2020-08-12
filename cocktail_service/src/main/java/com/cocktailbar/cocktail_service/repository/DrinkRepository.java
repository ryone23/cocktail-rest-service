package com.cocktailbar.cocktail_service.repository;

import com.cocktailbar.cocktail_service.model.Drink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends CrudRepository<Drink, Long> {

}