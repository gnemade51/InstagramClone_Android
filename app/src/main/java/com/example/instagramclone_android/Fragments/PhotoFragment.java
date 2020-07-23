package com.example.instagramclone_android.Fragments;

import android.hardware.Camera;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import com.example.instagramclone_android.R;
import com.example.instagramclone_android.Utils.ShowCamera;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PhotoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhotoFragment extends Fragment {
    Camera camera;
    FrameLayout frameLayout;
    ShowCamera showCamera;

    public PhotoFragment() {
        // Required empty public constructor
    }

    public static PhotoFragment newInstance() {
        PhotoFragment fragment = new PhotoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_photo, container, false);
        frameLayout = (FrameLayout) view.findViewById(R.id.camera_container);
        //open the camera
        camera = Camera.open();
        showCamera = new ShowCamera(getActivity(),camera);
        frameLayout.addView(showCamera);
        return view;
    }
}