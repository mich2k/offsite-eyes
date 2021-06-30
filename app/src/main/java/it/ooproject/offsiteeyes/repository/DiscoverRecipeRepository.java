package it.ooproject.offsiteeyes.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
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
    private List<RecipeModel> recipeModelList = new ArrayList<>();
    private final MutableLiveData<List<RecipeModel>> liveData = new MutableLiveData<>();

    /**
     *
     * @param number
     * @param offset
     * @return
     */
    public MutableLiveData<List<RecipeModel>> getRecipeList(int number, int offset){
        Call<ListRecipesResponse> responseCall = foodApi.listRecipes(Util.API_KEY, number, offset);

        responseCall.enqueue(new Callback<ListRecipesResponse>() {
            @Override
            public void onResponse(@NotNull Call<ListRecipesResponse> call,
                                   @NotNull Response<ListRecipesResponse> response) {
                if(response.code() == Util.HTTP_STATUS_OK_CODE){
                    ListRecipesResponse res = response.body();
                    liveData.setValue(res.getRecipes());
                }
            }

            @Override
            public void onFailure(@NotNull Call<ListRecipesResponse> call, @NotNull Throwable t) {
                liveData.setValue(null);
            }
        });

        return liveData;
    }

    /**
     *
     * @param query
     * @param number
     * @return
     */
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

    /**
     *
     * @param id
     * @return
     */
    public RecipeDetailModel getRecipeById(int id){
        Call<RecipeDetailModel> responseCall = foodApi.recipeDetail(id, Util.API_KEY, false);
        responseCall.enqueue(new Callback<RecipeDetailModel>() {
            @Override
            public void onResponse(@NotNull Call<RecipeDetailModel> call, @NotNull Response<RecipeDetailModel> response) {

            }

            @Override
            public void onFailure(@NotNull Call<RecipeDetailModel> call, @NotNull Throwable t) {
                t.printStackTrace();
            }
        });
        return null;



    }

    /**
     *
     * @param ingredients
     * @param number
     * @return
     */
    public List<RecipeModel> findRecipesByIngredients(String ingredients, int number){
        Call<List<RecipeModel>> responseCall = foodApi.findRecipeByIngredient(Util.API_KEY, ingredients, number);
        responseCall.enqueue(new Callback<List<RecipeModel>>() {
            @Override
            public void onResponse(@NotNull Call<List<RecipeModel>> call, @NotNull Response<List<RecipeModel>> response) {
                System.out.println(response);
            }

            @Override
            public void onFailure(@NotNull Call<List<RecipeModel>> call, @NotNull Throwable t) {
                t.printStackTrace();
            }
        });

        return null;
    }
}