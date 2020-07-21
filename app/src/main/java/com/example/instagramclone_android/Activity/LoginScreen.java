package com.example.instagramclone_android.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.instagramclone_android.R;

public class LoginScreen extends AppCompatActivity {
    private static final int SIGN_UP_REQUEST_CODE = 1;
    private Button login;
    private TextView signUp;
    private LinearLayout facebook;
    private EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        initials();
        clickListeners();
    }
    private void initials() {
        username = findViewById(R.id.login_username);
        password = findViewById(R.id.login_password);
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
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (isCorrect(user, pass)) {
                    Toast.makeText(LoginScreen.this, "User Successfully Logged in", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginScreen.this, MainScreen.class);
                    startActivityForResult(intent, 1);
                    finish();
                }else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Username or Password is wrong!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 200);
                    toast.show();
                }

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
    private boolean isCorrect(String user, String pass) {
        if (user.equals("itachi") && pass.equals("uchiha69")){
            return true;
        } else {
            return false;
        }
    }
}