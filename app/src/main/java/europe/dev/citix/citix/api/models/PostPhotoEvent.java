package europe.dev.citix.citix.api.models;

public class PostPhotoEvent {
    private long event_id;
    private byte[] photo_file;

    public PostPhotoEvent(long event_id, byte[] photo_file) {
        this.event_id = event_id;
        this.photo_file = photo_file;
    }

    public long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(long event_id) {
        this.event_id = event_id;
    }

    public byte[] getPhoto_file() {
        return photo_file;
    }

    public void setPhoto_file(byte[] photo_file) {
        this.photo_file = photo_file;
    }
}
