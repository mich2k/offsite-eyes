package it.ooproject.offsiteeyes.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import it.ooproject.offsiteeyes.R;

public class HomeActivity extends AppCompatActivity {
    CardView cardViewPantry;
    CardView cardViewTutorial;
    CardView cardViewTools;
    CardView cardViewAttraction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        cardViewPantry = findViewById(R.id.card_view_home_pantry);
        cardViewTutorial = findViewById(R.id.card_view_pantry_myrecipes);
        cardViewTools = findViewById(R.id.card_view_home_tools);
        cardViewAttraction = findViewById(R.id.card_view_home_attraction);

        cardViewPantry.setOnClickListener(v ->
                changeActivityOnClickHandler(HomeActivity.this, PantryActivity.class)
        );

        cardViewTutorial.setOnClickListener(v ->
                changeActivityOnClickHandler(HomeActivity.this, TutorialsActivity.class)
        );

        cardViewTools.setOnClickListener(v ->
                changeActivityOnClickHandler(HomeActivity.this, ToolsActivity.class)
        );

        cardViewTools.setOnClickListener(v ->
                changeActivityOnClickHandler(HomeActivity.this, HomeActivity.class)
        );

        cardViewAttraction.setOnClickListener(v ->
                changeActivityOnClickHandler(HomeActivity.this, HomeActivity.class)
        );
    }

    public void changeActivityOnClickHandler(Context ctx, Class<?> cls) {
        startActivity(new Intent(ctx, cls));
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}