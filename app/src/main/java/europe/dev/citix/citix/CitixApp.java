package europe.dev.citix.citix;

import android.app.Application;

import europe.dev.citix.citix.api.core.RequestQueueSingleton;
import europe.dev.citix.citix.utils.AuthUtils;

public class CitixApp extends Application {
    public static CitixApp instance;
    public static RequestQueueSingleton requestQueue;

    public AuthUtils authUtils;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        requestQueue = RequestQueueSingleton.getInstance(this);

        authUtils = new AuthUtils();

//        authUtils.cacheToken(token);
//
//        PostEvent Event = new PostEvent("Android", "Android baseEvent", 21.227098f, 45.751753f);
//        EventReaction eventReaction = new EventReaction(1, true, false, 5);
//        PostEmailAuth postEmailAuth = new PostEmailAuth("test@gmail.com", "some-pass");
//
//        new UserView(token).getAll(new ObjectHandler<ListGetUser>() {
//            @Override
//            public void handle(ListGetUser response) {
//                Log.e("RESPONSE", response.toString());
//            }
//        });

    }

}
