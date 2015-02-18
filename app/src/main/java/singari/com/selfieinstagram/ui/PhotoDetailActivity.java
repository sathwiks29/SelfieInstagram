package singari.com.selfieinstagram.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import singari.com.selfieinstagram.R;

public class PhotoDetailActivity extends ActionBarActivity {

    @InjectView(R.id.imgMedia)
    SquareImageView mImgMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);
        ButterKnife.inject(this);
        Picasso.with(this).load(getIntent().getStringExtra("url")).into(mImgMedia);
    }

}
