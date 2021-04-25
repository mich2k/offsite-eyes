package it.ooproject.offsiteeyes.database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import it.ooproject.offsiteeyes.database.dao.RecipeDao;
import it.ooproject.offsiteeyes.database.entities.IngredientEntity;
import it.ooproject.offsiteeyes.database.entities.RecipeEntity;
import it.ooproject.offsiteeyes.database.entities.RecipeIngredientCrossRefEntity;

@Database(
        entities = {
                RecipeEntity.class,
                IngredientEntity.class,
                RecipeIngredientCrossRefEntity.class
        },
        version = 1,
        exportSchema = true
)
public abstract class MyRecipeDB extends RoomDatabase {
    public abstract RecipeDao recipeDao();

    private static volatile MyRecipeDB INSTANCE;
    private static final int N_THREADS = 4;
    private static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(N_THREADS);

    public static ExecutorService getDatabaseWriteExecutor() {
        return databaseWriteExecutor;
    }

    public static MyRecipeDB getDatabase(final Context context){
        Log.v("db_create", "INSTANCE");
        if(INSTANCE == null){
            synchronized (MyRecipeDB.class) {
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(), MyRecipeDB.class, "my_recipe_db")
                            .build();
                }
            }
        }

        return INSTANCE;
    }
}
