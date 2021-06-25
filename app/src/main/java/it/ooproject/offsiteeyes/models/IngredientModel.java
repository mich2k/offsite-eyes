package it.ooproject.offsiteeyes.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IngredientModel {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("image")
    @Expose
    private String image;


    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "IngredientModel{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
