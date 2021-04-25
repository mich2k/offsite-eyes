package it.ooproject.offsiteeyes.activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import it.ooproject.offsiteeyes.R;

public class AddMyRecipeActivity extends AppCompatActivity{
    private LinearLayout ingredientLinearLayout;
    private Button btnAddIngredient;
    private Button btnImageIngredient;
    private ImageView tx;

    private String base64Ingredient;
    private List<String> ingredientList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantry_my_recipes_add);

        ingredientLinearLayout = findViewById(R.id.linear_layout_my_recipe_add_list_ingredients);
        btnAddIngredient = findViewById(R.id.button_my_recipe_add_ingredient);
        btnImageIngredient = findViewById(R.id.button_my_recipe_add_image_ingredient);
        tx = findViewById(R.id.textView2);

        btnAddIngredient.setOnClickListener(this::addIngredientView);
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

    private void addIngredientView(View v){
        @SuppressLint("InflateParams")
        final View ingredientRowView = getLayoutInflater().inflate(R.layout.row_pantry_my_recipes_add, null, false);

        ImageButton btnRemoveIngredient = ingredientRowView.findViewById(R.id.image_btn_row_remove_ingredient);

        btnRemoveIngredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeIngredientView(ingredientRowView);
            }
        });


        ingredientLinearLayout.addView(ingredientRowView);
    }

    private void removeIngredientView(View view){
        ingredientLinearLayout.removeView(view);
    }

    private void selectIngredientImage() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");

        startActivityForResult(Intent.createChooser(intent, "Scegli una immagine"), 100);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==100 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            selectIngredientImage();
        else
            Toast.makeText(getApplicationContext(), "Permesso negato", Toast.LENGTH_SHORT).show();
    }

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
                    base64Ingredient = Base64.encodeToString(bytes, Base64.DEFAULT);

                    btnImageIngredient.setClickable(false);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
