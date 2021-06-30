package it.ooproject.offsiteeyes.api;

import java.util.List;
import it.ooproject.offsiteeyes.api.response.ListRecipesResponse;
import it.ooproject.offsiteeyes.models.IngredientModel;
import it.ooproject.offsiteeyes.models.RecipeDetailModel;
import it.ooproject.offsiteeyes.models.RecipeModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * FoodApiInterface is an API interface which has methods that perform HTTP requests.
 */
public interface FoodApiInterface {

    /**
     * <p>GET /food/ingredients/autocomplete</p>
     * <p>Autocomplete a partial input to suggest possible recipe names.</p>
     * @param apiKey auth key for calling requests.
     * @param query The query to be completed.
     * @param number The number of results to return (between 1 and 25).
     * @return Call<T> object that represents the response of the web server
     * and the T represents the type of the body response (mapping)
     */
    @GET("/food/ingredients/autocomplete")
    Call<List<IngredientModel>> autoCompleteIngredient(
            @Query("apiKey") String apiKey,
            @Query("query") String query,
            @Query("number") int number
    );

    /**
     * <p>GET /recipes/complexSearch</p>
     * <p>Search through hundreds of thousands of recipes using advanced filtering and ranking</p>
     * @param apiKey auth key for calling requests.
     * @param number The number of expected results (between 1 and 100).
     * @return Call<T> object that represents the response of the web server
     * and the T represents the type of the body response (mapping)
     */
    @GET("/recipes/complexSearch")
    Call<ListRecipesResponse> listRecipes(
            @Query("apiKey") String apiKey,
            @Query("number") int number,
            @Query("offset") int offset
    );

    /**
     *
     * @param id The id of the recipe.
     * @param apiKey auth key for calling requests
     * @param includeNutrition Include nutrition data in the recipe information.
     * @return Call<T> object that represents the response of the web server
     * and the T represents the type of the body response (mapping)
     */
    @GET("/recipes/{id}/information")
    Call<RecipeDetailModel> recipeDetail(
            @Path("id") int id,
            @Query("apiKey") String apiKey,
            @Query("includeNutrition") boolean includeNutrition
    );

    /**
     * <p>GET /recipes/findByIngredients</p>
     * @param apiKey auth key for calling requests
     * @param ingredients A comma-separated list of ingredients that the recipes should contain.
     * @param number The maximum number of recipes to return (between 1 and 100). Defaults to 10.
     * @return Call<T> object that represents the response of the web server
     * and the T represents the type of the body response (mapping)
     */
    @GET("/recipes/findByIngredients")
    Call<List<RecipeModel>> findRecipeByIngredient(
            @Query("apiKey") String apiKey,
            @Query("ingredients") String ingredients,
            @Query("number") int number
    );
}

