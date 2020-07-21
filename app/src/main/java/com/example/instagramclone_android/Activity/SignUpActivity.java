package com.example.instagramclone_android.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.instagramclone_android.R;

public class SignUpActivity extends AppCompatActivity {
    private static final int SIGN_UP_REQUEST_CODE = 1;
    private Button signUp;
    private TextView login;
    private LinearLayout facebook1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initials();
        clickListeners();
    }
    private void initials() {
        login = findViewById(R.id.login_text);
        signUp = findViewById(R.id.signup_button);
        facebook1 = findViewById(R.id.fb1);
    }
    private void clickListeners() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginScreen.class);
                startActivityForResult(intent, 1);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, MainScreen.class);
                startActivityForResult(intent, 1);
            }
        });
        facebook1.setOnClickListener(new View.OnClickListener() {

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