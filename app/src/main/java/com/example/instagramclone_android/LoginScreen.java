package com.example.instagramclone_android;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LoginScreen extends AppCompatActivity {
    private static final int SIGN_UP_REQUEST_CODE = 1;
    private Button login;
    private TextView signUp;
    private LinearLayout facebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        initials();
        clickListeners();
    }
    private void initials() {
        signUp = findViewById(R.id.signup_text);
        login = findViewById(R.id.login_button);
        facebook = findViewById(R.id.fb);
    }
    private void clickListeners() {
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreen.this, SignUpActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreen.this, MainScreen.class);
                startActivityForResult(intent, 1);
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Uri uri = Uri.parse("http://facebook.com/");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SIGN_UP_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK)
                finish();
        }
    }
}