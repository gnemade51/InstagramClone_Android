package com.example.instagramclone_android.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instagramclone_android.Adapters.PostAdapter;
import com.example.instagramclone_android.R;
import com.example.instagramclone_android.Adapters.StoryAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private RecyclerView recycler_view_story_section, recycler_view_post_section;


    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recycler_view_story_section = view.findViewById(R.id.recycler_view_story_section);
        recycler_view_story_section.setHasFixedSize(true);
        recycler_view_story_section.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        String[] usernames = {"gaurav","nihar","kunal","ajinkya","sakshi","nikita","aaditya","sandeep","mihir"};
        recycler_view_story_section.setAdapter(new StoryAdapter(usernames));

        recycler_view_post_section = view.findViewById(R.id.recycler_view_post_section);
        recycler_view_post_section.setHasFixedSize(true);
        recycler_view_post_section.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
        recycler_view_post_section.setAdapter(new PostAdapter(usernames));
        return view;
    }
}