package com.aula.teste.adapter;

import android.content.Context;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aula.teste.R;
import com.aula.teste.itens.RecyclerData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {
    private ArrayList<RecyclerData> courseDataArrayList;
    private Context mcontext;

    public RecyclerViewAdapter(ArrayList<RecyclerData> recyclerDataArrayList, Context mcontext) {
        this.courseDataArrayList = recyclerDataArrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        // Set the data to textview and imageview.
        RecyclerData recyclerData = courseDataArrayList.get(position);
        holder.courseTV.setText(recyclerData.getTitle());
        if(recyclerData.getImgid().equalsIgnoreCase("0")){
            Picasso.get()
                    .load("file://" + Environment.getExternalStorageDirectory()
                            + "/satflex/imagens/naoencontrada.png")
                    .into(holder.courseIV);
        }else{
            String nomeImagem[] = recyclerData.getImgid().split("/");

            Picasso.get()
                    .load("file://" + Environment.getExternalStorageDirectory()
                            + "/satflex/imagens/" + nomeImagem[1])
                    .into(holder.courseIV);
        }
    }

    @Override
    public int getItemCount() {
        // this method returns the size of recyclerview
        return courseDataArrayList.size();
    }

    // View Holder Class to handle Recycler View.
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView courseTV;
        private ImageView courseIV;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            courseTV = itemView.findViewById(R.id.idTVCourse);
            courseIV = itemView.findViewById(R.id.idIVcourseIV);
        }
    }
}
