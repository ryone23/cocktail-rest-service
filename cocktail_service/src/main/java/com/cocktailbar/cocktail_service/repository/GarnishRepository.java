package com.cocktailbar.cocktail_service.repository;

import com.cocktailbar.cocktail_service.model.Garnish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarnishRepository extends CrudRepository<Garnish, Long> {

}