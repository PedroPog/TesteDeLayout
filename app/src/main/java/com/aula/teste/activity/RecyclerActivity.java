package com.aula.teste.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.aula.teste.R;
import com.aula.teste.adapter.MyAdapter;
import com.aula.teste.itens.Item;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("John Wick","john.wick@gmail.com",R.drawable.a));
        items.add(new Item("John Wick","john.wick@gmail.com",R.drawable.b));
        items.add(new Item("John Wick","john.wick@gmail.com",R.drawable.c));
        items.add(new Item("John Wick","john.wick@gmail.com",R.drawable.e));
        items.add(new Item("John Wick","john.wick@gmail.com",R.drawable.f));
        items.add(new Item("John Wick","john.wick@gmail.com",R.drawable.g));
        items.add(new Item("John Wick","john.wick@gmail.com",R.drawable.h));
        items.add(new Item("John Wick","john.wick@gmail.com",R.drawable.f));
        items.add(new Item("John Wick","john.wick@gmail.com",R.drawable.a));
        items.add(new Item("John Wick","john.wick@gmail.com",R.drawable.b));
        items.add(new Item("John Wick","john.wick@gmail.com",R.drawable.c));
        items.add(new Item("John Wick","john.wick@gmail.com",R.drawable.e));
        items.add(new Item("John Wick","john.wick@gmail.com",R.drawable.f));
        items.add(new Item("John Wick","john.wick@gmail.com",R.drawable.g));
        items.add(new Item("John Wick","john.wick@gmail.com",R.drawable.h));
        items.add(new Item("John Wick","john.wick@gmail.com",R.drawable.f));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));
    }
}