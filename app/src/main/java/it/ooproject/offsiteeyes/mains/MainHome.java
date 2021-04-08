package it.ooproject.offsiteeyes.mains;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import it.ooproject.offsiteeyes.R;

public class MainHome extends AppCompatActivity {

    // dec vars, the values will be assigned inside the onCreate method, here are not defined yet
    ImageView bannerHome;
    ImageView showTools;
    ImageView showTutorials;
    ImageView showMeals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        showMeals = findViewById(R.id.image_bsx);
        showTools = findViewById(R.id.image_tsx);
        showTutorials = findViewById(R.id.image_tdx);
        //showCalcs.setClickable(true);
        //showTutorials.setClickable(true);

        showTools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainHome.this, MainTools.class));
                Toast.makeText(MainHome.this,getResources().getString(R.string.calcs_toast_presentation_text),Toast.LENGTH_SHORT).show();
            }
        });

        showTutorials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainHome.this, MainTutorials.class));
                Toast.makeText(MainHome.this,getResources().getString(R.string.tutorials_toast_presentation_text),Toast.LENGTH_SHORT).show();
            }
        });

        showMeals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainHome.this, MainMeals.class));
                Toast.makeText(MainHome.this,getResources().getString(R.string.tutorials_toast_presentation_text),Toast.LENGTH_SHORT).show();
            }
        });    }
}