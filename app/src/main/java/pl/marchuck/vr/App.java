package pl.marchuck.vr;

import android.app.Application;
import android.os.StrictMode;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;


import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.GINGERBREAD;

/**
 * @author Lukasz Marczak
 * @since 09.08.16.
 */
public class App extends Application {
    public static final String TAG = App.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        if (SDK_INT >= GINGERBREAD) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder() //
                    .detectAll() //
                    .penaltyLog() //
                    .penaltyDeath() //
                    .build());
        }
        LeakCanary.install(this);
    }


}
