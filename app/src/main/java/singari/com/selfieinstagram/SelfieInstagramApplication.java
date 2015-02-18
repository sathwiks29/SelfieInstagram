package singari.com.selfieinstagram;

import android.app.Application;

public class SelfieInstagramApplication extends Application {

    private static SessionManager sessionManager;

    @Override
    public void onCreate() {
        super.onCreate();
        sessionManager = new SessionManager(getApplicationContext());
    }

    public static SessionManager getSessionManager() {
        return sessionManager;
    }
}
