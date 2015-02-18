package singari.com.selfieinstagram.models;

import java.io.Serializable;

/**
 * Created by sathwiksingari on 2/11/15.
 */
public class UserModel implements Serializable {

    private String id;

    private String username;

    private String full_name;

    private String profile_picture;

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return full_name;
    }

    public String getProfilePicture() {
        return profile_picture;
    }

}
