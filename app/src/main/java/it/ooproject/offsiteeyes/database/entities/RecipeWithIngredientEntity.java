package it.ooproject.offsiteeyes.database.entities;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class RecipeWithIngredientEntity {
    @Embedded private RecipeEntity recipe;

    @Relation(
            parentColumn = "recipe_id",
            entityColumn = "ingredient_id",
            associateBy = @Junction(RecipeIngredientCrossRefEntity.class)
    )
    private List<IngredientEntity> ingredients;

    public RecipeWithIngredientEntity(RecipeEntity recipe, List<IngredientEntity> ingredients) {
        this.recipe = recipe;
        this.ingredients = ingredients;
    }



    public RecipeEntity getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeEntity recipe) {
        this.recipe = recipe;
    }

    public List<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }
}
