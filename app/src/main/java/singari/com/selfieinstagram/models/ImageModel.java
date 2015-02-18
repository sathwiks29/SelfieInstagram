package singari.com.selfieinstagram.models;

/**
 * Created by sathwiksingari on 2/11/15.
 */
public class ImageModel {

    private ImageDetailsModel low_resolution;

    private ImageDetailsModel thumbnail;

    private ImageDetailsModel standard_resolution;

    public ImageDetailsModel getLowResolution() {
        return low_resolution;
    }

    public ImageDetailsModel getThumbnail() {
        return thumbnail;
    }

    public ImageDetailsModel getStandardResolution() {
        return standard_resolution;
    }

}
