package com.example.instagramclone_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainScreen extends AppCompatActivity {
    LinearLayout main_screen_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main_screen);
        RecyclerView recycler_view_story_section = (RecyclerView) findViewById(R.id.recycler_view_story_section);
        recycler_view_story_section.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        String[] usernames = {"gaurav","nihar","kunal","ajinkya","sakshi","nikita","aaditya","sandeep","mihir"};
        recycler_view_story_section.setAdapter(new StoryAdapter(usernames));


    }


}

