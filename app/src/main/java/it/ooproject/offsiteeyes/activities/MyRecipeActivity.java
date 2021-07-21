package it.ooproject.offsiteeyes.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


import it.ooproject.offsiteeyes.database.entities.RecipeWithIngredientEntity;
import it.ooproject.offsiteeyes.repository.DiscoverRecipeRepository;
import it.ooproject.offsiteeyes.viewholder.MyRecipeViewHolder;
import it.ooproject.offsiteeyes.R;
import it.ooproject.offsiteeyes.adapters.MyRecipeAdapter;
import it.ooproject.offsiteeyes.models.RecipeModel;
import it.ooproject.offsiteeyes.viewmodels.MyRecipeViewModel;

/***
 *
 */
public class MyRecipeActivity extends AppCompatActivity {
    MyRecipeViewModel myRecipeViewModel;
    FloatingActionButton fab;
    Context context;

    /***
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry_my_recipes);

        fab = findViewById(R.id.FAB_myrecipes);

        RecyclerView myRecipeRecyclerView;
        myRecipeRecyclerView = findViewById(R.id.recycler_view_myrecipes);
        MyRecipeAdapter myRecipeAdapter = new MyRecipeAdapter(new MyRecipeAdapter.MyRecipeDiff());


        myRecipeRecyclerView.setAdapter(myRecipeAdapter);
        myRecipeRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        myRecipeViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(MyRecipeViewModel.class);

        myRecipeViewModel.getRecipes().observe(this, myRecipeAdapter::submitList);

        fab.setOnClickListener(v -> {
            startActivity(new Intent(MyRecipeActivity.this, AddMyRecipeActivity.class));
        });

        myRecipeAdapter.setOnItemListener(recipeWithIngredient -> {
            Intent intent = new Intent(MyRecipeActivity.this, DiscoverRecipeRepository.class);
            intent.putExtra("recipeWithIngredient", recipeWithIngredient);
            startActivity(intent);
        });

    }
}