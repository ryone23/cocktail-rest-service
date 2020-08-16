package com.cocktailbar.cocktail_service.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Embeddable
public class RecipeId implements Serializable {

    @Column(name = "drink_name")
    private String drink_name;

    @Column(name = "ingredient_name")
    private String ingredient_name;

    public RecipeId() {}

    public RecipeId(String drink_name, String ingredient_name) {
        this.drink_name = drink_name;
        this.ingredient_name = ingredient_name;
    }

    public String getDrinkName() {
        return drink_name;
    }

    public void setDrinkId(String drink_name) {
        this.drink_name = drink_name;
    }

    public String getIngredientName() {
        return ingredient_name;
    }

    public void setIngredientName(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof RecipeId)) return false;
        RecipeId recipeId = (RecipeId) o;
        return Objects.equals(this.drink_name, recipeId.drink_name) &&
                Objects.equals(this.ingredient_name, recipeId.ingredient_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.drink_name, this.ingredient_name);
    }


}