package singari.com.selfieinstagram.retrofit;

import android.content.Context;
import android.util.Log;

import retrofit.RetrofitError;
import singari.com.selfieinstagram.R;
import singari.com.selfieinstagram.Utilities;

/**
 * Created by Sathwik on 2/11/2015.
 */
public class GlobalErrorHelper {

    public static void handleError(Context context, RetrofitError retrofitError, boolean showToast) {
        if (retrofitError.getKind() == RetrofitError.Kind.NETWORK) {
            Utilities.displayToast(context, context.getString(R.string.network_error));
        } else {
            if (retrofitError.getResponse() != null) {
                InstagramError instagramError = (InstagramError) retrofitError.getBodyAs(InstagramError.class);
                Utilities.displayToast(context, instagramError.getError_message());
            }

        }

    }

}
