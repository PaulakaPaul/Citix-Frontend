package europe.dev.citix.citix.utils;

import europe.dev.citix.citix.api.models.GetUser;
import europe.dev.citix.citix.api.requesthandlers.ObjectHandler;
import europe.dev.citix.citix.api.views.UserView;

public class AuthUtils {
    private static final String TOKEN = "token";

    private static SpUtils spUtils;

    public AuthUtils() {
        if (spUtils == null) {
            spUtils = new SpUtils();
        }
    }

    public void isLoggedIn(ObjectHandler<GetUser> handler) {
          String token = getToken();

          new UserView(token).getUserMe(handler);
    }

    public String getToken() {
        return spUtils.loadString(TOKEN);
    }

    public void cacheToken(String token) {
        spUtils.save(TOKEN, token);
    }
}
