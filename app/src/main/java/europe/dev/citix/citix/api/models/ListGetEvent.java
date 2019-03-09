package europe.dev.citix.citix.api.models;

import java.util.List;

public class ListGetEvent extends ListGet<GetEvent> {
    public ListGetEvent(int count, List<GetEvent> results, int page_size, Pages pages) {
        super(count, results, page_size, pages);
    }
}
