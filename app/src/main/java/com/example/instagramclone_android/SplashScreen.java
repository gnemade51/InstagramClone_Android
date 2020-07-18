package com.example.instagramclone_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

public class SplashScreen extends AppCompatActivity {
    LinearLayout splash_screen_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_splash_screen);
        splash_screen_layout=(LinearLayout)findViewById(R.id.splash_screen_layout);
        splash_screen_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(SplashScreen.this,LoginScreen.class);
                startActivity(intent);

            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(SplashScreen.this,LoginScreen.class);
                startActivity(intent);

            }
        }, 3000);
    }
}