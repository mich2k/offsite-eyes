package it.ooproject.offsiteeyes.tutorials_game;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import it.ooproject.offsiteeyes.R;

public class QuizGamesFirstQuiz extends AppCompatActivity {
    private TextView textViewQuestion;
    private TextView textViewCurrentQuestionNumber;
    private Button btnOption1;
    private Button btnOption2;
    private Button btnOption3;
    private Button btnOption4;
    private ImageView imageViewBackArrow;

    private int questionCountTot;
    private int questionCountCurr;
    private int score;
    private QuizQuestion currentQuestion;

    private List<QuizQuestion> questionList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_games);
        textViewQuestion = findViewById(R.id.games_question_text_view);
        btnOption1 = findViewById(R.id.option_1);
        btnOption2 = findViewById(R.id.option_2);
        btnOption3 = findViewById(R.id.option_3);
        btnOption4 = findViewById(R.id.option_4);
        textViewCurrentQuestionNumber = findViewById(R.id.text_view_tutorials_questions_left);
        imageViewBackArrow = findViewById(R.id.image_view_backarrow_tutorials_game);

        questionCountCurr=0;
        QuizDBH dbH = new QuizDBH(this);
        questionList = dbH.getQuestionsList();
        questionCountTot = questionList.size();
        Toast.makeText(this, "size:" + questionCountTot, Toast.LENGTH_SHORT).show();

        btnOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGivenAnswer(1);
                goNextQuestion();
            }
        });
        btnOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGivenAnswer(2);
                goNextQuestion();
            }
        });
        btnOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGivenAnswer(3);
                goNextQuestion();
            }
        });
        btnOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGivenAnswer(4);
                goNextQuestion();
            }
        });
        goNextQuestion();

    }

    private void goNextQuestion(){
        if(questionCountCurr < questionCountTot){
            currentQuestion = questionList.get(questionCountCurr);
            textViewQuestion.setText(currentQuestion.getQuestion());
            btnOption1.setText(currentQuestion.getOpt1());
            btnOption2.setText(currentQuestion.getOpt2());
            btnOption3.setText(currentQuestion.getOpt3());
            btnOption4.setText(currentQuestion.getOpt4());
            questionCountCurr++;
            textViewCurrentQuestionNumber.setText("Domanda: " + questionCountCurr + "/" + questionCountTot);
        }else{
            finishQuiz();
        }
    }
    private void checkGivenAnswer(int answer_number){
        if(answer_number == currentQuestion.getAnswer()){
            score++;
            showRisult(answer_number);
        }
    }
    private void showRisult(int answer_number){
        Toast.makeText(this, "a:" + btnOption1.getTransitionName(), Toast.LENGTH_SHORT).show();

    }

    private void finishQuiz(){
        finish();
    }

}