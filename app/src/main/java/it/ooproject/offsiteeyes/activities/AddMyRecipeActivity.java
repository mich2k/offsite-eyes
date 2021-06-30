package it.ooproject.offsiteeyes.activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import java.util.List;

import it.ooproject.offsiteeyes.R;
import it.ooproject.offsiteeyes.adapters.MyRecipeAdapter;
import it.ooproject.offsiteeyes.database.entities.IngredientEntity;
import it.ooproject.offsiteeyes.database.entities.RecipeEntity;
import it.ooproject.offsiteeyes.viewmodels.MyRecipeViewModel;



public class AddMyRecipeActivity extends AppCompatActivity  {
    private LinearLayout ingredientLinearLayout;
    private Button btnAddIngredient;
    private Button btnImageIngredient;
    private ImageButton btnSaveRecipe;
    private ImageButton btnExitAddMyRecipe;
    private ImageView tx;

    private List<IngredientEntity> ingredientList = new ArrayList<>();

    private TextInputLayout textInpLMyRecipeTitle;
    private TextInputLayout textInpLMyRecipeProcedure;
    private TextInputLayout textInpLMyRecipeNotes;

    private MyRecipeViewModel myRecipeViewModel;

    public static Context context;

    private RecyclerView mRecyclerView;
    private MyRecipeAdapter mAdapter;

    /***
     *
     * @param savedInstanceState
     */
    @SuppressLint("ResourceType")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry_my_recipes_add);

        ingredientLinearLayout = findViewById(R.id.linear_layout_my_recipe_add_list_ingredients);
        btnAddIngredient = findViewById(R.id.button_my_recipe_add_ingredient);
        btnImageIngredient = findViewById(R.id.button_my_recipe_add_image_ingredient);
        tx = findViewById(R.id.textview_discover_recipes_title);
        btnSaveRecipe = findViewById(R.id.tick_btn_save_recipe);
        btnExitAddMyRecipe = findViewById(R.id.cross_btn_exit_show_recipe);
        textInpLMyRecipeTitle = findViewById(R.id.edit_text_title_add_recipes);
        textInpLMyRecipeProcedure = findViewById(R.id.edit_text_method_add_recipes);    // assuming that method is referring to "Preparazione" TextInputLayer
        textInpLMyRecipeNotes = findViewById(R.id.edit_text_note_add_recipes);
        myRecipeViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(MyRecipeViewModel.class);
        context = getApplicationContext();
        mRecyclerView = findViewById(R.layout.row_pantry_my_recipes_add);
        EditText test = findViewById(R.id.edit_text_titlle_add_recipes_textInput);


        btnSaveRecipe.setOnClickListener(v -> {
            RecipeEntity recipe = new RecipeEntity(
                    0,
                    null,
                    null,
                    null,
                    null
            );
            recipe.setNote(textInpLMyRecipeNotes.getEditText().getText().toString());
            recipe.setTitle(textInpLMyRecipeTitle.getEditText().getText().toString());
            recipe.setMethod(textInpLMyRecipeProcedure.getEditText().getText().toString());


            for(int i=0; i<ingredientLinearLayout.getChildCount(); i++){
                LinearLayout linearLayout = (LinearLayout) ingredientLinearLayout.getChildAt(i);
                TextInputLayout textInputLayout = (TextInputLayout) linearLayout.getChildAt(0);
                TextInputEditText editText = (TextInputEditText) textInputLayout.getChildAt(0);

                System.out.println(editText.getText());
            }


            myRecipeViewModel.insert(recipe, ingredientList);
            finish();

        });


        btnExitAddMyRecipe.setOnClickListener(v -> {
            Toast.makeText(AddMyRecipeActivity.this, "La ricetta non verrà salvata", Toast.LENGTH_SHORT).show();
            finish();
        });


        btnAddIngredient.setOnClickListener(v -> {
            View ingredientRowId = addIngredientView(v);
        });


        btnImageIngredient.setOnClickListener(v -> {
            if(ContextCompat.checkSelfPermission(
                    AddMyRecipeActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(AddMyRecipeActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        100);
            } else {
                selectIngredientImage();
            }
        });
    }


    /***
     *
     * @param v
     * @return
     */
    private View addIngredientView(View v){
        @SuppressLint("InflateParams")
        final View ingredientRowView = getLayoutInflater().
                inflate(R.layout.row_pantry_my_recipes_add, null, false);
        ImageButton btnRemoveIngredient = ingredientRowView.
                findViewById(R.id.image_btn_row_remove_ingredient);

        btnRemoveIngredient.setOnClickListener(v1 -> removeIngredientView(ingredientRowView));
        ingredientLinearLayout.addView(ingredientRowView);
        return ingredientRowView;
    }

    /***
     *
     * @param view
     */
    private void removeIngredientView(View view){
        ingredientLinearLayout.removeView(view);
    }

    /***
     *
     */
    private void selectIngredientImage() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");

        startActivityForResult(Intent.createChooser(intent, "Scegli un immagine"), 100);
    }

    /***
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==100 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            selectIngredientImage();
        else
            Toast.makeText(getApplicationContext(), "Permesso negato", Toast.LENGTH_SHORT).show();
    }

    /***
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && resultCode == RESULT_OK && data != null){
            Uri uri  = data.getData();
            if(uri != null){
                try {
                    InputStream is = getContentResolver().openInputStream(uri);
                    Bitmap bmap = BitmapFactory.decodeStream(is);
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bmap.compress(Bitmap.CompressFormat.JPEG, 40, stream);
                    byte[] bytes = stream.toByteArray();
                    String base64Ingredient = Base64.encodeToString(bytes, Base64.DEFAULT);

                    btnImageIngredient.setClickable(false);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
