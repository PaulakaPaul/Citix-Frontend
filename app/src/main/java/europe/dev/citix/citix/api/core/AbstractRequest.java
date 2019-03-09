package europe.dev.citix.citix.api.core;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.AuthFailureError;
import com.android.volley.error.VolleyError;
import com.android.volley.request.JsonObjectRequest;

import org.json.JSONObject;

import java.util.Map;

import europe.dev.citix.citix.CitixApp;
import europe.dev.citix.citix.api.requesthandlers.JSONHandler;
import europe.dev.citix.citix.api.requesthandlers.ObjectHandler;
import europe.dev.citix.citix.api.utils.RequestUtils;
import europe.dev.citix.citix.api.utils.Serializer;

abstract public class AbstractRequest {

    private String baseUrl;
    private String tag;

    protected static RequestUtils mRequestUtils;
    protected static Serializer serializer;

    AbstractRequest(String baseUrl, String tag) {
        this.baseUrl = baseUrl;
        this.tag = tag;

        if(mRequestUtils == null)
            mRequestUtils = new RequestUtils(baseUrl);

        if(serializer == null)
            serializer = new Serializer();
    }

    protected <T> void get(String relativeUrl,
                    Map<?, ?> queryParams,
                    Map<String, String> header,
                    JSONObject jsonObject,
                    ObjectHandler<T> objectHandler,
                    Class<T> type) {
        request(Request.Method.GET, relativeUrl, queryParams, header, jsonObject,
                objectHandler, type);
    }

    protected <T> void post(String relativeUrl,
                     Map<?, ?> queryParams,
                     Map<String, String> header,
                     JSONObject jsonObject,
                     ObjectHandler<T> objectHandler,
                     Class<T> type) {
        request(Request.Method.POST, relativeUrl, queryParams, header, jsonObject,
                objectHandler, type);
    }

    protected <T> void patch(String relativeUrl,
                      Map<?, ?> queryParams,
                      Map<String, String> header,
                      JSONObject jsonObject,
                      ObjectHandler<T> objectHandler,
                      Class<T> type) {
        request(Request.Method.PATCH, relativeUrl, queryParams, header, jsonObject,
                objectHandler, type);
    }

    protected <T> void delete(String relativeUrl,
                       Map<?, ?> queryParams,
                       Map<String, String> header,
                       JSONObject jsonObject,
                       ObjectHandler<T> objectHandler,
                       Class<T> type) {
        request(Request.Method.DELETE, relativeUrl, queryParams, header, jsonObject,
                objectHandler, type);
    }


    private <T> void request(final int mode, final String relativeUrl,
                         final Map<?, ?> queryParams,
                         final Map<String, String> header,
                         final JSONObject body,
                         final ObjectHandler<T> objectHandler,
                         final Class<T> type
                         ) {

        if (header == null)
            throw new AssertionError("Header cannot be null");

        String url = mRequestUtils.getFullUrl(relativeUrl, queryParams);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(mode, url, body,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("jsonRequestSuccess", response.toString());

                        if (objectHandler != null) {
                            T object = serializer.fromJSON(response, type);
                            objectHandler.handle(object);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        try {
                            Log.e("JSONErrorResponse", error.getMessage());
                        } catch (NullPointerException e) {
                            Log.e("JSONErrorResponse", "Volley failed");
                        }

                        if(objectHandler != null)
                            objectHandler.handle(null);
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return header;
            }
        };


        jsonObjectRequest.setTag(this.tag);
        CitixApp.requestQueue.addToRequestQueue(jsonObjectRequest);
    }

    protected void postFile(final String relativeUrl,
                             final Map<?, ?> queryParams,
                             final Map<String, String> header,
                             final Map<String, String> body,
                             final String image,
                             final JSONHandler JSONHandler) {
    }

    protected void cancelRequests() {
        CitixApp.requestQueue.cancelRequests(this.tag);
    }
}
