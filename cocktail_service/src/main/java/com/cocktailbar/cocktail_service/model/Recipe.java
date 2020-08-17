package com.cocktailbar.cocktail_service.model;

import org.hibernate.annotations.Immutable;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "recipes")
@Immutable
public class Recipe implements Serializable {

    @EmbeddedId
    private RecipeId id;

    @Column(name = "drink_name", insertable = false, updatable = false)
    private String drink_name;
    @Column(name = "ingredient_name", insertable = false, updatable = false)
    private String ingredient_name;
    @Column(name = "ingredient_measurement")
    private Float ingredient_measurement;
    @Column(name = "ingredient_notes")
    private String ingredient_notes;
    @Column(name = "garn_name")
    private String garn_name;
    @Column(name = "garn_notes")
    private String garn_notes;


    public RecipeId getId() {
        return id;
    }

    public void setId(RecipeId id) {
        this.id = id;
    }

    public String getDrinkName() {
        return drink_name;
    }

    public String getIngredientName() {
        return ingredient_name;
    }

    public Float getIngredientMeasurement() {
        return ingredient_measurement;
    }

    public String getIngredientNotes() {
        return ingredient_notes;
    }

    public String getGarnName() {
        return garn_name;
    }

    public String getGarnNotes() {
        return garn_notes;
    }

    public void setDrinkId(String drink_name) {
        this.drink_name = drink_name;
    }

    public void setIngredientId(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }

    public void setIngredientMeasurement(Float ingredient_measurement) {
        this.ingredient_measurement = ingredient_measurement;
    }

    public void setIngredientNotes(String ingredient_notes) {
        this.ingredient_notes = ingredient_notes;
    }

    public void setGarnName(String garn_name) {
        this.garn_name = garn_name;
    }

    public void setGarnNotes(String garn_notes) {
        this.garn_notes = garn_notes;
    }
}

