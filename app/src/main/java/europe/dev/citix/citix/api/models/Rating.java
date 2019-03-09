package europe.dev.citix.citix.api.models;

import com.google.gson.annotations.SerializedName;

public class Rating {
    @SerializedName("star_rating")
    private float starRating;

    public Rating(float starRating) {
        this.starRating = starRating;
    }

    public float getStarRating() {
        return starRating;
    }

    public void setStarRating(float starRating) {
        this.starRating = starRating;
    }
}
