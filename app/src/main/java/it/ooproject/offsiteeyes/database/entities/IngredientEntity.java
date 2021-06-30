package it.ooproject.offsiteeyes.database.entities;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

/**
 * <p>IngredientEntity is a model class that represents a database table in the application
 * Each field represents a column field in the table. Getters and setters are used for
 * expose to the room database the methods for accessing the table columns. This class
 * also implements Parcelable interface</p>
 */
@Entity(tableName = "ingredient")
public class IngredientEntity implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ingredient_id")
    private int ingredientID;
    private String name;
    public static final Creator<IngredientEntity> CREATOR = new Creator<IngredientEntity>() {
        /**
         * <p>Create a new instance of the Parcelable class</p>
         *
         * @param in The Parcel to read the object's data from.
         * @return IngredientEntity object
         */
        @Override
        public IngredientEntity createFromParcel(Parcel in) {
            return new IngredientEntity(in);
        }

        /**
         * <p>Create a new array of the Parcelable class.</p>
         *
         * @param size Size of the array.
         * @return Returns an array of the Parcelable class, with every entry initialized to null.
         */
        @Override
        public IngredientEntity[] newArray(int size) {
            return new IngredientEntity[size];
        }
    };



    /**
     * <p>IngredientEntity is a public constructor</p>
     *
     * @param ingredientID ingredient identifier
     * @param name ingredient name
     */
    public IngredientEntity(int ingredientID, String name) {
        this.ingredientID = ingredientID;
        this.name = name;
    }

    /**
     * <p>IngredientEntity is a protected constructor</p>
     *
     * @param in parcel in
     */
    protected IngredientEntity(Parcel in) {
        ingredientID = in.readInt();
        name = in.readString();
    }



    /**
     * <p>Get ingredient identifier</p>
     *
     * @return ingredient identifier
     */
    public int getIngredientID() {
        return ingredientID;
    }

    /**
     * <p>Set a new ingredient id to the current ingredient</p>
     *
     * @param ingredientID ingredient identifier
     */
    public void setIngredientID(int ingredientID) {
        this.ingredientID = ingredientID;
    }

    /**
     * <p>Get the name of the ingredient</p>
     *
     * @return ingredient name
     */
    public String getName() {
        return name;
    }

    /**
     * <p>Set a new name for the current ingredient</p>
     *
     * @param name ingredient name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>Textual representation of the IngredientEntity object</p>
     *
     * @return string that represents the object
     */
    @NotNull
    @Override
    public String toString() {
        return "IngredientEntity{" +
                "ingredientID=" + ingredientID +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * <p>Packing IngredientEntity object into a parcel</p>
     *
     * @param dest parcel that holds the IngredientEntity object
     * @param flags additional flags about how the object should be written
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ingredientID);
        dest.writeString(name);
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
}
