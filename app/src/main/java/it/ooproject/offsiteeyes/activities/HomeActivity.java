package it.ooproject.offsiteeyes.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import it.ooproject.offsiteeyes.R;

public class HomeActivity extends AppCompatActivity {
    CardView cardViewPantry;
    CardView cardViewTutorial;
    CardView cardViewTools;
    CardView cardViewAttraction;
    CardView cardViewAboutUs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        cardViewPantry = findViewById(R.id.card_view_games_first_option);
        cardViewTutorial = findViewById(R.id.card_view_games_second_option);
        cardViewTools = findViewById(R.id.card_view_home_tools);
        cardViewAttraction = findViewById(R.id.card_view_home_attraction);
        cardViewAboutUs = findViewById(R.id.card_view_home_about_us);

        cardViewPantry.setOnClickListener(v ->
                changeActivityOnClickHandler(HomeActivity.this, PantryActivity.class)
        );

        cardViewTutorial.setOnClickListener(v ->
                changeActivityOnClickHandler(HomeActivity.this, TutorialsActivity.class)
        );

        cardViewTools.setOnClickListener(v ->
                changeActivityOnClickHandler(HomeActivity.this, ToolsActivity.class)
        );


        cardViewAttraction.setOnClickListener(v ->
                changeActivityOnClickHandler(HomeActivity.this, WelcomeActivity.class)
        );

        cardViewAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // vedere se funziona anche così
            }
        });
    }

    public void changeActivityOnClickHandler(Context ctx, Class<?> cls) {
        startActivity(new Intent(ctx, cls));
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}