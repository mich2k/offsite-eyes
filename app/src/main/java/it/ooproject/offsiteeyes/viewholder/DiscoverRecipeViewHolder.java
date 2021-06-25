package it.ooproject.offsiteeyes.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.zip.Inflater;

import it.ooproject.offsiteeyes.R;

public class DiscoverRecipeViewHolder extends RecyclerView.ViewHolder {
    private ImageView image;
    private TextView title;

    public DiscoverRecipeViewHolder(@NonNull View itemView) {
        super(itemView);

        //find by id
    }

    public void bind(String image, String title){

    }

    public static DiscoverRecipeViewHolder create(ViewGroup parent){
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.row_pantry_discrover_recipes, parent, false);

        return new DiscoverRecipeViewHolder(v);
    }





}
