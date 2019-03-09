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
    }

}
