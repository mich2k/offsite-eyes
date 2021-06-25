package it.ooproject.offsiteeyes.api;

import java.util.List;

import it.ooproject.offsiteeyes.api.response.AutoIngredientResponse;
import it.ooproject.offsiteeyes.api.response.ListRecipesResponse;
import it.ooproject.offsiteeyes.api.response.RecipeDetailResponse;
import it.ooproject.offsiteeyes.models.IngredientModel;
import it.ooproject.offsiteeyes.models.RecipeDetailModel;
import it.ooproject.offsiteeyes.models.RecipeModel;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FoodApiInterface {

    @GET("/food/ingredients/autocomplete")
    Call<List<IngredientModel>> autoCompleteIngredient(
            @Query("apiKey") String apiKey,
            @Query("query") String query,
            @Query("number") int number
    );

    @GET("/recipes/complexSearch")
    Call<ListRecipesResponse> listRecipes(
            @Query("apiKey") String apiKey,
            @Query("number") int number
    );

    @GET("/recipes/{id}/information")
    Call<RecipeDetailModel> recipeDetail(
            @Path("id") int id,
            @Query("apiKey") String apiKey,
            @Query("includeNutrition") boolean includeNutrition
    );

    @GET("/recipes/findByIngredients")
    Call<List<RecipeModel>> findRecipeByIngredient(
            @Query("apiKey") String apiKey,
            @Query("ingredients") String ingredients,
            @Query("number") int number
    );
}

