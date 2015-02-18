package singari.com.selfieinstagram.retrofit;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import singari.com.selfieinstagram.models.LoginModel;
import singari.com.selfieinstagram.models.MediaSearchModel;

public interface InstagramAPI {

    @FormUrlEncoded
    @POST("/access_token")
    public void getAccessCode(@Field("client_id") String client_id, @Field("client_secret") String client_secret, @Field("grant_type") String grant_type, @Field("redirect_uri") String redirect_uri, @Field("code") String code, Callback<LoginModel> model);

    @GET("/tags/{tag_name}/media/recent")
    public void getTagMediaRecent(@Path("tag_name") String tag_name, @Query("access_token") String access_token, Callback<MediaSearchModel> model);
}
