package it.ooproject.offsiteeyes.tutorials_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import it.ooproject.offsiteeyes.R;
import it.ooproject.offsiteeyes.activities.GamesTutorialsActivity;

public class QuizShowScore extends AppCompatActivity {
    private TextView dynamicQuizTitle;
    private TextView showScore;
    private TextView txtTestualResult;
    private Button finishQuiz;
    private Button retryQuiz;
    protected int selectedQuizPassed;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_show_score);


        finishQuiz = findViewById(R.id.finish_activity);
        retryQuiz = findViewById(R.id.retry_activity);
        dynamicQuizTitle = findViewById(R.id.games_quiz_score_title);
        showScore = findViewById(R.id.show_score);
        txtTestualResult = findViewById(R.id.textual_result_banner);

        int scoreValue = QuizGamesFirstQuiz.getScore();
        int totalQuestions =  QuizGamesFirstQuiz.getQuestionCountTot();
        float scoreRatio = -1;
        String textualResult = "";

        /*
            we can get the selected quiz by the user in two ways:
                passing int by intent: not convenient, hard-coded

                public get method

            i used both, even if is redundant code only for learning scope.
         */

        // selectedQuizPassed = getIntent().getIntExtra("SELECTED_QUIZ", -1);
        selectedQuizPassed = QuizGamesFirstQuiz.getSelectedQuizPassed();


        switch (selectedQuizPassed){
            case 1:
                dynamicQuizTitle.setText("\"Arrivo in una nuova città\"");
                break;

            case 2:
                dynamicQuizTitle.setText("\"Una nuova casa\"");
                break;

            default:
                try {
                    throw new Exception("illegal intent passed integer value");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

        }

        try {
            scoreRatio =( (float) scoreValue/totalQuestions);
            if(Float.isNaN(scoreRatio)){
                throw new ArithmeticException("infinity");
            }
        }catch (ArithmeticException e){
            e.printStackTrace();
            finish();
        }
        Toast.makeText(this, "score: " + scoreRatio, Toast.LENGTH_SHORT).show();


        if( scoreRatio == 1){
            textualResult="Perfetto!";
        }else{
            if(scoreRatio >= 0.75){
                textualResult="Quasi perfetto!";
            }else{
                if(scoreRatio >= 0.5){
                    textualResult="Sei sulla giusta strada!";
                }else{
                    if(scoreRatio >= 0.25){
                        textualResult="Puoi Migliorare!";

                    }else{
                        if(scoreRatio == 0){
                            textualResult="Peccato!";
                        }
                    }
                }
            }

        }
        txtTestualResult.setText(textualResult);


        showScore.append(" " + scoreValue + "/" + totalQuestions);

        finishQuiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                QuizShowScore.super.finish();

            }
        });


        retryQuiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                QuizGamesFirstQuiz.setScore(0);
                Intent intent = new Intent(QuizShowScore.this, QuizGamesFirstQuiz.class);
                intent.putExtra("SELECTED_QUIZ", selectedQuizPassed);
                startActivity(intent);

            }
        });



    }


}
