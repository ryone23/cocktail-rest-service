package com.cocktailbar.cocktail_service.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExactRecipe {

    private String drinkName;
    private List<String> ingredients;
    private List<Float> measurements;
    private List<String> ingredientNotes;
    private List<String> garnishes;
    private List<String> garnishNotes;

    public ExactRecipe()  {}

    ExactRecipe(String drinkName, List<String> ingredients, List<Float> measurements, List<String> ingredientNotes,
                List<String> garnishes, List<String> garnishNotes) {
        this.drinkName = drinkName;
        this.ingredients = ingredients;
        this.measurements = measurements;
        this.ingredientNotes=ingredientNotes;
        this.garnishes = garnishes;
        this.garnishNotes = garnishNotes;

    }

    public ExactRecipe(List<Recipe> recipeList) {
        ingredients = new ArrayList<>();
        measurements = new ArrayList<>();
        ingredientNotes = new ArrayList<>();
        garnishes = new ArrayList<>();
        garnishNotes = new ArrayList<>();

        drinkName = recipeList.get(0).getDrinkName();

        for (Recipe recipe : recipeList) {

            ingredients.add(recipe.getIngredientName());

            if (recipe.getIngredientMeasurement() == null) {

                measurements.add(null);
            } else {
                measurements.add(recipe.getIngredientMeasurement());
            }

            if (recipe.getIngredientNotes() == null) {
                ingredientNotes.add(null);
            } else {
                ingredientNotes.add(recipe.getIngredientNotes());
            }

        }

        if(recipeList.get(0).getGarnName() == null) {
            garnishes.add("");
        } else {
            String garnishList = recipeList.get(0).getGarnName();
            String[] singleGarnishes = garnishList.split(",");
            Collections.addAll(garnishes, singleGarnishes);
        }

        if(recipeList.get(0).getGarnNotes() == null) {
            garnishNotes.add(null);
        } else {
            String garnishNoteList = recipeList.get(0).getGarnNotes();
            String[] singleGarnisheNotes = garnishNoteList.split(",");
            Collections.addAll(garnishNotes, singleGarnisheNotes);
        }
    }

    public void displayRecipe() {

        System.out.println("Drink: " + drinkName);
        System.out.println("Ingredients: ");
        for (int i = 0; i < ingredients.size(); i++) {
            String ingredientInfo = ingredients.get(i) +
                    "     ";
            if(measurements.get(i) != null) ingredientInfo += measurements.get(i) + " oz.";
            if(ingredientNotes.get(i) != null) {
                ingredientInfo += " (" + ingredientNotes.get(i)
                        + ")";
            }

            System.out.println(ingredientInfo);

        }

        if(!garnishes.get(0).equals("")) {
            System.out.println("Garnishes: ");
            for (int i = 0; i < garnishes.size(); i++) {
                String garnishInfo = garnishes.get(i);
                if(garnishNotes.get(i) != null) {
                    garnishInfo += " (" + ingredientNotes.get(i)
                            + ")";
                }

                System.out.println(garnishInfo);
            }
        }

        System.out.println();
    }

    public String getDrinkName() {
        return drinkName;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<Float> getMeasurements() {
        return measurements;
    }

    public List<String> getIngredientNotes() {
        return ingredientNotes;
    }

    public List<String> getGarnishes() {
        return garnishes;
    }

    public List<String> getGarnishNotes() {
        return garnishNotes;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setMeasurements(List<Float> measurements) {
        this.measurements = measurements;
    }

    public void setIngredientNotes(List<String> ingredientNotes) {
        this.ingredientNotes = ingredientNotes;
    }

    public void setGarnishes(List<String> garnishes) {
        this.garnishes = garnishes;
    }

    public void setGarnishNotes(List<String> garnishNotes) {
        this.garnishNotes = garnishNotes;
    }

}
