package it.ooproject.offsiteeyes.utils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import it.ooproject.offsiteeyes.database.entities.RecipeWithIngredientEntity;

public class Util {
    public final static String BASE_URL = "https://api.spoonacular.com";
    public final static String API_KEY = "4a4ae3e5c5a8433b889bcd107c293e78";
    public final static int HTTP_STATUS_OK_CODE = 200;
    public final static int HTTP_STATUS_SERVER_ERROR_CODE = 500;
    public final static int HTTP_STATUS_NOT_FOUND_CODE = 404;
    public final static int HTTP_STATUS_NOT_AUTH_CODE = 401;

}
