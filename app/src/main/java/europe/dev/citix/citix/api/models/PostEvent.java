package europe.dev.citix.citix.api.models;

public class PostEvent extends BaseEvent{

    public PostEvent(String name, String description, float lat, float lng) {
        super(name, description, lat, lng);
    }

}
