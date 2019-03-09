package europe.dev.citix.citix.api.models;

import java.util.List;

public class GetEvent extends BaseEvent {

    private List<String> photo_urls;
    private List<EventReaction> user_reactions;

    public GetEvent(String name, String description, float lat, float lng, List<String> photo_urls, List<EventReaction> user_reactions) {
        super(name, description, lat, lng);
        this.photo_urls = photo_urls;
        this.user_reactions = user_reactions;
    }

    public List<String> getPhoto_urls() {
        return photo_urls;
    }

    public void setPhoto_urls(List<String> photo_urls) {
        this.photo_urls = photo_urls;
    }

    public List<EventReaction> getUser_reactions() {
        return user_reactions;
    }

    public void setUser_reactions(List<EventReaction> user_reactions) {
        this.user_reactions = user_reactions;
    }
}
