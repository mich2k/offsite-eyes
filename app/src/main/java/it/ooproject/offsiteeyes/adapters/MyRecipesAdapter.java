package it.ooproject.offsiteeyes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import it.ooproject.offsiteeyes.R;
import it.ooproject.offsiteeyes.models.MyRecipeModel;

public class MyRecipesAdapter extends RecyclerView.Adapter<MyRecipesAdapter.MyRecipesViewHolder> {
    Context ctx;
    List<MyRecipeModel> recipeModelList;
    List<MyRecipeModel> filteredRecipeModelList;


    public MyRecipesAdapter(Context ctx, List<MyRecipeModel> recipeModelList) {
        this.ctx = ctx;
        this.recipeModelList = recipeModelList;
        this.filteredRecipeModelList = recipeModelList;
    }

    @NonNull
    @Override
    public MyRecipesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.recyclerview_myrecipe_item, parent, false);
        return new MyRecipesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecipesViewHolder holder, int position) {
        holder.titleRecipe.setText(recipeModelList.get(position).getTitle());
        holder.descriptionRecipe.setText(recipeModelList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return filteredRecipeModelList.size();
    }

    protected final static class MyRecipesViewHolder extends RecyclerView.ViewHolder {
        ImageView recipeImage;
        TextView titleRecipe, descriptionRecipe;
        public MyRecipesViewHolder(@NonNull View itemView) {
            super(itemView);

            recipeImage = itemView.findViewById(R.id.image_view_myrecipes_item);
            titleRecipe = itemView.findViewById(R.id.text_view_myrecipes_title_item);
            descriptionRecipe = itemView.findViewById(R.id.text_view_myrecipes_description_item);
        }
    }

    public Filter getFilter(){
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String search = constraint.toString();
                if (search.isEmpty()){
                    filteredRecipeModelList = recipeModelList;
                } else {
                    List<MyRecipeModel> filtered = new ArrayList<>();
                    for(MyRecipeModel recipeItem : recipeModelList){
                        if(recipeItem.getTitle().toLowerCase().contains(search.toLowerCase())){
                            filtered.add(recipeItem);
                        }
                    }
                    filteredRecipeModelList = filtered;
                }
                FilterResults results = new FilterResults();
                results.values = filteredRecipeModelList;

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredRecipeModelList = (List<MyRecipeModel>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
