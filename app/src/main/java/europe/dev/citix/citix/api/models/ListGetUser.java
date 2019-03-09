package europe.dev.citix.citix.api.models;

import java.util.List;

public class ListGetUser extends ListGet<GetUser> {

    public ListGetUser(int count, List<GetUser> results, int page_size, Pages pages) {
        super(count, results, page_size, pages);
    }

}
