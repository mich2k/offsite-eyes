package it.ooproject.offsiteeyes;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.os.Looper;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import it.ooproject.offsiteeyes.activities.HomeActivity;
import it.ooproject.offsiteeyes.database.entities.IngredientEntity;

/**
 * <p>BootLogoActivity is a class activity that shows a nice loading of application data
 * (splashscreen activity)</p>
 *
 * */
public class BootLogoActivity extends AppCompatActivity {

    /**
     * <p>this method is called when you initialize the activity. In this method we initialize
     * window settings and bind xml resource layout with the activity. After the activity consumes
     * the animation, it change the context to the HomeActivity</p>
     *
     * @param savedInstanceState contains the data that is saved with onSaveInstanceState(Bundle)
     */
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