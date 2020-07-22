package com.example.instagramclone_android.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclone_android.Adapters.ActivityPageAdapter;
import com.example.instagramclone_android.Adapters.PostAdapter;
import com.example.instagramclone_android.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ActivityPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActivityPageFragment extends Fragment {
    private RecyclerView recycler_view_activitypage;

    public ActivityPageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ActivityPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ActivityPageFragment newInstance() {
        ActivityPageFragment fragment = new ActivityPageFragment();
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
        String[] usernames = {"gaurav","nihar","kunal","ajinkya","sakshi","nikita","aaditya","sandeep","mihir","srushti","vidya","mrudu","rutuja","saish","vedika","sakshee"};
        View view = inflater.inflate(R.layout.fragment_activity_page, container, false);
        recycler_view_activitypage = view.findViewById(R.id.recycler_view_activitypage);
        recycler_view_activitypage.setHasFixedSize(true);
        recycler_view_activitypage.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
        recycler_view_activitypage.setAdapter(new ActivityPageAdapter(usernames));
        return view;
    }
}