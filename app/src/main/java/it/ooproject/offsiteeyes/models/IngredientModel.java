package it.ooproject.offsiteeyes.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * <p>IngredientModel is a model class used for adapt api response to ...</p>
 */
public class IngredientModel {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("image")
    @Expose
    private String image;

    /**
     * <p>Get the name of the ingredient</p>
     *
     * @return name of the ingredient
     */
    public String getName() {
        return name;
    }

    /**
     * Set a new name to the current ingredient
     * @param name name of the ingredient
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>Get the URL of the image</p>
     *
     * @return URl of the image
     */
    public String getImage() {
        return image;
    }

    /**
     * <p>Set a new URL of the image to the current ingredient</p>
     *
     * @param image URL of the image
     */
    public void setImage(String image) {
        this.image = image;
    }
}
