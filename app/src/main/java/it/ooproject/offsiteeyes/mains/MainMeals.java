package it.ooproject.offsiteeyes.mains;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import it.ooproject.offsiteeyes.R;
import it.ooproject.offsiteeyes.services.ServiceMyRecipes;

public class MainMeals extends AppCompatActivity {

    ImageView myMeals;  // dispensa
    ImageView discoverMeals;    // ricettario

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_meals);
        myMeals = findViewById(R.id.image_tsx);


        myMeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMeals.this, ServiceMyRecipes.class));
            }
        });
    }
}
