package com.example.instagramclone_android.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclone_android.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {
    @NonNull
    private String[] data;
    public StoryAdapter(String[] data)
    {
        this.data = data;
    }
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_story,parent,false);

        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {
        String username = data[position];
        holder.storyUsername.setText(username);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class StoryViewHolder extends RecyclerView.ViewHolder {
        CircleImageView storyImage;
        TextView storyUsername;
        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            storyImage = (CircleImageView) itemView.findViewById(R.id.story_circle_image);
            storyUsername = (TextView) itemView.findViewById(R.id.story_user_name);
        }
    }
}
