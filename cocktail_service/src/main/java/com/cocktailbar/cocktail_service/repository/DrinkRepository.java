package com.cocktailbar.cocktail_service.repository;

import com.cocktailbar.cocktail_service.model.Drink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface DrinkRepository extends CrudRepository<Drink, Long> {

    @Query("select drinks from Drink drinks order by drinks.drink_id asc")
    List<Drink> findAllByOrderByDrinkIdAsc();

}