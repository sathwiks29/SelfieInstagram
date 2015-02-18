package singari.com.selfieinstagram;

public class Constants {

    public static final String CLIENT_ID = "02c86b5fe4a648a0a6a47966a7bac9cb";
    public static final String CLIENT_SECRET = "462ce4e3aea0445c93b4223d4ad86b75";
    public static final String REDIRECT_URI = "https://www.google.com";
    public static final String CODE = "code";
    public static final String GRANT_TYPE = "authorization_code";
    public static final String AUTH_URL = "https://api.instagram.com/oauth/authorize/?client_id="+CLIENT_ID+"&redirect_uri="+REDIRECT_URI+"&response_type="+CODE;

    //Request Codes
    public static final int LOGIN_REQ_CODE = 100;

    //Keys
    public static final String LOGIN_MODEL = "login_model";

}
