package it.ooproject.offsiteeyes.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import it.ooproject.offsiteeyes.R;

public class TutorialsActivity extends AppCompatActivity {
    CardView cardViewVideos;
    CardView cardViewGames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorials);

        cardViewGames = findViewById(R.id.card_view_games_second_option);
        cardViewVideos = findViewById(R.id.card_view_tutorial_videos);

        cardViewGames.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TutorialsActivity.this, GamesTutorialsActivity.class);
                startActivity(intent);
            }
        });

        cardViewVideos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TutorialsActivity.this, TutorialsActivity.class);    // TODO
                startActivity(intent);
            }
        });
    }
}