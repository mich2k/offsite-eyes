package it.ooproject.offsiteeyes.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import it.ooproject.offsiteeyes.models.RecipeModel;
import it.ooproject.offsiteeyes.viewholder.DiscoverRecipeViewHolder;

public class DiscoverRecipeAdapter extends ListAdapter<RecipeModel, DiscoverRecipeViewHolder> {
    public DiscoverRecipeAdapter(@NonNull DiffUtil.ItemCallback<RecipeModel> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public DiscoverRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return DiscoverRecipeViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscoverRecipeViewHolder holder, int position) {
        RecipeModel current = getItem(position);
        holder.bind(current.getImage(), current.getTitle());
    }

    public static class DiscoveryDiff extends DiffUtil.ItemCallback<RecipeModel>{

        @Override
        public boolean areItemsTheSame(@NonNull RecipeModel oldItem, @NonNull RecipeModel newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull RecipeModel oldItem, @NonNull RecipeModel newItem) {
            return false;
        }
    }
}
