package it.ooproject.offsiteeyes.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import it.ooproject.offsiteeyes.R;
import it.ooproject.offsiteeyes.models.RecipeModel;

public class MyRecipeShowRecipeData extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry_show_recipe);
        TextView selectedRecipe;
        Intent intent = getIntent();
        selectedRecipe = findViewById(R.id.text_view_myrecipes_title_item);
        if(intent.getExtras() != null){
            RecipeModel myRecipeModel =  (RecipeModel) intent.getSerializableExtra("data");
            selectedRecipe.setText(myRecipeModel.getTitle());
        }
    }

}
