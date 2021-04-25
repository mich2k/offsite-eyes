package it.ooproject.offsiteeyes.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import it.ooproject.offsiteeyes.R;
import it.ooproject.offsiteeyes.adapters.MyRecipeAdapter;
import it.ooproject.offsiteeyes.database.entities.IngredientEntity;
import it.ooproject.offsiteeyes.database.entities.RecipeEntity;
import it.ooproject.offsiteeyes.viewmodels.MyRecipeViewModel;


public class MyRecipeActivity extends AppCompatActivity {
    private MyRecipeViewModel myRecipeViewModel;
    private FloatingActionButton fab;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry_my_recipes);

        fab = findViewById(R.id.FAB_myrecipes);

        RecyclerView myRecipeRecyclerView;
        myRecipeRecyclerView = findViewById(R.id.recycler_view_myrecipes);
        final MyRecipeAdapter myRecipeAdapter = new MyRecipeAdapter(new MyRecipeAdapter.MyRecipeDiff());

        myRecipeRecyclerView.setAdapter(myRecipeAdapter);
        myRecipeRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        myRecipeViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(MyRecipeViewModel.class);

        myRecipeViewModel.getRecipes().observe(this, list -> {
            myRecipeAdapter.submitList(list);
        });

        fab.setOnClickListener(v -> {
            IngredientEntity i = new IngredientEntity();
            i.setName("pasta");

            RecipeEntity r = new RecipeEntity();
            r.setTitle("Pasta al Ragu bolognese");
            r.setMethod("...");

            List<IngredientEntity> l = new ArrayList<>();
            l.add(i);

            myRecipeViewModel.insert(r, l);
        });
    }
}
