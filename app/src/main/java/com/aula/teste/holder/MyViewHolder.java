package com.aula.teste.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aula.teste.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView email,name;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imagemView);
        email = itemView.findViewById(R.id.email);
        name = itemView.findViewById(R.id.name);
    }
}
