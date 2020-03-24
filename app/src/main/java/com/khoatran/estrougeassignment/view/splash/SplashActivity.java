package com.khoatran.estrougeassignment.view.splash;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

import com.khoatran.estrougeassignment.R;
import com.khoatran.estrougeassignment.view.BaseActivity;
import com.khoatran.estrougeassignment.view.main.MainActivity;

public class SplashActivity extends BaseActivity {

    // Duration of wait
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* New Handler to start the Main-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(() -> {
            MainActivity.start(SplashActivity.this);
            SplashActivity.this.finish();
        }, SPLASH_DISPLAY_LENGTH);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_splash;
    }

    @Override
    public Context context() {
        return this;
    }
}