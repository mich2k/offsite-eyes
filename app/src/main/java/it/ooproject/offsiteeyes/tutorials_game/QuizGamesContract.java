package it.ooproject.offsiteeyes.tutorials_game;

import android.provider.BaseColumns;

public final class QuizGamesContract {
    private QuizGamesContract(){};
    public static class QuestionsSchema implements BaseColumns {
        public static final String SCHEMA_NAME = "quiz_questions";
        public static final String COLUMN_Q = "question";
        public static final String COLUMN_OPT1 = "option1";
        public static final String COLUMN_OPT2 = "option2";
        public static final String COLUMN_OPT3 = "option3";
        public static final String COLUMN_OPT4 = "option4";
        public static final String COLUMN_ANSWER= "answer";

    }
}
