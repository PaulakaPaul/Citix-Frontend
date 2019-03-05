package europe.dev.citix.citix.api.requesthandlers;

import org.json.JSONObject;

public interface OnSuccessListHandler {
    void handle(JSONObject response);
}
