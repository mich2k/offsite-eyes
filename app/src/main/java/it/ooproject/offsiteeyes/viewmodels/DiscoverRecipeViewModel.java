package it.ooproject.offsiteeyes.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import it.ooproject.offsiteeyes.api.response.ListRecipesResponse;
import it.ooproject.offsiteeyes.models.RecipeModel;
import it.ooproject.offsiteeyes.repository.DiscoverRecipeRepository;

public class DiscoverRecipeViewModel extends ViewModel {
    private DiscoverRecipeRepository discoverRecipeRepository;
    private final LiveData<List<RecipeModel>> recipes;

    public DiscoverRecipeViewModel() {
        recipes = discoverRecipeRepository.getRecipeList(10);
    }
}
