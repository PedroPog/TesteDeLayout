package com.aula.teste.adapter;

import android.content.Context;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.aula.teste.R;
import com.aula.teste.itens.ItemGrid;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends ArrayAdapter<ItemGrid> {

    public GridAdapter(@NonNull Context context, ArrayList<ItemGrid> itemGridArrayList) {
        super(context, 0, itemGridArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }
        ItemGrid item = getItem(position);
        TextView courseTV = listitemView.findViewById(R.id.idTVCourse);
        ImageView courseIV = listitemView.findViewById(R.id.idIVcourse);
        courseTV.setText(item.getName());
        if(item.getImg().equalsIgnoreCase("0")||item.getImg().equalsIgnoreCase(null)){
            Picasso.get()
                    .load("file://" + Environment.getExternalStorageDirectory()
                            + "/satflex/imagens/naoencontrada.png")
                    .into(courseIV);
        }else{
            String nomeImagem[] = item.getImg().split("/");

            Picasso.get()
                    .load("file://" + Environment.getExternalStorageDirectory()
                            + "/satflex/imagens/" + nomeImagem[1])
                    .into(courseIV);
        }
        //courseIV.setImageResource(item.getImg());
        return listitemView;
    }
}
