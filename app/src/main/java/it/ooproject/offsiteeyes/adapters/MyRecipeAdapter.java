package it.ooproject.offsiteeyes.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import it.ooproject.offsiteeyes.viewholder.MyRecipeViewHolder;
import it.ooproject.offsiteeyes.database.entities.RecipeWithIngredientEntity;

public class MyRecipeAdapter extends ListAdapter<RecipeWithIngredientEntity, MyRecipeViewHolder> {
    MyRecipeViewHolder.OnRecipeListener onRecipeListener;
    public MyRecipeAdapter(@NonNull DiffUtil.ItemCallback<RecipeWithIngredientEntity> diffCallback, MyRecipeViewHolder.OnRecipeListener onRecipeListener) {
        super(diffCallback);
        this.onRecipeListener = onRecipeListener;
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