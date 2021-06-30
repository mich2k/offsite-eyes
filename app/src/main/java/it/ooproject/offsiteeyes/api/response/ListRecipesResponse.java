package it.ooproject.offsiteeyes.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import it.ooproject.offsiteeyes.models.RecipeModel;

/**
 * ListRecipesResponse
 */
public class ListRecipesResponse {
    @SerializedName("results")
    @Expose
    private List<RecipeModel> recipes;

    @SerializedName("offset")
    @Expose
    private int offset;

    @SerializedName("number")
    @Expose
    private int number;

    @SerializedName("totalResults")
    @Expose
    private int totalResult;

    /**
     * <p>Get recipes list</p>
     * @return recipes list
     */
    public List<RecipeModel> getRecipes() {
        return recipes;
    }

    /**
     * <p>Get offset</p>
     * @return offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * <p>Get number of recipes</p>
     * @return number of items
     */
    public int getNumber() {
        return number;
    }

    /**
     * <p>Get total results</p>
     * @return total results
     */
    public int getTotalResult() {
        return totalResult;
    }

    /**
     * <p>Textual representation of the ListRecipesResponse object</p>
     *
     * @return string that represents the object
     */
    @NotNull
    @Override
    public String toString() {
        return "ListRecipesResponse{" +
                "recipes=[" + recipes.toString() +
                ", offset=" + offset +
                ", number=" + number +
                ", totalResult=" + totalResult +
                '}';
    }
}
