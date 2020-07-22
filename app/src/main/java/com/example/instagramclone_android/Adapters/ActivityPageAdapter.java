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

public class ActivityPageAdapter extends RecyclerView.Adapter<ActivityPageAdapter.ActivityPageViewHolder> {
    private String[] data;

    public ActivityPageAdapter(String[] data) {
        this.data = data;
    }
    @Override
    public ActivityPageAdapter.ActivityPageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_like_notification, parent, false);
        return new ActivityPageAdapter.ActivityPageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityPageViewHolder holder, int position) {
        String username = data[position];
        holder.activityUsername.setText(username);
    }


    @Override
    public int getItemCount() {
        return data.length;
    }
    public class ActivityPageViewHolder extends RecyclerView.ViewHolder {
        CircleImageView activityDp;
        TextView activityUsername, activityDescription;
        ImageView activityImage;
        public ActivityPageViewHolder(@NonNull View itemView) {
            super(itemView);
            activityDp = (CircleImageView) itemView.findViewById(R.id.activity_dp);
            activityUsername = (TextView) itemView.findViewById(R.id.activity_username);
            activityImage = (ImageView) itemView.findViewById(R.id.activity_image);
            activityDescription = (TextView) itemView.findViewById(R.id.activity_description);
        }
    }
}
