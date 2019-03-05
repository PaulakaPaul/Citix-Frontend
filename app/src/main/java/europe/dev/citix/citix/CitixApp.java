package europe.dev.citix.citix;

import android.app.Application;

import europe.dev.citix.citix.api.core.RequestQueueSingleton;

public class CitixApp extends Application {
    public static CitixApp instance;
    public static RequestQueueSingleton requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        requestQueue = RequestQueueSingleton.getInstance(this);
    }

}
