package europe.dev.citix.citix.api.core;


import java.util.Map;

public class RequestCoreWrapper extends AbstractRequest{

    //private static final String CITIX_API_BASE_URL = "http://52.29.116.16:8000/api/";
    private static final String CITIX_API_BASE_URL = " http://bd7f2850.ngrok.io/api/";

    protected Map<String, String> header;

    public RequestCoreWrapper(String tag, String auth_token) {
        super(CITIX_API_BASE_URL, tag);

        header = AbstractRequest.mRequestUtils.computeHeader(auth_token);
    }
}
