package it.ooproject.offsiteeyes.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import it.ooproject.offsiteeyes.R;

/**
 * <p>PantryActivity is a class activity that shows the homepage of the application
 * It composed by a series of cards view aligned vertically</p>
 * */
public class PantryActivity extends AppCompatActivity {
    CardView cardViewMyRecipes;
    CardView cardViewDiscoverMeals;

    /**
     * <p>This method is called when you initialize the activity. In this method we bind
     * UI items with the activity with findViewById method and we bind and onClick
     * listener to every card view object</p>
     *
     * @param savedInstanceState contains the data that is saved with onSaveInstanceState(Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry);

        cardViewMyRecipes = findViewById(R.id.card_view_first_option);
        cardViewDiscoverMeals = findViewById(R.id.card_view_second_option);

        cardViewMyRecipes.setOnClickListener(v -> {
            startActivity(new Intent(PantryActivity.this, MyRecipeActivity.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });

        cardViewDiscoverMeals.setOnClickListener(v -> {
            startActivity(new Intent(PantryActivity.this, DiscoverRecipesActivity.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
    }
}
