package it.ooproject.offsiteeyes.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Hashtable;

import it.ooproject.offsiteeyes.R;
import it.ooproject.offsiteeyes.tutorials_game.QuizMain;

public class GamesTutorialsActivity extends AppCompatActivity {
    private CardView cardViewFirstQuiz;
    private CardView cardViewSecondQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorials_games_list);

        cardViewFirstQuiz = findViewById(R.id.card_view_games_first_option);
        cardViewSecondQuiz = findViewById(R.id.card_view_first_option);


        Hashtable<Integer, Integer> quizMapValue = new Hashtable<Integer, Integer>();

        quizMapValue.put(cardViewFirstQuiz.getId(), 1);
        quizMapValue.put(cardViewSecondQuiz.getId(), 2);


        cardViewFirstQuiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(GamesTutorialsActivity.this, QuizMain.class);
                try{
                    intent.putExtra("SELECTED_QUIZ", quizMapValue.get(cardViewFirstQuiz.getId()));
                }catch(NullPointerException e ){
                    e.printStackTrace();
                    Log.e("HASH_MAP", "ID not valid");
                    Toast.makeText(GamesTutorialsActivity.this, "fatal error (hashtable)", Toast.LENGTH_SHORT).show();
                    finish();
                }
                startActivity(intent);
            }
        });

        cardViewSecondQuiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(GamesTutorialsActivity.this, QuizMain.class);
                try{
                    intent.putExtra("SELECTED_QUIZ", quizMapValue.get(cardViewSecondQuiz.getId()));
                }catch(NullPointerException e ){
                    e.printStackTrace();
                    Log.e("HASH_MAP", "ID not valid");
                    Toast.makeText(GamesTutorialsActivity.this, "fatal error (hashtable)", Toast.LENGTH_SHORT).show();
                    finish();
                }
                startActivity(intent);
            }
        });
    }


}