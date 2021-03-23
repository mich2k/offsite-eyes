package it.ooproject.offsiteeyes;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.content.Intent;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BootLogo extends AppCompatActivity {

    //private ImageView BootLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // BootLogo = findViewById(R.id.offsite_logo);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bootlogo);
        AnimationUtils.loadAnimation(this, R.anim.boot_animation);

        // uso gli intent per avviare un activity

        new Handler().postDelayed(new Runnable() {      // chiamo un handler e do un timer a postDelayed
            @Override
            public void run() {
                Intent afterLogo = new Intent(BootLogo.this, Home.class);
                Toast.makeText(BootLogo.this, "Benvenuto!", Toast.LENGTH_SHORT).show();
                startActivity(afterLogo);
                finish();
            }
        },2500);
    }
}