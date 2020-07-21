package com.example.instagramclone_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainScreen extends AppCompatActivity {
    LinearLayout main_screen_layout;
    ImageView ib1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main_screen);
        RecyclerView recycler_view_story_section = (RecyclerView) findViewById(R.id.recycler_view_story_section);
        recycler_view_story_section.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        String[] usernames = {"gaurav", "nihar", "kunal", "ajinkya", "sakshi", "nikita", "aaditya", "sandeep", "mihir"};
        recycler_view_story_section.setAdapter(new StoryAdapter(usernames));

        RecyclerView recycler_view_post_section = (RecyclerView) findViewById(R.id.recycler_view_post_section);
        recycler_view_post_section.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler_view_post_section.setAdapter(new PostAdapter(usernames));


        ib1 = (ImageView) findViewById(R.id.camera);

        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainScreen.this, CameraScreen.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }
}



