package com.cocktailbar.cocktail_service.repository;

import com.cocktailbar.cocktail_service.model.Garnish;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GarnishRepository extends CrudRepository<Garnish, Long> {

    @Query("select garnishes from Garnish garnishes order by garnishes.garnish_id asc")
    List<Garnish> findAllByOrderByGarnishIdAsc();
}