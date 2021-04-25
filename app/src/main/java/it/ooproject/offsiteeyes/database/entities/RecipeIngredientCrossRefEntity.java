package it.ooproject.offsiteeyes.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        primaryKeys = {"recipe_id", "ingredient_id"},
        indices = { @Index("ingredient_id") }
        )
public class RecipeIngredientCrossRefEntity {
    @ColumnInfo(name = "ingredient_id")
    private int ingredientID;

    @ColumnInfo(name = "recipe_id")
    private int recipeID;


    public int getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(int ingredientID) {
        this.ingredientID = ingredientID;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }
}
