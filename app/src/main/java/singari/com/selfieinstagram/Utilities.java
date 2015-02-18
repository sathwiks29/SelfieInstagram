package singari.com.selfieinstagram;

import android.content.Context;
import android.widget.Toast;

public class Utilities {

    public static void displayToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

}
