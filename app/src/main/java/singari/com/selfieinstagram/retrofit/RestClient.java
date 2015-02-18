package singari.com.selfieinstagram.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class RestClient {

    public static final String ENDPOINT_ACCESS_CODE = "https://api.instagram.com/oauth";
    public static final String ENDPOINT = "https://api.instagram.com/v1";
    private InstagramAPI apiService;

    public RestClient(String ENDPOINT) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();

        RestAdapter restAdapterGen = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(ENDPOINT)
                .setConverter(new GsonConverter(gson))
                .build();

        apiService = restAdapterGen.create(InstagramAPI.class);
    }

    public InstagramAPI getApiService() {
        return apiService;
    }
}
