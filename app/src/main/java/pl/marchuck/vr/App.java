package pl.marchuck.vr;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * @author Lukasz Marczak
 * @since 09.08.16.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        LeakCanary.install(this);
    }
}
