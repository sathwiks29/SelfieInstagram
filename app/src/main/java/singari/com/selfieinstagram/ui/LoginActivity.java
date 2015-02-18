package singari.com.selfieinstagram.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import singari.com.selfieinstagram.Constants;
import singari.com.selfieinstagram.R;
import singari.com.selfieinstagram.models.LoginModel;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    @InjectView(R.id.btnLogin)
    Button mBtnLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (sessionManager.isLoggedIn()) {
            Intent intent = new Intent(this, GridActivty.class);
            startActivity(intent);
            finish();
        }
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        mBtnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mBtnLogin) {
            Intent intent = new Intent(this, WebViewActivity.class);
            startActivityForResult(intent, Constants.LOGIN_REQ_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.LOGIN_REQ_CODE) {
            if (resultCode == RESULT_OK) {
                sessionManager.createLoginSession((LoginModel) data.getSerializableExtra(Constants.LOGIN_MODEL));
                Intent intent = new Intent(this, GridActivty.class);
                startActivity(intent);
                finish();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
