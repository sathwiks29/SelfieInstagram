package singari.com.selfieinstagram.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;

import singari.com.selfieinstagram.SelfieInstagramApplication;
import singari.com.selfieinstagram.SessionManager;
import singari.com.selfieinstagram.retrofit.InstagramAPI;
import singari.com.selfieinstagram.retrofit.RestClient;

public class BaseActivity extends ActionBarActivity {
    SessionManager sessionManager;
    InstagramAPI instagramAPI;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManager = SelfieInstagramApplication.getSessionManager();
        instagramAPI = new RestClient(RestClient.ENDPOINT).getApiService();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }
}
