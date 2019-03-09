package europe.dev.citix.citix.models;

import europe.dev.citix.citix.api.models.GetEvent;

public class Event extends GetEvent {
    public Event(GetEvent getEvent) {
        super(getEvent.getName(),
                getEvent.getDescription(),
                getEvent.getLat(),
                getEvent.getLng(),
                getEvent.getId(),
                getEvent.getPhotoUrls(),
                getEvent.getUserReactions()
        );
    }
}
