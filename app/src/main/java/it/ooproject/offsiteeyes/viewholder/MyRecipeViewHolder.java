package it.ooproject.offsiteeyes.viewholder;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import it.ooproject.offsiteeyes.activities.AddMyRecipeActivity;
import it.ooproject.offsiteeyes.adapters.MyRecipeAdapter;

import it.ooproject.offsiteeyes.R;

public class MyRecipeViewHolder extends RecyclerView.ViewHolder {
    //private ImageView recipeImage;
    private final TextView titleRecipe;
    private final TextView methodRecipe;
    private final CardView cardView;

    public CardView getCardView() {
        return cardView;
    }

    public MyRecipeViewHolder(@NonNull View itemView) {
        super(itemView);
        //recipeImage = itemView.findViewById(R.id.image_view_myrecipes_item);
        cardView = itemView.findViewById(R.id.card_view_myrecipes_item);
        titleRecipe = itemView.findViewById(R.id.text_view_myrecipes_title_item);
        methodRecipe = itemView.findViewById(R.id.text_view_myrecipes_description_item);

    }

    public void bind(String title, String method){
        titleRecipe.setText(title);
        methodRecipe.setText(method);
    }

    public static MyRecipeViewHolder create(ViewGroup parent){
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.row_pantry_my_recipes_item, parent, false);
        return new MyRecipeViewHolder(view);
    }
}
