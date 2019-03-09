package europe.dev.citix.citix.api.views;

import org.json.JSONObject;

import europe.dev.citix.citix.api.core.RequestCoreWrapper;
import europe.dev.citix.citix.api.models.GetEmailAuth;
import europe.dev.citix.citix.api.models.PostEmailAuth;
import europe.dev.citix.citix.api.requesthandlers.ObjectHandler;

public class AuthView extends RequestCoreWrapper {
    private static final String TAG = "auth";

    private static final String EMAIL_AUTH_URL = "auth/email/";
    private static final String EMAIL_SIGNUP_URL = EMAIL_AUTH_URL + "signup/";
    private static final String EMAIL_LOGIN_URL = EMAIL_AUTH_URL + "login/";

    public AuthView() {
        super(TAG, null);
    }

    public void login(PostEmailAuth postEmailAuth, ObjectHandler<GetEmailAuth> handler) {
        auth(EMAIL_LOGIN_URL, postEmailAuth, handler);
    }

    public void signup(PostEmailAuth postEmailAuth, ObjectHandler<GetEmailAuth> handler) {
        auth(EMAIL_SIGNUP_URL, postEmailAuth, handler);
    }

    private void auth(String url, PostEmailAuth postEmailAuth, ObjectHandler<GetEmailAuth> handler) {
        JSONObject body = serializer.serializeToJSON(postEmailAuth);

        post(url, null, header, body, handler, GetEmailAuth.class);
    }

}
