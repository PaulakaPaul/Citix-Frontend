package europe.dev.citix.citix.api.views;

import android.graphics.Bitmap;

import org.json.JSONObject;

import europe.dev.citix.citix.api.core.RequestCoreWrapper;
import europe.dev.citix.citix.api.models.EventReaction;
import europe.dev.citix.citix.api.models.GetEvent;
import europe.dev.citix.citix.api.models.ListGetEvent;
import europe.dev.citix.citix.api.models.PostEvent;
import europe.dev.citix.citix.api.requesthandlers.JSONHandler;
import europe.dev.citix.citix.api.requesthandlers.ObjectHandler;

public class EventView extends RequestCoreWrapper {
    //TODO: add ID in event
    //TODO: photo logic

    private static final String TAG = "events";

    private static final String EVENTS_URL = "events/";
    private static final String EVENTS_PHOTO_URL = EVENTS_URL + "photo/";
    private static final String EVENTS_REACTION_URL = EVENTS_URL + "reaction/";


    public EventView(String auth_token) {
        super(TAG, auth_token);
    }

    public void get(long eventId, ObjectHandler<GetEvent> objectHandler){
        String relativeUrl = mRequestUtils.getIdRelativeUrl(EVENTS_URL, eventId);

        get(relativeUrl, null, header, null, objectHandler, GetEvent.class);
    }

    public void create(PostEvent event, ObjectHandler<GetEvent> objectHandler) {
        JSONObject body = serializer.serializeToJSON(event);

        post(EVENTS_URL, null, header, body, objectHandler, GetEvent.class);
    }

    public void getAll(ObjectHandler<ListGetEvent> objectHandler) {
        get(EVENTS_URL, null, header, null, objectHandler, ListGetEvent.class);
    }

    public void getAllByLocation(){
        throw new RuntimeException("Not implemented!");
    }

    public void postPhotoToEvent(Long eventId, Bitmap bitmap, JSONHandler JSONHandler) {

    }

    public void patchEventByID(long eventId, PostEvent event, ObjectHandler<GetEvent> objectHandler) {
        String relativeUrl = mRequestUtils.getIdRelativeUrl(EVENTS_URL, eventId);
        JSONObject body = serializer.serializeToJSON(event);

        patch(relativeUrl, null, header, body, objectHandler, GetEvent.class);
    }

    public void postEventReaction(EventReaction eventReaction, ObjectHandler<EventReaction> objectHandler) {
        JSONObject body = serializer.serializeToJSON(eventReaction);

        post(EVENTS_REACTION_URL, null, header, body, objectHandler, EventReaction.class);
    }
}
