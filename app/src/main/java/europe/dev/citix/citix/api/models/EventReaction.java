package europe.dev.citix.citix.api.models;

public class EventReaction {
    private long user_id;
    private boolean interested;
    private boolean going;
    private long event_id;

    public EventReaction(long user_id, boolean interested, boolean going, long event_id) {
        this.user_id = user_id;
        this.interested = interested;
        this.going = going;
        this.event_id = event_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public boolean isInterested() {
        return interested;
    }

    public void setInterested(boolean interested) {
        this.interested = interested;
    }

    public boolean isGoing() {
        return going;
    }

    public void setGoing(boolean going) {
        this.going = going;
    }

    public long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(long event_id) {
        this.event_id = event_id;
    }
}
