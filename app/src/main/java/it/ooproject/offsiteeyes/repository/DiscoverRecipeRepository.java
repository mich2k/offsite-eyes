package it.ooproject.offsiteeyes.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import it.ooproject.offsiteeyes.api.FoodApiInterface;
import it.ooproject.offsiteeyes.api.FoodApiService;
import it.ooproject.offsiteeyes.api.response.ListRecipesResponse;
import it.ooproject.offsiteeyes.models.IngredientModel;
import it.ooproject.offsiteeyes.models.RecipeDetailModel;
import it.ooproject.offsiteeyes.models.RecipeModel;
import it.ooproject.offsiteeyes.utils.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DiscoverRecipeRepository {
    private final FoodApiInterface foodApi = FoodApiService.getApiService(FoodApiInterface.class);
    private List<RecipeModel> recipeModelList;
    private final LiveData<List<RecipeModel>> liveData = new MutableLiveData<>();

    public LiveData<List<RecipeModel>> getRecipeList(int number){
        Call<ListRecipesResponse> responseCall = foodApi.listRecipes(Util.API_KEY, number);

        responseCall.enqueue(new Callback<ListRecipesResponse>() {
            @Override
            public void onResponse(@NotNull Call<ListRecipesResponse> call,
                                   @NotNull Response<ListRecipesResponse> response) {
                if(response.code() == Util.HTTP_STATUS_OK_CODE){
                    ListRecipesResponse res = response.body();
                    if(res != null) {
                        //bind recipesModel to liveData
                    }
                }
            }

            @Override
            public void onFailure(@NotNull Call<ListRecipesResponse> call, @NotNull Throwable t) {
                t.printStackTrace();
            }
        });

        return null;
    }

    public List<IngredientModel> autoCompleteIngredients(String query, int number){
        Call<List<IngredientModel>> responseCall = foodApi.autoCompleteIngredient(
                Util.API_KEY,
                query,
                number
        );

        responseCall.enqueue(new Callback<List<IngredientModel>>() {
            @Override
            public void onResponse(Call<List<IngredientModel>> call, Response<List<IngredientModel>> response) {
                if(response.code() == Util.HTTP_STATUS_OK_CODE){
                    if(response.body() != null) {
                        for (IngredientModel i : response.body()) {
                            System.out.println(i.toString());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<IngredientModel>> call, Throwable t) {

            }
        });

        return null;
    }

    public RecipeDetailModel getRecipeById(int id){
        Call<RecipeDetailModel> responseCall = foodApi.recipeDetail(id, Util.API_KEY, false);
        responseCall.enqueue(new Callback<RecipeDetailModel>() {
            @Override
            public void onResponse(Call<RecipeDetailModel> call, Response<RecipeDetailModel> response) {

            }

            @Override
            public void onFailure(Call<RecipeDetailModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return null;



    }

    public List<RecipeModel> findRecipesByIngredients(String ingredients, int number){
        Call<List<RecipeModel>> responseCall = foodApi.findRecipeByIngredient(Util.API_KEY, ingredients, number);
        responseCall.enqueue(new Callback<List<RecipeModel>>() {
            @Override
            public void onResponse(Call<List<RecipeModel>> call, Response<List<RecipeModel>> response) {
                System.out.println(response);
            }

            @Override
            public void onFailure(Call<List<RecipeModel>> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return null;
    }
}