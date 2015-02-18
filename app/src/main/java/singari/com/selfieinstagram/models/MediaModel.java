package singari.com.selfieinstagram.models;

import java.util.List;

/**
 * Created by sathwiksingari on 2/11/15.
 */
public class MediaModel {

    private List<String> tags;

    private String type;

    private String filter;

    private String created_time;

    private String link;

    private ImageModel images;

    private UserModel user;

    public List<String> getTags() {
        return tags;
    }

    public String getType() {
        return type;
    }

    public String getFilter() {
        return filter;
    }

    public String getCreatedTime() {
        return created_time;
    }

    public String getLink() {
        return link;
    }

    public ImageModel getImages() {
        return images;
    }

    public UserModel getUser() {
        return user;
    }

}
