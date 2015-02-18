package singari.com.selfieinstagram.retrofit;

import singari.com.selfieinstagram.models.MetaModel;

/**
 * Created by Sathwik on 2/11/2015.
 */
public class InstagramError extends MetaModel{

    private String error_type;

    private String error_message;

    public String getError_message() {
        return error_message;
    }

    public String getError_type() {
        return error_type;
    }

}
