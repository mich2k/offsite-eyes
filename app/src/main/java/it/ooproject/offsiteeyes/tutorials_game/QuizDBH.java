package it.ooproject.offsiteeyes.tutorials_game;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import it.ooproject.offsiteeyes.tutorials_game.QuizGamesContract;
import kotlin.collections.ArrayDeque;

public class QuizDBH extends SQLiteOpenHelper {
    private static final String DB_NAME = "Tutorials_Game.db";
    private static final int DB_VERSION = 1;
    private SQLiteDatabase db;

    public QuizDBH(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db=db;
        Log.v("DB_TUTORIALS_GAMES", "DB Games Created");
        final String SQL_CREATE_QUESTIONS_SCHEMA = "CREATE TABLE " + QuizGamesContract.QuestionsSchema.SCHEMA_NAME + " ( "
                + QuizGamesContract.QuestionsSchema._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuizGamesContract.QuestionsSchema.COLUMN_Q + " TEXT, " +
                QuizGamesContract.QuestionsSchema.COLUMN_OPT1 + " TEXT, " +
                QuizGamesContract.QuestionsSchema.COLUMN_OPT2 + " TEXT, " +
                QuizGamesContract.QuestionsSchema.COLUMN_OPT3 + " TEXT, " +
                QuizGamesContract.QuestionsSchema.COLUMN_OPT4 + " TEXT, " +
                QuizGamesContract.QuestionsSchema.COLUMN_ANSWER + " INTEGER" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_SCHEMA);
        fillQuestName();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + QuizGamesContract.QuestionsSchema.SCHEMA_NAME);
            onCreate(db);
    }

    private void fillQuestName(){
        QuizQuestion q1 = new QuizQuestion("Avanti (A) corretta", "A", "B", "C", "D",1);
        QuizQuestion q2 = new QuizQuestion("Avanti (A) corretta", "A", "B", "C", "D",3);
        QuizQuestion q3 = new QuizQuestion("Avanti (A) corretta", "A", "B", "C", "D",2);
        QuizQuestion q4 = new QuizQuestion("Avanti (A) corretta", "A", "B", "C", "D",2);
        QuizQuestion q5 = new QuizQuestion("Avanti (A) corretta", "A", "B", "C", "D",1);
        QuizQuestion q6 = new QuizQuestion("Avanti (A) corretta", "A", "B", "C", "D",2);
        QuizQuestion q7 = new QuizQuestion("Avanti (A) corretta", "A", "B", "C", "D",4);
        addQuestion(q1);
        addQuestion(q2);
        addQuestion(q3);
        addQuestion(q4);
        addQuestion(q5);
        addQuestion(q6);
        addQuestion(q7);
        // anche addQuestion( new QuizQuestion.. );

    }
    private void addQuestion(QuizQuestion question) {
        ContentValues cv = new ContentValues();
        cv.put( QuizGamesContract.QuestionsSchema.COLUMN_Q, question.getQuestion());
        cv.put( QuizGamesContract.QuestionsSchema.COLUMN_OPT1, question.getOpt1());
        cv.put( QuizGamesContract.QuestionsSchema.COLUMN_OPT2, question.getOpt2());
        cv.put( QuizGamesContract.QuestionsSchema.COLUMN_OPT3, question.getOpt3());
        cv.put( QuizGamesContract.QuestionsSchema.COLUMN_OPT4, question.getOpt4());
        cv.put( QuizGamesContract.QuestionsSchema.COLUMN_ANSWER, question.getAnswer());
        db.insert( QuizGamesContract.QuestionsSchema.SCHEMA_NAME, null, cv);
    }

    public List<QuizQuestion> getQuestionsList(){
        List<QuizQuestion> questList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor curs = db.rawQuery("SELECT * FROM " + QuizGamesContract.QuestionsSchema.SCHEMA_NAME, null);
        //scorro db
        if(curs.moveToFirst()) {
            do {
                QuizQuestion question = new QuizQuestion();
                question.setQuestion(curs.getString(curs.getColumnIndex(QuizGamesContract.QuestionsSchema.COLUMN_Q)));
                question.setOpt1(curs.getString(curs.getColumnIndex(QuizGamesContract.QuestionsSchema.COLUMN_OPT1)));
                question.setOpt2(curs.getString(curs.getColumnIndex(QuizGamesContract.QuestionsSchema.COLUMN_OPT2)));
                question.setOpt3(curs.getString(curs.getColumnIndex(QuizGamesContract.QuestionsSchema.COLUMN_OPT3)));
                question.setOpt4(curs.getString(curs.getColumnIndex(QuizGamesContract.QuestionsSchema.COLUMN_OPT4)));
                question.setAnswer(curs.getInt(curs.getColumnIndex(QuizGamesContract.QuestionsSchema.COLUMN_ANSWER)));
                questList.add(question);
            } while (curs.moveToNext());
        }
        curs.close();
        return questList;
    }
}
