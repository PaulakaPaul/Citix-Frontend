package europe.dev.citix.citix.api.core;

import android.text.TextUtils;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import europe.dev.citix.citix.CitixApp;
import europe.dev.citix.citix.api.requesthandlers.OnSuccessHandler;
import europe.dev.citix.citix.api.requesthandlers.OnSuccessListHandler;
import europe.dev.citix.citix.api.utils.RequestUtils;

abstract public class AbstractRequest {

    private String baseUrl;
    private String tag;
    private RequestUtils mRequestUtils;

    public AbstractRequest(){}

    public AbstractRequest(String baseUrl, String tag){
        this.baseUrl = baseUrl;
        this.tag = tag;
        this.mRequestUtils = new RequestUtils(baseUrl);}

    public void get(String relativeUrl,
                    Map<?, ?> queryParams,
                    Map<String, String> header,
                    JSONObject jsonObject,
                    OnSuccessHandler onSuccessHandler
    ) {
        request(Request.Method.GET, relativeUrl, queryParams, header, jsonObject,
                onSuccessHandler, null);
    }

    public void post(String relativeUrl,
                     Map<?, ?> queryParams,
                     Map<String, String> header,
                     JSONObject jsonObject,
                     OnSuccessHandler onSuccessHandler) {
        request(Request.Method.POST, relativeUrl, queryParams, header, jsonObject,
                onSuccessHandler, null);
    }

    public void patch(String relativeUrl,
                      Map<?, ?> queryParams,
                      Map<String, String> header,
                      JSONObject jsonObject,
                      OnSuccessHandler onSuccessHandler) {
        request(Request.Method.PATCH, relativeUrl, queryParams, header, jsonObject,
                onSuccessHandler, null);
    }

    public void delete(String relativeUrl,
                       Map<?, ?> queryParams,
                       Map<String, String> header,
                       JSONObject jsonObject,
                       OnSuccessHandler onSuccessHandler) {
        request(Request.Method.DELETE, relativeUrl, queryParams, header, jsonObject,
                onSuccessHandler, null);
    }



    private void request(final int mode, final String relativeUrl,
                         final Map<?, ?> queryParams,
                         final Map<String, String> header,
                         final JSONObject body,
                         final OnSuccessHandler onSuccessHandler,
                         final OnSuccessListHandler onSuccessListHandler) {

        if(header == null)
            throw new RuntimeException("Header cannot be null");

        String url = mRequestUtils.getFullUrl(relativeUrl, queryParams);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(mode, url, body,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("jsonRequestSuccess", response.toString());
                            if (onSuccessHandler != null)
                                onSuccessHandler.handle(response);
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
                    }
                })
        {
            @Override
            public Map<String, String> getHeaders () throws AuthFailureError {
                return header;
            }
        };


        jsonObjectRequest.setTag(this.tag);
        CitixApp.requestQueue.addToRequestQueue(jsonObjectRequest);
    }

    public void cancelRequests() {
        CitixApp.requestQueue.cancelRequests(this.tag);
    }




}
