package it.ooproject.offsiteeyes.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import it.ooproject.offsiteeyes.R;

/**
 * name       : HomeActivity
 * description: HomeActivity is a class activity that shows the homepage of the application
 *              It composed by a series of cards view aligned vertically
 * */
public class HomeActivity extends AppCompatActivity {
    CardView cardViewPantry;
    CardView cardViewTutorial;
    CardView cardViewTools;
    CardView cardViewAttraction;
    CardView cardViewAboutUs;


    /***
     * method     : onCreate
     * description: This method is called when you initialize the activity. In this method we bind
     *              UI items with the activity with findViewById method and we bind and onClick
     *              listener to every card view object
     *
     * @param savedInstanceState contains the data that is saved with onSaveInstanceState(Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        cardViewPantry = findViewById(R.id.card_view_games_first_option);
        cardViewTutorial = findViewById(R.id.card_view_first_option);
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

        cardViewAboutUs.setOnClickListener(v ->
                changeActivityOnClickHandler(HomeActivity.this, AboutUsActivity.class)
        );
    }

    /***
     * method     : changeActivityOnClickHandler
     * description: This method handles the onclick event on card view object. When the event is
     *              fired, HomeActivity starts an intent and make a graphical transition
     *
     * @param ctx A Context of the application package implementing this class. (source)
     * @param cls The component class that is to be used for the intent. (destination)
     */
    private void changeActivityOnClickHandler(Context ctx, Class<?> cls) {
        startActivity(new Intent(ctx, cls));
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}