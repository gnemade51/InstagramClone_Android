package com.example.instagramclone_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
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
        Fragment home_fragment;
        home_fragment = new HomeFragment();
        loadFragment(home_fragment);
    }
    private void loadFragment(Fragment home_fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //frame_container is your layout name in xml file
        transaction.replace(R.id.fragment_container, home_fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}

