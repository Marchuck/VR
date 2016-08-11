package pl.marchuck.vr;

import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;

import com.github.pwittchen.swipe.library.SwipeListener;

/**
 * @author Lukasz Marczak
 * @since 11.08.16.
 */
public class SwipeCharacterListener implements SwipeListener {
    public static final String TAG = SwipeCharacterListener.class.getSimpleName();

    @Nullable
    private Changeable changeable;

    public SwipeCharacterListener(@Nullable Changeable changeable) {
        this.changeable = changeable;
    }

    @Override
    public void onSwipingLeft(MotionEvent event) {
        Log.d(TAG, "onSwipingLeft: ");
    }

    @Override
    public void onSwipedLeft(MotionEvent event) {
        Log.d(TAG, "onSwipedLeft: ");
        if (changeable != null) changeable.onChange(changeable.getLastChange() == 0 ? 1 : 0);
    }

    @Override
    public void onSwipingRight(MotionEvent event) {
        Log.d(TAG, "onSwipingRight: ");
    }

    @Override
    public void onSwipedRight(MotionEvent event) {
        Log.d(TAG, "onSwipedRight: ");
        if (changeable != null) changeable.onChange(changeable.getLastChange() == 0 ? 2 : 0);
    }

    @Override
    public void onSwipingUp(MotionEvent event) {

    }

    @Override
    public void onSwipedUp(MotionEvent event) {

    }

    @Override
    public void onSwipingDown(MotionEvent event) {

    }

    @Override
    public void onSwipedDown(MotionEvent event) {

    }
}
