package it.ooproject.offsiteeyes.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import it.ooproject.offsiteeyes.models.IngredientModel;

public class AutoIngredientResponse {
    @SerializedName("")
    @Expose
    private List<IngredientModel> ingredients;
    public List<IngredientModel> getIngredients() {
        return ingredients;
    }
}
