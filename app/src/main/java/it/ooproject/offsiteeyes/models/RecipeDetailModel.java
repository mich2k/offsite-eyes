package it.ooproject.offsiteeyes.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/***
 * <p>name       : RecipeDetailModel</p>
 * <p>description: RecipeDetailModel</p>
 */
public class RecipeDetailModel extends RecipeModel{
    @SerializedName("servings")
    @Expose
    private int servings;

    @SerializedName("sourceUrl")
    @Expose
    private String sourceUrl;


    @SerializedName("summary")
    @Expose
    private String summary;


    @SerializedName("readyInMinutes")
    @Expose
    private int readyInMinutes;

    public RecipeDetailModel(int id, String title, String image, int servings, String sourceUrl,
                             String summary, int readyInMinutes) {
        super(id, title, image);
        this.servings = servings;
        this.sourceUrl = sourceUrl;
        this.summary = summary;
        this.readyInMinutes = readyInMinutes;
    }

    /***
     *
     * @return
     */
    public int getServings() {
        return servings;
    }

    /***
     *
     * @param servings
     */
    public void setServings(int servings) {
        this.servings = servings;
    }

    /***
     *
     * @return
     */
    public String getSourceUrl() {
        return sourceUrl;
    }

    /***
     *
     * @param sourceUrl
     */
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    /***
     *
     * @return
     */
    public String getSummary() {
        return summary;
    }

    /***
     *
     * @param summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /***
     *
     * @return
     */
    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    /***
     *
     * @param readyInMinutes
     */
    public void setReadyInMinutes(int readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }
}
