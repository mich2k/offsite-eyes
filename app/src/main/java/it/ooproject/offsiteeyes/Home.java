package it.ooproject.offsiteeyes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    // dec vars, the values will be assigned inside the onCreate method, here is not defined yet
    private ImageView bannerHome;
    private ImageView showCalcs;
    private ImageView showTutorials;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        showCalcs = findViewById(R.id.image_tsx);
        showTutorials = findViewById(R.id.image_tdx);
        //showCalcs.setClickable(true);
        showTutorials.setClickable(true);

        showCalcs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ciao = new Intent(Home.this, MainCalcoli.class);
                startActivity(ciao);
            }
        });
        //getSupportActionBar().hide();
    }
}