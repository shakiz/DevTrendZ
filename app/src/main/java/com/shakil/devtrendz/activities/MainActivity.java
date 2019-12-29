package com.shakil.devtrendz.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.shakil.devtrendz.R;
import com.shakil.devtrendz.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this , R.layout.activity_main);

        setSupportActionBar(activityMainBinding.toolBar);


        init();
        bindUIWithComponents();
    }


    private void init() {

    }

    private void bindUIWithComponents() {
        activityMainBinding.toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitApp();
            }
        });
    }

    public void exitApp(){
        Intent exitIntent = new Intent(Intent.ACTION_MAIN);
        exitIntent.addCategory(Intent.CATEGORY_HOME);
        exitIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(exitIntent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        exitApp();
    }
}
