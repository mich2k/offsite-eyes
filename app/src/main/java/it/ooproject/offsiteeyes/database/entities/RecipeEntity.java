package it.ooproject.offsiteeyes.database.entities;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

/**
 * <p>name        : RecipeEntity</p>
 * <p>description : RecipeEntity is a model class that represents a database table in the application
 *                  Each field represents a column field in the table. Getters and setters are used for
 *                  expose to the room database the methods for accessing the table columns. This class
 *                  also implements Parcelable interface</p>
 */
@Entity(tableName = "recipe")
public class RecipeEntity implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "recipe_id")
    private int recipeID;
    private String title;
    private String method;
    private String note;
    private String image;

    public static final Creator<RecipeEntity> CREATOR = new Creator<RecipeEntity>() {
        /**
         * <p>Create a new instance of the Parcelable class</p>
         *
         * @param in The Parcel to read the object's data from.
         * @return RecipeEntity object
         */
        @Override
        public RecipeEntity createFromParcel(Parcel in) {
            return new RecipeEntity(in);
        }

        /**
         * <p>Create a new array of the Parcelable class.</p>
         *
         * @param size Size of the array.
         * @return Returns an array of the Parcelable class, with every entry initialized to null.
         */
        @Override
        public RecipeEntity[] newArray(int size) {
            return new RecipeEntity[size];
        }
    };

    /**
     * <p>RecipeEntity is a public constructor</p>
     *
     * @param recipeID recipe identifier
     * @param title recipe title
     * @param method recipe preparation
     * @param note recipe notes
     * @param image recipe image format base64
     */
    public RecipeEntity(int recipeID, String title, String method, String note, String image) {
        this.recipeID = recipeID;
        this.title = title;
        this.method = method;
        this.note = note;
        this.image = image;
    }

    /**
     * <p>RecipeEntity is a protected constructor</p>
     *
     * @param in parcel in
     */
    protected RecipeEntity(Parcel in) {
        recipeID = in.readInt();
        title = in.readString();
        method = in.readString();
        note = in.readString();
        image = in.readString();
    }

    /**
     * <p>method     : writeToParcel</p>
     * <p>description: </p>
     *
     * @param dest parcel that holds the IngredientEntity object
     * @param flags additional flags about how the object should be written
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(recipeID);
        dest.writeString(title);
        dest.writeString(method);
        dest.writeString(note);
        dest.writeString(image);
    }

    /**
     * <p>method     : describeContents</p>
     * <p>description: Describe the kinds of special objects contained in this Parcelable instance</p>
     *
     * @return a bitmask indicating the set of special object types marshaled by this Parcelable
     * object instance.
     */
    @Override
    public int describeContents() {
        return 0;
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
     * <p>Set a new recipe identifier to the current recipe</p>
     *
     * @param recipeID recipe identifier
     */
    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    /**
     * <p>Get the recipe title</p>
     *
     * @return recipe title
     */
    public String getTitle() {
        return title;
    }

    /**
     * <p>Set a new recipe title to the current recipe</p>
     *
     * @param title recipe title
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * <p>Get the recipe preparation</p>
     *
     * @return recipe preparation
     */
    public String getMethod() {
        return method;
    }

    /**
     * <p>Set a new recipe method to the current recipe</p>
     *
     * @param method recipe preparation
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * <p>Get recipe note</p>
     *
     * @return recipe note
     */
    public String getNote() {
        return note;
    }

    /**
     * <p>Set a new recipe note to the current note</p>
     *
     * @param note recipe note
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * <p>Get recipe image URL</p>
     *
     * @return recipe image
     */
    public String getImage() {
        return image;
    }

    /**
     * <p>Set a new recipe image URL to the current recipe</p>
     *
     * @param image recipe image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * <p>Textual representation of the RecipeEntity object</p>
     *
     * @return string that represents the object
     */
    @NotNull
    @Override
    public String toString() {
        return "RecipeEntity{" +
                "recipeID=" + recipeID +
                ", title='" + title + '\'' +
                ", method='" + method + '\'' +
                ", note='" + note + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
