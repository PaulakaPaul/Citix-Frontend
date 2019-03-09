package europe.dev.citix.citix.api.models;

public abstract class BaseEvent {
    private String name;
    private String description;
    private float lat;
    private float lng;

    public BaseEvent(String name, String description, float lat, float lng) {
        this.name = name;
        this.description = description;
        this.lat = lat;
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }
}
