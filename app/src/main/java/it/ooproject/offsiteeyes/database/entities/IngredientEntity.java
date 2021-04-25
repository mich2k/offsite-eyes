package it.ooproject.offsiteeyes.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ingredient")
public class IngredientEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ingredient_id")
    private int ingredientID;

    private String name;

    public int getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(int ingredientID) {
        this.ingredientID = ingredientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
