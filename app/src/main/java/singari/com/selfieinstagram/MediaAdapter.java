package singari.com.selfieinstagram;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import java.util.List;
import butterknife.ButterKnife;
import butterknife.InjectView;
import singari.com.selfieinstagram.models.MediaModel;
import singari.com.selfieinstagram.ui.PhotoDetailActivity;

public class MediaAdapter extends BaseAdapter {

    private final int VIEW_COUNT = 2;
    private final int LAYOUT_BIG = 0;
    private final int LAYOUT_SMALL = 1;
    private final String VIDEO = "video";
    private Context mContext;
    private List<MediaModel> mediaModels;
    private LayoutInflater mInflator;

    public MediaAdapter(Context mContext, List<MediaModel> mediaModels) {
        this.mContext = mContext;
        this.mediaModels = mediaModels;
        mInflator = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mediaModels.size();
    }

    @Override
    public Object getItem(int position) {
        return mediaModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 || position%3 == 0) {
            return LAYOUT_BIG;
        } else {
            return LAYOUT_SMALL;
        }
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_COUNT;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       switch (getItemViewType(position)) {
           case LAYOUT_BIG:
               MediaHolderBig holderBig = null;
               if (convertView == null) {
                   convertView = mInflator.inflate(R.layout.item_media_big, null);
                   holderBig = new MediaHolderBig(convertView);
                   convertView.setTag(holderBig);
               } else {
                   holderBig = (MediaHolderBig) convertView.getTag();
               }
               fillHolder(holderBig, position);
               break;

           case LAYOUT_SMALL:
               MediaHolderSmall holderSmall = null;
               if (convertView == null) {
                   convertView = mInflator.inflate(R.layout.item_media_small, null);
                   holderSmall = new MediaHolderSmall(convertView);
                   convertView.setTag(holderSmall);
               } else {
                   holderSmall = (MediaHolderSmall) convertView.getTag();
               }
               fillHolder(holderSmall, position);
               break;
       }

        return convertView;
    }

    private void fillHolder(MediaHolderBig holder, int position) {
        MediaModel mediaModel = mediaModels.get(position);
        Picasso.with(mContext).load(mediaModel.getImages().getThumbnail().getUrl()).into(holder.mImgMediaThumbnail);
        holder.mImgMediaThumbnail.setTag(mediaModel.getImages().getStandardResolution().getUrl());
        holder.mImgMediaThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PhotoDetailActivity.class);
                intent.putExtra("url", (String) v.getTag());
                mContext.startActivity(intent);
            }
        });
    }

    private void fillHolder(MediaHolderSmall holder, int position) {
        MediaModel mediaModel = mediaModels.get(position);
        Picasso.with(mContext).load(mediaModel.getImages().getThumbnail().getUrl()).into(holder.mImgMediaThumbnail);
        holder.mImgMediaThumbnail.setTag(mediaModel.getImages().getStandardResolution().getUrl());
        holder.mImgMediaThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PhotoDetailActivity.class);
                intent.putExtra("url", (String) v.getTag());
                mContext.startActivity(intent);
            }
        });
    }

    static class MediaHolderBig {

        @InjectView(R.id.imgMediaThumbnail)
        ImageView mImgMediaThumbnail;
        MediaHolderBig(View view) {
            ButterKnife.inject(this, view);
        }
    }

    static class MediaHolderSmall {

        @InjectView(R.id.imgMediaThumbnail)
        ImageView mImgMediaThumbnail;

        MediaHolderSmall(View view) {
            ButterKnife.inject(this, view);
        }
    }

}
