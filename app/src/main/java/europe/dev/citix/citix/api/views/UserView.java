package europe.dev.citix.citix.api.views;

import europe.dev.citix.citix.api.core.RequestCoreWrapper;
import europe.dev.citix.citix.api.models.GetUser;
import europe.dev.citix.citix.api.models.ListGetUser;
import europe.dev.citix.citix.api.requesthandlers.ObjectHandler;

public class UserView extends RequestCoreWrapper {
    private static final String TAG = "users";

    private static final String USERS_URL = "users/";
    private static final String USERS_ME_URL = USERS_URL + "me/";
    private static final String USERS_PHOTO_URL = USERS_URL + "photo/";
    private static final String USERS_REACTION_URL = USERS_URL + "reaction/";

    public UserView(String auth_token) {
        super(TAG, auth_token);
    }

    public void getUserMe(ObjectHandler<GetUser> handler) {
        get(USERS_ME_URL, null, header, null, handler, GetUser.class);
    }

    public void getAll(ObjectHandler<ListGetUser> handler) {
        get(USERS_URL, null, header, null, handler, ListGetUser.class);
    }

    public void get(long userId, ObjectHandler<GetUser> handler) {
        String relativeUrl = mRequestUtils.getIdRelativeUrl(USERS_URL, userId);

        get(relativeUrl, null, header, null, handler, GetUser.class);
    }
}
