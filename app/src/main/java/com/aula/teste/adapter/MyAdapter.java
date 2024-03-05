package com.aula.teste.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aula.teste.R;
import com.aula.teste.holder.MyViewHolder;
import com.aula.teste.itens.Item;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Item> itemList;

    public MyAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(itemList.get(position).getName());
        holder.email.setText(itemList.get(position).getEmail());
        holder.imageView.setImageResource(itemList.get(position).getImagem());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
