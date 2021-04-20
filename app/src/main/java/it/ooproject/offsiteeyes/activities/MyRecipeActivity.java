package it.ooproject.offsiteeyes.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import it.ooproject.offsiteeyes.R;
import it.ooproject.offsiteeyes.adapters.MyRecipesAdapter;
import it.ooproject.offsiteeyes.models.MyRecipeModel;


public class MyRecipeActivity extends AppCompatActivity {
    RecyclerView myRecipeRecycler;
    MyRecipesAdapter myRecipesAdapter;
    EditText searchEditText;
    CharSequence query = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry_my_recipes);

        searchEditText = findViewById(R.id.edit_text_search_myrecipes);

        List<MyRecipeModel> myRecipeModelList = new ArrayList<>();

        for(int i=0; i<10; i++) {
            try {
                myRecipeModelList.add(new MyRecipeModel(
                        "Pasta con le sarde",
                        "La pasta con le sarde è un tipico primo piatto della cucina siciliana...",
                        new URL("https://picsum.photos/id/"+ i +"/200/300")
                ));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        setMyRecipeRecycler(myRecipeModelList);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                myRecipesAdapter.getFilter().filter(s);
                query = s;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void setMyRecipeRecycler(List<MyRecipeModel> myRecipeModelList){
        myRecipeRecycler = findViewById(R.id.recycler_view_myrecipes);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        myRecipeRecycler.setLayoutManager(layoutManager);
        myRecipesAdapter = new MyRecipesAdapter(this, myRecipeModelList);
        myRecipeRecycler.setAdapter(myRecipesAdapter);
    }
}
