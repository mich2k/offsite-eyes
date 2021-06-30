package it.ooproject.offsiteeyes.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import it.ooproject.offsiteeyes.R;
import it.ooproject.offsiteeyes.database.entities.RecipeWithIngredientEntity;

public class MyRecipeDetailActivity extends AppCompatActivity {
    private TextView textViewRecipeTitle;
    private TextView textViewRecipeNote;
    private TextView textViewRecipeMethod;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry_show_recipe);

        Intent intent = getIntent();
        RecipeWithIngredientEntity data = intent.getParcelableExtra("recipeWithIngredient");

        textViewRecipeTitle = findViewById(R.id.show_my_recipe_activity_title);
        textViewRecipeNote =  findViewById(R.id.notes_show_my_recipe);
        textViewRecipeMethod = findViewById(R.id.show_my_recipe_show_prep);

        textViewRecipeTitle.setText(data.getRecipe().getTitle());
        textViewRecipeNote.setText(data.getRecipe().getNote());
        textViewRecipeMethod.setText(data.getRecipe().getMethod());

    }
}
