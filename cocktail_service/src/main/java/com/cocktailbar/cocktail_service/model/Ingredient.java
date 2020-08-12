package com.cocktailbar.cocktail_service.model;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ingredient_id;

    private String ingredient_name;
    private String ingredient_category;

    Ingredient() {}

    Ingredient(String ingredient_name,String ingredient_category) {
        this.ingredient_name = ingredient_name;
        this.ingredient_category = ingredient_category;
    }

    public Long getIngredientId() {
        return this.ingredient_id;
    }

    public String getIngredientName() {
        return this.ingredient_name;
    }

    public String getIngredientCategory() {
        return this.ingredient_category;
    }

    public void setIngredientId(Long ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public void setIngredientName(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }

    public void setIngredientCategory(String ingredient_category) {
        this.ingredient_category = ingredient_category;
    }

    @Override
    public boolean equals(Object o) {

        if(this == o)
            return true;
        if (!(o instanceof Ingredient))
            return false;
        Ingredient ingredient = (Ingredient) o;
        return Objects.equals(this.ingredient_id, ingredient.ingredient_id) &&
                Objects.equals(this.ingredient_name, ingredient.ingredient_name) &&
                Objects.equals(this.ingredient_category, ingredient.ingredient_category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.ingredient_id, this.ingredient_name, this.ingredient_category);
    }

    @Override
    public String toString() {
        return "Ingredient{" + "id=" + this.ingredient_id + ", name='"
                + this.ingredient_name + '\'' + ", category='" +
                this.ingredient_category + '\'' + '}';
    }
}