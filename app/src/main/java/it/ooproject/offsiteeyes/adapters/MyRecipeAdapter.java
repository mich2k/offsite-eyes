package it.ooproject.offsiteeyes.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import it.ooproject.offsiteeyes.MyRecipeViewHolder;
import it.ooproject.offsiteeyes.database.entities.RecipeEntity;
import it.ooproject.offsiteeyes.database.entities.RecipeWithIngredientEntity;

public class MyRecipeAdapter extends ListAdapter<RecipeWithIngredientEntity, MyRecipeViewHolder> {
    public MyRecipeAdapter(@NonNull DiffUtil.ItemCallback<RecipeWithIngredientEntity> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MyRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MyRecipeViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecipeViewHolder holder, int position) {
        RecipeWithIngredientEntity current = getItem(position);
        holder.bind(current.getRecipe().getTitle(), current.getRecipe().getMethod());
    }

    public static class MyRecipeDiff extends DiffUtil.ItemCallback<RecipeWithIngredientEntity>{

        @Override
        public boolean areItemsTheSame(@NonNull RecipeWithIngredientEntity oldItem, @NonNull RecipeWithIngredientEntity newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull RecipeWithIngredientEntity oldItem, @NonNull RecipeWithIngredientEntity newItem) {
            return oldItem.getRecipe().getTitle().equals(newItem.getRecipe().getTitle()) &&
                    oldItem.getRecipe().getMethod().equals(newItem.getRecipe().getMethod());
        }
    }
}