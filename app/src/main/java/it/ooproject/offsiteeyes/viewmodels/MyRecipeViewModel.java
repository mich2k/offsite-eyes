package it.ooproject.offsiteeyes.viewmodels;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import it.ooproject.offsiteeyes.database.entities.IngredientEntity;
import it.ooproject.offsiteeyes.database.entities.RecipeEntity;
import it.ooproject.offsiteeyes.database.entities.RecipeWithIngredientEntity;
import it.ooproject.offsiteeyes.repository.MyRecipeRepository;

public class MyRecipeViewModel extends AndroidViewModel {
    private final MyRecipeRepository recipeRepository;
    private final LiveData<List<RecipeWithIngredientEntity>> recipes;

    public MyRecipeViewModel(Application application) {
        super(application);
        recipeRepository = new MyRecipeRepository(application);
        recipes = recipeRepository.getRecipes();
    }

    public LiveData<List<RecipeWithIngredientEntity>> getRecipes() {
        return recipes;
    }

    public void insert(RecipeEntity recipe, List<IngredientEntity> ingredients){
        recipeRepository.insert(recipe, ingredients);
    }
}
