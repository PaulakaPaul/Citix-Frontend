package europe.dev.citix.citix.api.requesthandlers;

import org.json.JSONObject;

public interface OnSuccessHandler {
    void handle(JSONObject response);
}
