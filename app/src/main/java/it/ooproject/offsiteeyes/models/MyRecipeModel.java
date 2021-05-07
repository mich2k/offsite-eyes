package it.ooproject.offsiteeyes.models;

import java.io.Serializable;
import java.net.URL;

public class MyRecipeModel{
    private String title;
    private String description;
    private URL imageResource;

    public MyRecipeModel(String title, String description, URL imageResource) {
        this.title = title;
        this.description = description;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public URL getImageResource() {
        return imageResource;
    }

    public void setImageResource(URL imageResource) {
        this.imageResource = imageResource;
    }
}
