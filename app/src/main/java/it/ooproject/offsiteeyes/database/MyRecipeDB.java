package it.ooproject.offsiteeyes.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import it.ooproject.offsiteeyes.database.dao.RecipeDao;
import it.ooproject.offsiteeyes.database.entities.IngredientEntity;
import it.ooproject.offsiteeyes.database.entities.RecipeEntity;
import it.ooproject.offsiteeyes.database.entities.RecipeIngredientCrossRefEntity;
import it.ooproject.offsiteeyes.utils.Util;


/**
 * MyRecipeDB must be an abstract class (singleton pattern) and must extend RoomDatabase,
 * which contains the database holder and serves as the main access point
 * for underlying connection to your app's persisted.
 * We've created an ExecutorService with a fixed thread pool that you will use to run
 * database operations asynchronously on a background thread.
 */
@Database(
        entities = {
                RecipeEntity.class,
                IngredientEntity.class,
                RecipeIngredientCrossRefEntity.class
        },
        version = 1
)
public abstract class MyRecipeDB extends RoomDatabase {
    private static volatile MyRecipeDB INSTANCE;
    private static final int N_THREADS = 4;
    private static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(N_THREADS);
    /**
     * recipeDao
     *
     * @return the class that is annotated with @Dao
     */
    public abstract RecipeDao recipeDao();


    /**
     *
     * @return the executor service
     */
    public static ExecutorService getDatabaseWriteExecutor() {
        return databaseWriteExecutor;
    }


    /**
     * <p>getDatabase is a static method that create a SQLite database connection with room library
     * and it ensures that is unique</p>
     *
     * @param context The context for the database. This is usually the Application context.
     * @return reference to the database object itself
     */
    public static MyRecipeDB getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (MyRecipeDB.class) {
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(), MyRecipeDB.class, Util.MY_RECIPE_DB)
                            .build();
                }
            }
        }

        return INSTANCE;
    }
}
