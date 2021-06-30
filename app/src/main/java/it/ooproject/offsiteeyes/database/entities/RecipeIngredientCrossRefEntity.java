package it.ooproject.offsiteeyes.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * <p>RecipeIngredientCrossRefEntity is a model class that represents a database table
 * in the application.Each field represents a column field in the table.
 * Getters and setters are used for expose to the room database the methods for
 * accessing the table columns. This class also implements Parcelable interface</p>
 */
@Entity(primaryKeys = {"recipe_id", "ingredient_id"}, indices = { @Index("ingredient_id") })
public class RecipeIngredientCrossRefEntity {
    @ColumnInfo(name = "ingredient_id")
    private int ingredientID;

    @ColumnInfo(name = "recipe_id")
    private int recipeID;


    /**
     * <p>Get ingredient identifier</p>
     *
     * @return ingredient identifier
     */
    public int getIngredientID() {
        return ingredientID;
    }

    /**
     * <p>Set a new ingredient identifier to the current RecipeIngredientCrossRef obj</p>
     *
     * @param ingredientID ingredient identifier
     */
    public void setIngredientID(int ingredientID) {
        this.ingredientID = ingredientID;
    }

    /**
     * <p>Get recipe identifier</p>
     *
     * @return recipe identifier
     */
    public int getRecipeID() {
        return recipeID;
    }

    /**
     * <p>Set a new recipe id to the current RecipeIngredientCrossRef obj</p>
     *
     * @param recipeID recipe identifier
     */
    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }
}
