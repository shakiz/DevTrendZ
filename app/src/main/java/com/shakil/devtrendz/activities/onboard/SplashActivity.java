package com.shakil.devtrendz.activities.onboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.shakil.devtrendz.R;
import com.shakil.devtrendz.activities.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();
        bindUIWithComponents();
    }

    private void init() {

    }

    private void bindUIWithComponents() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        }, 1400);
    }
}
