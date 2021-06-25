package it.ooproject.offsiteeyes.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import it.ooproject.offsiteeyes.models.RecipeModel;

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

    public List<RecipeModel> getRecipes() {
        return recipes;
    }

    public int getOffset() {
        return offset;
    }

    public int getNumber() {
        return number;
    }

    public int getTotalResult() {
        return totalResult;
    }

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
