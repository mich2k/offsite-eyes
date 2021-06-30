package it.ooproject.offsiteeyes.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import it.ooproject.offsiteeyes.models.RecipeModel;
import it.ooproject.offsiteeyes.repository.DiscoverRecipeRepository;

public class DiscoverRecipeViewModel extends ViewModel {
    private final DiscoverRecipeRepository discoverRecipeRepository;

    public DiscoverRecipeViewModel() {
        discoverRecipeRepository = new DiscoverRecipeRepository();
    }

    public MutableLiveData<List<RecipeModel>> getRecipes(int number, int offset) {
        return discoverRecipeRepository.getRecipeList(number, offset);
    }
}
