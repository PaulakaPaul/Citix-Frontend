package europe.dev.citix.citix.api.utils;

import android.text.TextUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class RequestUtils {

    private String baseUrl;

    public RequestUtils(String baseUrl){
        this.baseUrl = baseUrl;
    }

    public String getFullUrl(String relativeUrl) {
        return getFullUrl(relativeUrl, null);
    }

    public String getFullUrl(String relativeUrl, Map<?, ?> queryParameters) {
        String absoluteURL = baseUrl + relativeUrl;

        if(queryParameters == null)
            return absoluteURL;

        String stringQueryParameters = getQueryStrings(queryParameters);
        if(TextUtils.isEmpty(stringQueryParameters))
            return absoluteURL;

        return absoluteURL + "?" + getQueryStrings(queryParameters);
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
