package singari.com.selfieinstagram.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import singari.com.selfieinstagram.Constants;
import singari.com.selfieinstagram.R;
import singari.com.selfieinstagram.models.LoginModel;
import singari.com.selfieinstagram.retrofit.GlobalErrorHelper;
import singari.com.selfieinstagram.retrofit.RestClient;

public class WebViewActivity extends ActionBarActivity {

    public static final String LOGTAG = "WebViewActivity";
    @InjectView(R.id.webView)
    WebView mWebView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.inject(this);
        mWebView.setWebViewClient(new CustomWebViewClient());
        mWebView.loadUrl(Constants.AUTH_URL);

    }

    private class CustomWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d(LOGTAG, url);
            if (url.startsWith(Constants.REDIRECT_URI)) {
                Uri uri = Uri.parse(url);
                String code = uri.getQueryParameter(Constants.CODE);

                if (code != null) {
                    new RestClient(RestClient.ENDPOINT_ACCESS_CODE).getApiService().getAccessCode(Constants.CLIENT_ID, Constants.CLIENT_SECRET, Constants.GRANT_TYPE, Constants.REDIRECT_URI, code, new Callback<LoginModel>() {
                        @Override
                        public void success(LoginModel loginModel, Response response) {
                            Intent result = new Intent();
                            result.putExtra(Constants.LOGIN_MODEL, loginModel);
                            setResult(RESULT_OK, result);
                            finish();
                        }

                        @Override
                        public void failure(RetrofitError retrofitError) {
                            GlobalErrorHelper.handleError(WebViewActivity.this, retrofitError, true);
                            setResult(RESULT_CANCELED);
                            finish();
                        }
                    });
                }

            }
            return super.shouldOverrideUrlLoading(view, url);
        }

    }

}
