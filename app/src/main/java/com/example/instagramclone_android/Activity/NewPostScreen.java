package com.example.instagramclone_android.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.instagramclone_android.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class NewPostScreen extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post_screen);

        imageView = (ImageView) this.findViewById(R.id.imageView1);
        TabItem photoButton = (TabItem) this.findViewById(R.id.photo_tab);

        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }
}

