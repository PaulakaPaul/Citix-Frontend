package europe.dev.citix.citix.api.utils;

import android.text.TextUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class RequestUtils {

    private String baseUrl;

    public RequestUtils(String baseUrl){
        this.baseUrl = concatEndBackslashIfMissing(baseUrl);
    }

    public Map<String, String> computeHeader(String auth_token) {
        HashMap<String, String> header = new HashMap<>();

        if (auth_token != null)
            header.put("Authorization", "Token " + auth_token);

        return header;
    }

    public String getFullUrl(String relativeUrl) {
        return getFullUrl(relativeUrl, null);
    }

    public String getFullUrl(String relativeUrl, Map<?, ?> queryParameters) {
        String absoluteURL = baseUrl + deleteTrailingBackslashIfExists(relativeUrl);

        if(queryParameters == null)
            return absoluteURL;

        String stringQueryParameters = getQueryStrings(queryParameters);
        if(TextUtils.isEmpty(stringQueryParameters))
            return absoluteURL;

        return absoluteURL + "?" + getQueryStrings(queryParameters);
    }

    public String getFullUrl(String relativeUrl, long id, Map<?, ?> queryParameters) {
        relativeUrl = concatEndBackslashIfMissing(relativeUrl);
        relativeUrl = relativeUrl + id + "/";
        return getFullUrl(relativeUrl, queryParameters);
    }

    public String getFullUrl(String relativeUrl, long id) {
        return getFullUrl(relativeUrl, id, null);
    }

    public String getIdRelativeUrl(String relativeUrl, long id) {
        relativeUrl = concatEndBackslashIfMissing(relativeUrl);

        return relativeUrl + id + "/";
    }

    private String concatEndBackslashIfMissing(String url) {
        int lastBackslashIndex = url.lastIndexOf("/");

        if (lastBackslashIndex != url.length() - 1)
            url = url + "/";

        return url;
    }

    private String deleteTrailingBackslashIfExists(String url) {
        int indexFirstSlash = url.indexOf("/");

        if (indexFirstSlash == 0)
            url = url.substring(1);

        return url;
    }

    private String getQueryStrings(Map<?, ?> queryParameters) {
        if(queryParameters == null)
            return "";

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<?, ?> entry : queryParameters.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {

                if (sb.length() > 0) {
                    sb.append("&");
                }

                sb.append(String.format("%s=%s",
                        urlEncodeUTF8(entry.getKey().toString()),
                        urlEncodeUTF8(entry.getValue().toString())
                ));
            }
        }
        return sb.toString();
    }

    private static String urlEncodeUTF8(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }
}
