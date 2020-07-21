package com.example.instagramclone_android.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclone_android.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    @NonNull
    private String[] data;
    public PostAdapter(String[] data)
    {
        this.data = data;
    }
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        String username = data[position];
        holder.postUsername.setText(username);
        holder.postDescUsername.setText(username);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        CircleImageView postProfile;
        TextView postUsername, postLikes, postDescUsername, postDescription, postDate;
        ImageView postImage;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            postProfile = (CircleImageView) itemView.findViewById(R.id.post_profile_image);
            postUsername = (TextView) itemView.findViewById(R.id.post_username);
            postImage = (ImageView) itemView.findViewById(R.id.post_image);
            postLikes = (TextView) itemView.findViewById(R.id.post_likes);
            postDescUsername = (TextView) itemView.findViewById(R.id.description_username);
            postDescription = (TextView) itemView.findViewById(R.id.description);
            postDate = (TextView) itemView.findViewById(R.id.date);
        }
    }
}
