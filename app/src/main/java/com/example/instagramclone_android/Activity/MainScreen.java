package com.example.instagramclone_android.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.os.PersistableBundle;
import android.widget.ImageView;

import com.example.instagramclone_android.Fragments.ActivityPageFragment;
import com.example.instagramclone_android.Fragments.HomeFragment;
import com.example.instagramclone_android.Fragments.ProfileFragment;
import com.example.instagramclone_android.R;


public class MainScreen extends AppCompatActivity {
    public static final int DEFAULT_TAB_ID = -1;
    public static final int HOME_TAB_ID = 0;
    public static final int ADD_IMAGE_TAB_ID = 1;
    public static final int PROFILE_TAB_ID = 2;
    public static final int SEARCH_TAB_ID = 3;
    public static final int ACTIVITIES_TAB_ID = 4;
    private static final int UPLOAD_REQ = 1;
    private static final String CURRENT_STATE_TAG = "currentTabState";
    public static int currentTabState = DEFAULT_TAB_ID;
    public static String currentUserId;
    public static ContentResolver cr;
    public static PackageManager pm;
    public static MainScreen self;
    public static FragmentManager fm;
    private ImageView addButton, profileButton, homeButton, searchButton, activitiesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        initials();
        onClickListeners();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    private void initials() {
        self = this;
        pm = getPackageManager();
        cr = getContentResolver();
        fm = getSupportFragmentManager();
        addButton = findViewById(R.id.new_post);
        homeButton = findViewById(R.id.home_tab);
        profileButton = findViewById(R.id.profile_tab);
        searchButton = findViewById(R.id.search_tab);
        activitiesButton = findViewById(R.id.activity_tab);

        onHomeButtonClicked();

    }
    private void onClickListeners() {

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onHomeButtonClicked();
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (changeBackOtherImageResources(ADD_IMAGE_TAB_ID)) {
                    Intent intent = new Intent(MainScreen.this, NewPostScreen.class);
                    startActivityForResult(intent, 1);
                }
            }
        });
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (changeBackOtherImageResources(PROFILE_TAB_ID)) {
                    profileButton.setImageResource(R.drawable.profile_fill);
                    profileButton.setImageResource(R.drawable.profile_fill);
                    ProfileFragment profileFragment = ProfileFragment.newInstance();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, profileFragment).commit();
                }
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (changeBackOtherImageResources(SEARCH_TAB_ID)) {
                    searchButton.setImageResource(R.drawable.search_fill);
                   /* PersonalsFragment personalsFragment = PersonalsFragment.newInstance(PersonalFragmentType.SEARCH_FRAGMENT, null);
                    getSupportFragmentManager().beginTransaction().addToBackStack(null);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, personalsFragment).commit();*/
                }
            }
        });
        activitiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (changeBackOtherImageResources(ACTIVITIES_TAB_ID)) {
                    activitiesButton.setImageResource(R.drawable.likes_fill);
                    ActivityPageFragment activitypageFragment = ActivityPageFragment.newInstance();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, activitypageFragment).commit();
                }
            }
        });

    }
    public void onHomeButtonClicked() {
        if (changeBackOtherImageResources(HOME_TAB_ID)) {
            homeButton.setImageResource(R.drawable.home_fill);
            HomeFragment homeFragment = HomeFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, homeFragment).commit();
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt(CURRENT_STATE_TAG, currentTabState);
    }
    private boolean changeBackOtherImageResources(int pressedIconState) {
        int preTabState = currentTabState;
        currentTabState = pressedIconState;
        if (preTabState == currentTabState)
            return false;
        switch (preTabState) {
            case HOME_TAB_ID:
                homeButton.setImageResource(R.drawable.home_hollow);
                break;
            case ADD_IMAGE_TAB_ID:
//                addButton.setImageResource(R.drawable.plus_icon_stroke);
                break;
            case PROFILE_TAB_ID:
                profileButton.setImageResource(R.drawable.profile_hollow);
                break;
            case SEARCH_TAB_ID:
                searchButton.setImageResource(R.drawable.search_hollow);
                break;
            case ACTIVITIES_TAB_ID:
                activitiesButton.setImageResource(R.drawable.likes_hollow);
                break;
            default:
                break;
        }
        return true;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        currentTabState = -1;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case UPLOAD_REQ:
                if (requestCode == RESULT_OK) {

                }
                break;
        }
    }
}



