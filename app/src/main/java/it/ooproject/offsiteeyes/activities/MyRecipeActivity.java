package it.ooproject.offsiteeyes.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.ListAdapter;

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
            Toast.makeText(this, "a " + list.get(1).getRecipe().getTitle(), Toast.LENGTH_SHORT).show();


        });

        fab.setOnClickListener(v -> {
            startActivity(new Intent(MyRecipeActivity.this, AddMyRecipeActivity.class));
        });


        /*
        *   IngredientEntity i = new IngredientEntity();
            i.setName("pasta");

            RecipeEntity r = new RecipeEntity();
            r.setTitle("Pasta al Ragu bolognese");
            r.setMethod("...");

            List<IngredientEntity> l = new ArrayList<>();
            l.add(i);

            myRecipeViewModel.insert(r, l);
        * */
    }
}