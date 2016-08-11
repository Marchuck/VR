package pl.marchuck.vr;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.github.pwittchen.swipe.library.Swipe;
import com.github.pwittchen.swipe.library.SwipeListener;
import com.threed.jpct.Logger;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static android.widget.RelativeLayout.CENTER_HORIZONTAL;
import static android.widget.RelativeLayout.CENTER_IN_PARENT;
import static android.widget.RelativeLayout.LayoutParams.WRAP_CONTENT;

public class ARActivity extends AppCompatActivity implements OpenGLProxy, OpenGLHelper.ProgressIndicator {
    public static final String TAG = ARActivity.class.getSimpleName();

    private GLSurfaceView glSurfaceView;
    private ProgressBar progressBar;
    private OpenGLHelper openGLHelper;

    private Swipe swipe = new Swipe();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        glSurfaceView = new GLSurfaceView(this);
        openGLHelper = new OpenGLHelper(this);
        swipe.addListener(new SwipeCharacterListener(openGLHelper));
        RelativeLayout relativeLayout = new RelativeLayout(this);

      //  Button btn = new Button(this);
     //   btn.setText("switch");
     //   btn.setOnClickListener(openGLHelper);
        RelativeLayout.LayoutParams paramsForBtn = new RelativeLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);

        paramsForBtn.addRule(CENTER_HORIZONTAL);

        progressBar = new ProgressBar(this);
        openGLHelper.setProgressIndicator(this);
        RelativeLayout.LayoutParams paramsForProgress = new RelativeLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);

        paramsForProgress.addRule(CENTER_IN_PARENT);
        progressBar.setLayoutParams(paramsForProgress);
        progressBar.setVisibility(GONE);
     //   btn.setLayoutParams(paramsForBtn);

        relativeLayout.addView(glSurfaceView);
        relativeLayout.addView(progressBar);
     //   relativeLayout.addView(btn);
        setContentView(relativeLayout);
    }

    @Override public boolean dispatchTouchEvent(MotionEvent event) {
        swipe.dispatchTouchEvent(event);
        return super.dispatchTouchEvent(event);
    }

    @Override
    protected void onPause() {
        glSurfaceView.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        glSurfaceView.onResume();
    }

    @Override
    public boolean onTouchEvent(MotionEvent me) {
        return openGLHelper.onTouchEvent(me);
    }

    @Override
    public GLSurfaceView getSurfaceView() {
        return glSurfaceView;
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(GONE);
    }
}
