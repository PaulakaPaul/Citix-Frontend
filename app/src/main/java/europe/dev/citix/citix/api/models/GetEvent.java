package europe.dev.citix.citix.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetEvent extends BaseEvent {
    private int id;

    @SerializedName("photo_urls")
    private List<String> photoUrls;
    @SerializedName("user_reactions")
    private List<EventReaction> userReactions;

    public GetEvent(String name, String description, float lat, float lng, int id,
                    List<String> photoUrls, List<EventReaction> userReactions) {
        super(name, description, lat, lng);
        this.id = id;
        this.photoUrls = photoUrls;
        this.userReactions = userReactions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<EventReaction> getUserReactions() {
        return userReactions;
    }

    public void setUserReactions(List<EventReaction> userReactions) {
        this.userReactions = userReactions;
    }
}
