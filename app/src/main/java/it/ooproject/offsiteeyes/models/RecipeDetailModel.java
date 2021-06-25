package it.ooproject.offsiteeyes.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecipeDetailModel extends RecipeModel{
    @SerializedName("servings")
    @Expose
    private int servings;

    @SerializedName("sourceUrl")
    @Expose
    private String sourceUrl;


    @SerializedName("summary")
    @Expose
    private String summary;


    @SerializedName("readyInMinutes")
    @Expose
    private int readyInMinutes;
}
