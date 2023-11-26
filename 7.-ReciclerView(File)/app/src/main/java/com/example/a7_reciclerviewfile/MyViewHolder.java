package com.example.a7_reciclerviewfile;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageR;
    TextView nameR;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageR = itemView.findViewById(R.id.imageViewR);
        this.nameR = itemView.findViewById(R.id.textViewR);
    }
}
