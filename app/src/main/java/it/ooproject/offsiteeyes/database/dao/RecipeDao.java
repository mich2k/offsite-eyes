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
import it.ooproject.offsiteeyes.database.entities.RecipeWithIngredientEntity;


/**
 * <p>RecipeDao is an interface that describes what we can do with the database
 * entities. Operations like insert, update, delete or raw queries. RecipeDAO
 * provides APIs for accessing the MyRecipeDB. All methods are annotated with
 * annotation like @Query, @Insert, @Delete, ecc...</p>
 */
@Dao
public interface RecipeDao {
    /**
     * <p>This method inserts a new RecipeEntity object in the database. Room generates an
     * implementation that inserts all parameters into the database in a single transaction.
     * OnConflictStrategy.IGNORE strategy constant to ignore the conflict.</p>
     *
     * @param recipe the recipe to be added to the RecipeEntity in the database
     * @return the last inserted id row in the Recipe Entity
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(RecipeEntity recipe);

    /**
     * <p>This method inserts a new IngredientEntity object in the database. Room generates an
     * implementation that inserts all parameters into the database in a single transaction.
     * OnConflictStrategy.IGNORE strategy constant to ignore the conflict.</p>
     *
     * @param ingredient the ingredient to be added to the IngredientEntity in the database
     * @return the last inserted id row in the Ingredient Entity
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertIngredient(IngredientEntity ingredient);

    /**
     * <p>This method select all recipes data in the database.</p>
     *
     * @return liveData object containing the list of recipes-ingredients
     */
    @Transaction
    @Query("SELECT * FROM recipe")
    LiveData<List<RecipeWithIngredientEntity>> getRecipesWithIngredient();

    /**
     * <p>This method inserts a new RecipeIngredientCrossRefEntity object in the database.
     * Room generates an implementation that inserts all parameters into the database
     * in a single transaction.</p>
     *
     * @param ingredientID ingredient id to be inserted
     * @param recipeID recipe id to be inserted
     */
    @Query("INSERT INTO RecipeIngredientCrossRefEntity VALUES(:ingredientID, :recipeID)")
    void insertRecipeIngredient(long ingredientID, long recipeID);

    /**
     * <p>This method select a new RecipeIngredientCrossRefEntity object in the database.</p>
     *
     * @param id recipe id
     * @return RecipeEntity object that corresponds to the id selected
     */
    @Query("SELECT * FROM recipe WHERE recipe_id = :id")
    RecipeEntity getRecipesById(int id);
}
