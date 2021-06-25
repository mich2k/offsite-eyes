package it.ooproject.offsiteeyes.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


import it.ooproject.offsiteeyes.viewholder.MyRecipeViewHolder;
import it.ooproject.offsiteeyes.R;
import it.ooproject.offsiteeyes.adapters.MyRecipeAdapter;
import it.ooproject.offsiteeyes.models.RecipeModel;
import it.ooproject.offsiteeyes.viewmodels.MyRecipeViewModel;


public class MyRecipeActivity extends AppCompatActivity implements MyRecipeViewHolder.OnRecipeListener {
    private MyRecipeViewModel myRecipeViewModel;
    private FloatingActionButton fab;
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry_my_recipes);

        fab = findViewById(R.id.FAB_myrecipes);

        RecyclerView myRecipeRecyclerView;
        myRecipeRecyclerView = findViewById(R.id.recycler_view_myrecipes);
        final MyRecipeAdapter myRecipeAdapter = new MyRecipeAdapter(new MyRecipeAdapter.MyRecipeDiff(), this);

        myRecipeRecyclerView.setAdapter(myRecipeAdapter);
        myRecipeRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        myRecipeViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(MyRecipeViewModel.class);

        myRecipeViewModel.getRecipes().observe(this, list -> {
            myRecipeAdapter.submitList(list);
            //Toast.makeText(this, "sel: " + list.get(1).getRecipe().getTitle(), Toast.LENGTH_SHORT).show();


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

    @Override
    public void onRecipeListener(int position) {
        myRecipeViewModel.getRecipes().getValue().get(position);
        Intent intent = new Intent(this, MyRecipeShowRecipeData.class);
        startActivity(intent);
    }
}