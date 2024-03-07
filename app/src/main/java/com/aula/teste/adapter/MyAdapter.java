package com.aula.teste.adapter;

import android.content.Context;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aula.teste.R;
import com.aula.teste.holder.MyViewHolder;
import com.aula.teste.itens.Item;
import com.squareup.picasso.Picasso;

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
        holder.name.setText("Descrição: "+itemList.get(position).getName());
        holder.email.setText("Categoria: "+itemList.get(position).getEmail());
        if(itemList.get(position).getImagem().equalsIgnoreCase("0")){
            Picasso.get()
                    .load("file://" + Environment.getExternalStorageDirectory()
                            + "/satflex/imagens/naoencontrada.png")
                    .into(holder.imageView);
        }else{
            String nomeImagem[] = itemList.get(position).getImagem().split("/");

            Picasso.get()
                    .load("file://" + Environment.getExternalStorageDirectory()
                            + "/satflex/imagens/" + nomeImagem[1])
                    .into(holder.imageView);
        }
        //holder.imageView.setImageResource(itemList.get(position).getImagem());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
