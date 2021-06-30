package it.ooproject.offsiteeyes.tutorials_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import it.ooproject.offsiteeyes.R;

public class QuizMain extends AppCompatActivity {
    private static int selectedQuizPassed;
    private static int score;
    private static int questionCountTot;

    private TextView textViewQuestion;
    private TextView textViewCurrentQuestionNumber;
    private Button btnOption1;
    private Button btnOption2;
    private Button btnOption3;
    private Button btnOption4;
    private Button btnExit;
    private ImageView imageViewBackArrow;
    private TextView dynamicTitle;

    private int questionCountCurr;

    public static int getQuestionCountTot() {
        return questionCountTot;
    }


    public static int getSelectedQuizPassed() {
        return selectedQuizPassed;
    }

    public static void setScore(int score) {
        QuizMain.score = score;
    }

    public static int getScore() {
        return score;
    }


    private QuizQuestion currentQuestion;

    private List<QuizQuestion> questionList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_games);

        selectedQuizPassed = getIntent().getIntExtra("SELECTED_QUIZ", -1);


        btnExit = findViewById(R.id.finish_quiz_activity);
        textViewQuestion = findViewById(R.id.games_question_text_view);
        btnOption1 = findViewById(R.id.option_1);
        btnOption2 = findViewById(R.id.option_2);
        btnOption3 = findViewById(R.id.finish_activity);
        btnOption4 = findViewById(R.id.option_4);
        textViewCurrentQuestionNumber = findViewById(R.id.show_score);
        imageViewBackArrow = findViewById(R.id.image_view_backarrow_tutorials_game);
        dynamicTitle = findViewById(R.id.games_quiz_dynamic_title);

        questionCountCurr=0;
        QuizDBH dbH = new QuizDBH(this);
        questionList = dbH.getQuestionsList();
        questionCountTot = questionList.size();

        //Toast.makeText(this, "size:" + selectedQuizPassed, Toast.LENGTH_SHORT).show();



        switch (selectedQuizPassed){
                case 1:
                dynamicTitle.setText("Arrivo in una nuova città");
                break;

                case 2:
                dynamicTitle.setText("Una nuova casa");
                break;

            default:
                try {
                   throw new Exception("illegal intent passed integer value");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

        }

        score = 0;

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

        imageViewBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        goNextQuestion();

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = 0;
                finish();
            }
        });

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
            showResult(answer_number);
        }
    }
    private void showResult(int answer_number){
        //Toast.makeText(this, "a:" + btnOption1.getTransitionName(), Toast.LENGTH_SHORT).show();

    }

    private void finishQuiz(){
        Intent intent = new Intent(QuizMain.this, QuizShowScore.class);
        intent.putExtra("SELECTED_QUIZ", selectedQuizPassed);
        startActivity(intent);

    }

}