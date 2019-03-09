package europe.dev.citix.citix.api.utils;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;


public class Serializer {
    private Gson gson;

    public Serializer() {
        gson = new Gson();
    }

    public String serializeToString(Object object) {
        return gson.toJson(object);
    }

    public JSONObject serializeToJSON(Object object) {
        try {
            return new JSONObject(serializeToString(object));
        } catch (JSONException e) {
            return new JSONObject();
        }
    }

    public <T> T fromJSON(JSONObject jsonObject, Class<T> type) {
        String jsonObjectAsString = jsonObject.toString();

        return gson.fromJson(jsonObjectAsString, type);
    }
}
