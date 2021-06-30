package it.ooproject.offsiteeyes.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

/**
 * <p>RecipeModel is a model class used for adapt api response to ...</p>
 */
public class RecipeModel {
    @SerializedName("id")
    @Expose
    private final int id;

    @SerializedName("title")
    @Expose
    private final String title;

    @SerializedName("image")
    @Expose
    private final String image;

    /**
     * <p>public constructor of a recipe model </p>
     *
     * @param id recipe identifier
     * @param title recipe title
     * @param image recipe image URL
     */
    public RecipeModel(int id, String title, String image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }

    /**
     * <p>Get the identifier of the recipe</p>
     *
     * @return recipe id
     */
    public int getId() {
        return id;
    }

    /**
     * <p>Get the title of the recipe</p>
     *
     * @return recipe title
     */
    public String getTitle() {
        return title;
    }

    /**
     * <p>Get the image URL of the recipe</p>
     *
     * @return recipe URL image
     */
    public String getImage() {
        return image;
    }

    /**
     * <p>Textual representation of the IngredientEntity object</p>
     *
     * @return string that represents the object
     */
    @NotNull
    @Override
    public String toString() {
        return "RecipeModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
