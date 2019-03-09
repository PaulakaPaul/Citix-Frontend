package europe.dev.citix.citix.api.models;

import java.util.List;

public class ListGet<T> {
    private int count;
    private List<T> results;
    private int page_size;
    private Pages pages;

    public ListGet(int count, List<T> results, int page_size, Pages pages) {
        this.count = count;
        this.results = results;
        this.page_size = page_size;
        this.pages = pages;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }

    public Pages getPages() {
        return pages;
    }

    public void setPages(Pages pages) {
        this.pages = pages;
    }
}
