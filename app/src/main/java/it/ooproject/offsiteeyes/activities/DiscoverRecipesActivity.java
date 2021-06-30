package it.ooproject.offsiteeyes.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import it.ooproject.offsiteeyes.R;
import it.ooproject.offsiteeyes.adapters.DiscoverRecipeAdapter;
import it.ooproject.offsiteeyes.adapters.MyRecipeAdapter;
import it.ooproject.offsiteeyes.repository.DiscoverRecipeRepository;
import it.ooproject.offsiteeyes.utils.EndlessRecyclerViewScrollListener;
import it.ooproject.offsiteeyes.viewmodels.DiscoverRecipeViewModel;

public class DiscoverRecipesActivity extends AppCompatActivity {
    private AutoCompleteTextView ingredients;
    private DiscoverRecipeViewModel discoverRecipeViewModel;
    private RecyclerView discoverRecyclerView;
    private Button btn;
    private EndlessRecyclerViewScrollListener scrollListener;
    private boolean loading = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_recipes);
        discoverRecyclerView = findViewById(R.id.recycler_view_discover_recipe);

        discoverRecipeViewModel = new ViewModelProvider(this).get(DiscoverRecipeViewModel.class);
        DiscoverRecipeAdapter recipeAdapter = new DiscoverRecipeAdapter(new DiscoverRecipeAdapter.DiscoveryDiff());
        discoverRecyclerView.setAdapter(recipeAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        discoverRecyclerView.setLayoutManager(layoutManager);

        discoverRecipeViewModel
                .getRecipes(10, 0)
                .observe(DiscoverRecipesActivity.this, recipeAdapter::submitList);

        btn = findViewById(R.id.button);



    }

    private void loadData(int totalItemsCount) {
        discoverRecipeViewModel.getRecipes(10, totalItemsCount);
    }
}