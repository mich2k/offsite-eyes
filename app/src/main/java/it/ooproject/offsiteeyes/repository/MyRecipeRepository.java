package it.ooproject.offsiteeyes.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import it.ooproject.offsiteeyes.database.MyRecipeDB;
import it.ooproject.offsiteeyes.database.dao.RecipeDao;
import it.ooproject.offsiteeyes.database.entities.IngredientEntity;
import it.ooproject.offsiteeyes.database.entities.RecipeEntity;
import it.ooproject.offsiteeyes.database.entities.RecipeIngredientCrossRefEntity;
import it.ooproject.offsiteeyes.database.entities.RecipeWithIngredientEntity;

public class MyRecipeRepository {
    private final RecipeDao recipeDao;
    private final LiveData<List<RecipeWithIngredientEntity>> recipes;

    /**
     *
     * @param application
     */
    public MyRecipeRepository(Application application) {
        MyRecipeDB db = MyRecipeDB.getDatabase(application);
        recipeDao = db.recipeDao();
        recipes = recipeDao.getRecipesWithIngredient();
    }

    /**
     *
     * @return
     */
    public LiveData<List<RecipeWithIngredientEntity>> getRecipes() {
        return recipes;
    }

    /**
     *
     * @param recipe
     * @param ingredients
     */
    public void insert(RecipeEntity recipe, List<IngredientEntity> ingredients) {
        MyRecipeDB.getDatabaseWriteExecutor().execute(() ->{
            long lastRecipeId = recipeDao.insert(recipe);
            for(IngredientEntity i: ingredients){
                long lastIngredientId = recipeDao.insertIngredient(i);
                recipeDao.insertRecipeIngredient(lastIngredientId, lastRecipeId);
            }
        });
    }
}
