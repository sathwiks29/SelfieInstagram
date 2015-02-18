package singari.com.selfieinstagram.models;

import java.io.Serializable;

/**
 * Created by sathwiksingari on 2/11/15.
 */
public class LoginModel extends BaseModel implements Serializable {

    private String access_token;

    private UserModel user;

    public String getAccess_token() {
        return access_token;
    }

    public UserModel getUser() {
        return user;
    }

}
