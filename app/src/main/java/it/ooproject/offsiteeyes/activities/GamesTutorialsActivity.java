package it.ooproject.offsiteeyes.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import it.ooproject.offsiteeyes.R;
import it.ooproject.offsiteeyes.tutorials_game.QuizGamesFirstQuiz;

public class GamesTutorialsActivity extends AppCompatActivity {
    private CardView cardViewFirstQuiz;
    private CardView cardViewSecondQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorials_games_list);

        cardViewFirstQuiz = findViewById(R.id.card_view_games_first_option);
        cardViewSecondQuiz = findViewById(R.id.card_view_games_second_option);

        cardViewFirstQuiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(GamesTutorialsActivity.this, QuizGamesFirstQuiz.class);
                startActivity(intent);
            }
        });
        // TODO
        /*cardViewSecondQuiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(GamesTutorialsActivity.this, QuizGamesSecondQuiz.class);
                startActivity(intent);
            }
        });*/
    }


}