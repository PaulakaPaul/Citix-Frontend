package europe.dev.citix.citix.api.views;

import europe.dev.citix.citix.api.wrappers.RequestCoreWrapper;

public class EventView extends RequestCoreWrapper {

    private static final String TAG = "/events";
    private static final String CREATE_URL = TAG + "/";
    private static final String CREATE_PHOTO_URL = CREATE_URL + "photo/";
    private static final String CREATE_REACTION_URL = CREATE_URL + "reaction/";

    public EventView(){
        super(TAG);
    }

    public void get(){}

    public void create(){}

    public void getAll(){}

    public void getAllByLocation(){}

    public void postPhotoToEvent(){}

    public void getEventByID(){}

    public void patchEventByID(){}

    public void putEventByID(){}

}
