package singari.com.selfieinstagram.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import singari.com.selfieinstagram.Constants;
import singari.com.selfieinstagram.MediaAdapter;
import singari.com.selfieinstagram.R;
import singari.com.selfieinstagram.models.LoginModel;
import singari.com.selfieinstagram.models.MediaModel;
import singari.com.selfieinstagram.models.MediaSearchModel;
import singari.com.selfieinstagram.models.UserModel;
import singari.com.selfieinstagram.retrofit.GlobalErrorHelper;


public class GridActivty extends BaseActivity {

    @InjectView(R.id.tvUsername)
    TextView mTvUsername;
    @InjectView(R.id.gridView)
    GridView mGridView;

    UserModel userModel;
    private String tag = "selfie";
    private MediaAdapter adapter;
    private ProgressDialog progressDialog;
    private List<MediaModel> mediaModels;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_activty);
        ButterKnife.inject(this);
        userModel = sessionManager.getUserDetails();
        mTvUsername.setText(getString(R.string.welcome_user, userModel.getUsername()));

        doServiceCallForMedia(tag);
    }

    private void doServiceCallForMedia(String tag) {
        progressDialog = ProgressDialog.show(this, "", "Loading #selfies. Please wait...", true);
        instagramAPI.getTagMediaRecent(tag, sessionManager.getAccessToken(), new Callback<MediaSearchModel>() {
            @Override
            public void success(MediaSearchModel mediaSearchModel, Response response) {
                adapter = new MediaAdapter(GridActivty.this, mediaSearchModel.getData());
                mGridView.setAdapter(adapter);
                mGridView.setVisibility(View.VISIBLE);
                progressDialog.dismiss();
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                mGridView.setVisibility(View.GONE);
                GlobalErrorHelper.handleError(GridActivty.this, retrofitError, true);
                progressDialog.dismiss();
            }
        });
    }


}
