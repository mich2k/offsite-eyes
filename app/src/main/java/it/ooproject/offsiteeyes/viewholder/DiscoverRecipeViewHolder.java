package it.ooproject.offsiteeyes.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import it.ooproject.offsiteeyes.R;

public class DiscoverRecipeViewHolder extends RecyclerView.ViewHolder {
    private final ImageView image;
    private final TextView title;

    public DiscoverRecipeViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.img_discover_recipes);
        title = itemView.findViewById(R.id.textview_discover_recipes_title);
    }

    public void bind(String image, String title){
        this.title.setText(title);
        Picasso.get()
                .load(image)
                .error(R.drawable.ic_baseline_close_24_black)
                .placeholder(R.drawable.progress_animation)
                .into(this.image);

    }

    public static DiscoverRecipeViewHolder create(ViewGroup parent){
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.row_pantry_discover_recipes, parent, false);

        return new DiscoverRecipeViewHolder(v);
    }





}
