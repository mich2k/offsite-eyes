package it.ooproject.offsiteeyes.adapters;


import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import it.ooproject.offsiteeyes.viewholder.MyRecipeViewHolder;
import it.ooproject.offsiteeyes.database.entities.RecipeWithIngredientEntity;


/**
 * <p>MyRecipeAdapter is a public class that extends ListAdapter<DataRowType><RowViewHolder> and this
 * class is responsible of acting like a bridge between RecyclerView and the data model. ListAdapter
 * extends RecyclerView.Adapter base abstract class for presenting List data in a RecyclerView,
 * including computing diffs between Lists on a background thread.</p>
 */
public class MyRecipeAdapter extends ListAdapter<RecipeWithIngredientEntity, MyRecipeViewHolder> {
    private onItemClickListener listener;

    /**
     * <p>MyRecipeAdapter public constructor</p>
     *
     * @param diffCallback Callback for calculating the diff between two non-null items in a list.
     */
    public MyRecipeAdapter(@NonNull DiffUtil.ItemCallback<RecipeWithIngredientEntity> diffCallback) {
        super(diffCallback);
        this.listener = null;
    }

    /**
     * <p>Called when RecyclerView needs a new RecyclerView.ViewHolder of MyRecipeViewHolder type to
     * represent a RecipeWithIngredientEntity item. This new ViewHolder should be constructed
     * with a new View that can represent the item of the given type.
     * The new ViewHolder will be used to display items of the adapter using
     * onBindViewHolder(ViewHolder, int, List).</p>
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType  The view type of the new View.
     * @return A new ViewHolder that holds a View of MyRecipeViewHolder
     */
    @NonNull
    @Override
    public MyRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MyRecipeViewHolder.create(parent);
    }

    /**
     * <p>Called by RecyclerView to display the data at the specified position.
     * This method should update the contents of the RecyclerView.ViewHolder.itemView
     * to reflect the item at the given position. Each VH has bind a click listener that
     * allow to get recipe detail</p>
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull MyRecipeViewHolder holder, int position) {
        RecipeWithIngredientEntity current = getItem(position);
        holder.bind(current.getRecipe().getTitle(), current.getRecipe().getMethod());

        holder.getCardView().setOnClickListener(v -> {
            if(listener != null && position != RecyclerView.NO_POSITION){
                listener.onItemClick(current);
            }
        });
    }



    /**
     * <p>MyRecipeDiff is a public class that extends DiffUtil. DiffUtil is a utility class that
     * calculates the difference between two lists and outputs a list of update operations that
     * converts the first list into the second one.</p>
     */
    public static class MyRecipeDiff extends DiffUtil.ItemCallback<RecipeWithIngredientEntity>{
        /**
         * <p>Called to check whether two objects represent the same item. If your items have unique
         * ids, this method should check their id equality. Here we check as our is Post is unique
         * we have a check on id, it could have been any unique constraint for your model.</p>
         *
         * @param oldItem the item in the old list
         * @param newItem the item in the new list
         * @return True if the ids of the items are the same or false if they are different.
         */
        @Override
        public boolean areItemsTheSame(@NonNull RecipeWithIngredientEntity oldItem,
                                       @NonNull RecipeWithIngredientEntity newItem) {
            return oldItem.getRecipe().getRecipeID() == newItem.getRecipe().getRecipeID();
        }

        /**
         * <p>Checks whether two items have the same data. This method is called only if
         * areItemsTheSame(T, T) returns true for these items, i.e. if any of the id is available
         * in both new and old list it would compare actual properties to verify if they have
         * changed and with Kotlin all we need to do is oldItem == newItem</p>
         *
         * @param oldItem the item in the old list
         * @param newItem the item in the new list
         * @return True if the title and the preparation of the items are the same or false if they are different.
         */
        @Override
        public boolean areContentsTheSame(@NonNull RecipeWithIngredientEntity oldItem,
                                          @NonNull RecipeWithIngredientEntity newItem) {
            return oldItem.getRecipe().getTitle().equals(newItem.getRecipe().getTitle()) &&
                    oldItem.getRecipe().getMethod().equals(newItem.getRecipe().getMethod());
        }
    }


    public interface onItemClickListener{
        /**
         * Custom item click listener
         *
         * @param recipeWithIngredient data item row
         */
        void onItemClick(RecipeWithIngredientEntity recipeWithIngredient);
    }

    /**
     * Set the listener attribute
     * @param listener listener object
     */
    public void setOnItemListener(onItemClickListener listener){
        this.listener = listener;
    }
}