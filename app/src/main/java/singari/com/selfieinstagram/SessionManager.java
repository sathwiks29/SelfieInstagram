package singari.com.selfieinstagram;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;

import singari.com.selfieinstagram.models.LoginModel;
import singari.com.selfieinstagram.models.UserModel;

public class SessionManager {

    private static final String LOGTAG = "SessionManager";

    private static final String PREFS_FILE_NAME = "USER_PREFS";

    private static final String LOGIN = "login";

    private static final int PRIVATE_MODE = 0;

    SharedPreferences prefs;

    Context context;

    public SessionManager(Context context){
        this.context = context;
        prefs = context.getSharedPreferences(PREFS_FILE_NAME, PRIVATE_MODE);
    }

    public void createLoginSession(LoginModel loginModel) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(LOGIN,  new Gson().toJson(loginModel));
        editor.commit();
    }

    public void setCode(String code) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("code",  code);
        editor.commit();
    }

    public LoginModel getLoginDetails() {
        LoginModel loginModel = null;
        String json = prefs.getString(LOGIN, null);

        Log.d(LOGTAG, "sharedPrefs json = " + json);

        if (json != null) {
            loginModel = new Gson().fromJson(json, LoginModel.class);
        }

        return loginModel;
    }

    public UserModel getUserDetails() {
        UserModel user = null;
        if (getLoginDetails() != null) {
            user = getLoginDetails().getUser();
        }
        return user;
    }

    public String getAccessToken() {
        String token = null;
        if (getLoginDetails() != null) {
            token = getLoginDetails().getAccess_token();
        }
        return token;
    }

    public boolean isLoggedIn() {
        return prefs.contains(LOGIN);
    }

}
