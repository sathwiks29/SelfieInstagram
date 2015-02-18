package singari.com.selfieinstagram.models;

import java.util.List;

/**
 * Created by sathwiksingari on 2/11/15.
 */
public class MediaSearchModel {
    private PaginationModel pagination;

    private List<MediaModel> data;

    public PaginationModel getPagination() {
        return pagination;
    }

    public List<MediaModel> getData() {
        return data;
    }
}
