package com.aula.teste.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.aula.teste.R;
import com.aula.teste.adapter.RecyclerViewAdapter;
import com.aula.teste.itens.RecyclerData;

import java.util.ArrayList;

public class RecyclerGridActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<RecyclerData> recyclerDataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_grid);

        recyclerView=findViewById(R.id.idCourseRV);

        // created new array list..
        recyclerDataArrayList=new ArrayList<>();

        // added data to array list
        recyclerDataArrayList.add(new RecyclerData("DSA",R.drawable.a));
        recyclerDataArrayList.add(new RecyclerData("JAVA",R.drawable.b));
        recyclerDataArrayList.add(new RecyclerData("C++",R.drawable.c));
        recyclerDataArrayList.add(new RecyclerData("Python",R.drawable.d));
        recyclerDataArrayList.add(new RecyclerData("Node Js",R.drawable.e));
        recyclerDataArrayList.add(new RecyclerData("DSA",R.drawable.a));
        recyclerDataArrayList.add(new RecyclerData("JAVA",R.drawable.b));
        recyclerDataArrayList.add(new RecyclerData("C++",R.drawable.c));
        recyclerDataArrayList.add(new RecyclerData("Python",R.drawable.d));
        recyclerDataArrayList.add(new RecyclerData("Node Js",R.drawable.e));
        recyclerDataArrayList.add(new RecyclerData("DSA",R.drawable.a));
        recyclerDataArrayList.add(new RecyclerData("JAVA",R.drawable.b));
        recyclerDataArrayList.add(new RecyclerData("C++",R.drawable.c));
        recyclerDataArrayList.add(new RecyclerData("Python",R.drawable.d));
        recyclerDataArrayList.add(new RecyclerData("Node Js",R.drawable.e));
        recyclerDataArrayList.add(new RecyclerData("DSA",R.drawable.a));
        recyclerDataArrayList.add(new RecyclerData("JAVA",R.drawable.b));
        recyclerDataArrayList.add(new RecyclerData("C++",R.drawable.c));
        recyclerDataArrayList.add(new RecyclerData("Python",R.drawable.d));
        recyclerDataArrayList.add(new RecyclerData("Node Js",R.drawable.e));
        recyclerDataArrayList.add(new RecyclerData("DSA",R.drawable.a));
        recyclerDataArrayList.add(new RecyclerData("JAVA",R.drawable.b));
        recyclerDataArrayList.add(new RecyclerData("C++",R.drawable.c));
        recyclerDataArrayList.add(new RecyclerData("Python",R.drawable.d));
        recyclerDataArrayList.add(new RecyclerData("Node Js",R.drawable.e));
        recyclerDataArrayList.add(new RecyclerData("DSA",R.drawable.a));
        recyclerDataArrayList.add(new RecyclerData("JAVA",R.drawable.b));
        recyclerDataArrayList.add(new RecyclerData("C++",R.drawable.c));
        recyclerDataArrayList.add(new RecyclerData("Python",R.drawable.d));
        recyclerDataArrayList.add(new RecyclerData("Node Js",R.drawable.e));

        // added data from arraylist to adapter class.
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(recyclerDataArrayList,this);

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager=new GridLayoutManager(this,4);

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}