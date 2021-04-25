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
    private RecipeDao recipeDao;
    private LiveData<List<RecipeWithIngredientEntity>> recipes;


    public MyRecipeRepository(Application application) {
        MyRecipeDB db = MyRecipeDB.getDatabase(application);
        recipeDao = db.recipeDao();
        recipes = recipeDao.getRecipesWithIngredient();
    }

    public LiveData<List<RecipeWithIngredientEntity>> getRecipes() {
        return recipes;
    }

    public void insert(RecipeEntity recipe, List<IngredientEntity> ingredients) {
        MyRecipeDB.getDatabaseWriteExecutor().execute(() ->{
            long lastRecipeId = recipeDao.insert(recipe);
            for(IngredientEntity i: ingredients){
                long x = recipeDao.insertIngredient(i);

                Log.v("omar", "last inserted id ingredient: " + x);
            }

            //long[] lastIdIngredients = recipeDao.insertIngredients(ingredients);

            /*for(long i=0; i<lastIdIngredients.length; i++){
                RecipeIngredientCrossRefEntity ref = new RecipeIngredientCrossRefEntity();
                ref.setIngredientID((int) lastIdIngredients[(int) i]);
                ref.setRecipeID((int) lastRecipeId);
                recipeDao.insertRecipeWithIngredient(ref);
            }*/

        });
    }
}
