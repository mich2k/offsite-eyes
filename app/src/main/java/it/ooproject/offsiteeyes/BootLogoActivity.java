package it.ooproject.offsiteeyes;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.os.Looper;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import it.ooproject.offsiteeyes.activities.HomeActivity;

public class BootLogoActivity extends AppCompatActivity {

    //private ImageView BootLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(ContextCompat.getColor(BootLogoActivity.this, R.color.prova));
        setContentView(R.layout.activity_bootlogo);
        AnimationUtils.loadAnimation(this, R.anim.boot_animation);


        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent afterLogo = new Intent(BootLogoActivity.this, HomeActivity.class);
            startActivity(afterLogo);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            finish();
        },2500);

    }
}