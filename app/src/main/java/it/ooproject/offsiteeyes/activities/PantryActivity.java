package it.ooproject.offsiteeyes.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import it.ooproject.offsiteeyes.R;

public class PantryActivity extends AppCompatActivity {
    CardView cardViewMyRecipes;
    ImageView myMeals;  // dispensa
    ImageView discoverMeals;    // ricettario

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry);

        cardViewMyRecipes = findViewById(R.id.card_view_first_option);

        cardViewMyRecipes.setOnClickListener(v -> {
            startActivity(new Intent(PantryActivity.this, MyRecipeActivity.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
    }
}
