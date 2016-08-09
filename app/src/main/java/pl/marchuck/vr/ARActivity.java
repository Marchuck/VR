package pl.marchuck.vr;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.threed.jpct.Logger;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static android.widget.RelativeLayout.CENTER_IN_PARENT;
import static android.widget.RelativeLayout.CENTER_HORIZONTAL;
import static android.widget.RelativeLayout.LayoutParams.WRAP_CONTENT;

;

public class ARActivity extends AppCompatActivity implements OpenGLProxy, OpenGLHelper.ProgressIndicator {
    public static final String TAG = ARActivity.class.getSimpleName();

    private GLSurfaceView mGLView;
    private ProgressBar progressBar;
    private OpenGLHelper openGLHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Logger.log("onCreate");
        super.onCreate(savedInstanceState);
        //copy(this);
        mGLView = new GLSurfaceView(this);
        openGLHelper = new OpenGLHelper(this);

        RelativeLayout relativeLayout = new RelativeLayout(this);

        Button btn = new Button(this);
        btn.setText("switch");
        btn.setOnClickListener(openGLHelper);
        RelativeLayout.LayoutParams paramsForBtn = new RelativeLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);

        paramsForBtn.addRule(CENTER_HORIZONTAL);

        progressBar = new ProgressBar(this);
        openGLHelper.setProgressIndicator(this);
        RelativeLayout.LayoutParams paramsForProgress = new RelativeLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);

        paramsForProgress.addRule(CENTER_IN_PARENT);
        progressBar.setLayoutParams(paramsForProgress);
        btn.setLayoutParams(paramsForBtn);

        relativeLayout.addView(mGLView);
        relativeLayout.addView(progressBar);
        relativeLayout.addView(btn);
        setContentView(relativeLayout);

    }

    @Override
    public boolean onTouchEvent(MotionEvent me) {
        return openGLHelper.onTouchEvent(me);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public GLSurfaceView getSurfaceView() {
        return mGLView;
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
