package com.example.instagramclone_android.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagramclone_android.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {
    @NonNull
    private String[] data;
    public GridAdapter()
    {
        this.data = data;
    }
    @Override
    @NonNull
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_grid_view, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 27;
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView postImage;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            postImage = (ImageView) itemView.findViewById(R.id.grid_images);
        }
    }
}