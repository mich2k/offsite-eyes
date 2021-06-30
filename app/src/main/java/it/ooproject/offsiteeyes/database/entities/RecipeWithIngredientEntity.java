package it.ooproject.offsiteeyes.database.entities;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;
import org.jetbrains.annotations.NotNull;
import java.util.List;

/**
 * <p>RecipeWithIngredientEntity is a model class that represents a database table</p>
 */
public class RecipeWithIngredientEntity implements Parcelable {
    @Embedded
    private RecipeEntity recipe;

    @Relation(
            parentColumn = "recipe_id",
            entityColumn = "ingredient_id",
            associateBy = @Junction(RecipeIngredientCrossRefEntity.class)
    )
    private List<IngredientEntity> ingredients;

    public static final Creator<RecipeWithIngredientEntity> CREATOR = new Creator<RecipeWithIngredientEntity>() {
        /**
         * <p>Create a new instance of the Parcelable class</p>
         *
         * @param in The Parcel to read the object's data from.
         * @return RecipeWithIngredientEntity object
         */
        @Override
        public RecipeWithIngredientEntity createFromParcel(Parcel in) {
            return new RecipeWithIngredientEntity(in);
        }

        /**
         * <p>Create a new array of the Parcelable class.</p>
         *
         * @param size Size of the array.
         * @return Returns an array of the Parcelable class, with every entry initialized to null.
         */
        @Override
        public RecipeWithIngredientEntity[] newArray(int size) {
            return new RecipeWithIngredientEntity[size];
        }
    };

    /**
     * <p>Public RecipeWithIngredientEntity constructor with parameters</p>
     *
     * @param recipe recipeEntity object containing recipe information
     * @param ingredients list of ingredientEntity objects containing ingredients information
     */
    public RecipeWithIngredientEntity(RecipeEntity recipe, List<IngredientEntity> ingredients) {
        this.recipe = recipe;
        this.ingredients = ingredients;
    }


    /**
     * <p>Protected RecipeWithIngredientEntity constructor with parcel</p>
     *
     * @param in parcel packet
     */
    protected RecipeWithIngredientEntity(Parcel in) {
        recipe = in.readParcelable(RecipeEntity.class.getClassLoader());
        ingredients = in.createTypedArrayList(IngredientEntity.CREATOR);
    }

    /**
     * <p>Write a parcel object with packing the class attributes</p>
     *
     * @param dest parcel that holds the RecipeWithIngredientEntity object
     * @param flags additional flags about how the object should be written
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(recipe, flags);
        dest.writeTypedList(ingredients);
    }

    /**
     * <p>Describe the kinds of special objects contained in this Parcelable instance</p>
     *
     * @return a bitmask indicating the set of special object types marshaled by this Parcelable
     * object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }



    /**
     * <p>Get recipe information object</p>
     *
     * @return recipeEntity object containing recipe information
     */
    public RecipeEntity getRecipe() {
        return recipe;
    }

    /**
     * <p>Set a new recipe information object to the current object</p>
     *
     * @param recipe recipeEntity object containing recipe information
     */
    public void setRecipe(RecipeEntity recipe) {
        this.recipe = recipe;
    }

    /**
     * <p>Get the list of the ingredientEntity objects</p>
     *
     * @return list of the ingredient objects
     */
    public List<IngredientEntity> getIngredients() {
        return ingredients;
    }

    /**
     * <p>Set a new list of the ingredientEntity objects to the current object</p>
     *
     * @param ingredients list of the ingredient objects
     */
    public void setIngredients(List<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * <p>Textual representation of the RecipeWithIngredientEntity object</p>
     *
     * @return string that represents the object
     */
    @NotNull
    @Override
    public String toString() {
        return "RecipeWithIngredientEntity{" +
                "recipe=" + recipe +
                ", ingredients=" + ingredients +
                '}';
    }
}
