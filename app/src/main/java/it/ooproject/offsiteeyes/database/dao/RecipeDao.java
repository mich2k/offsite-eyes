package it.ooproject.offsiteeyes.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;


import java.util.List;

import it.ooproject.offsiteeyes.database.entities.IngredientEntity;
import it.ooproject.offsiteeyes.database.entities.RecipeEntity;
import it.ooproject.offsiteeyes.database.entities.RecipeIngredientCrossRefEntity;
import it.ooproject.offsiteeyes.database.entities.RecipeWithIngredientEntity;

@Dao
public interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(RecipeEntity recipe);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertIngredient(IngredientEntity i);

    @Transaction
    @Query("SELECT * FROM recipe")
    LiveData<List<RecipeWithIngredientEntity>> getRecipesWithIngredient();

    @Query("SELECT * FROM recipe WHERE recipe_id = :id")
    RecipeEntity getRecipesById(int id);

    @Query("DELETE FROM recipe")
    void delete();
}
