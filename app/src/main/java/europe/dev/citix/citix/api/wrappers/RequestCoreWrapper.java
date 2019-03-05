package europe.dev.citix.citix.api.wrappers;



import europe.dev.citix.citix.api.core.*;

public class RequestCoreWrapper extends AbstractRequest{

    private static final String CITIX_API_BASE_URL = "http://52.29.116.16:8000/api/";

    public RequestCoreWrapper(String tag) {
        super(CITIX_API_BASE_URL, tag);
    }




}
