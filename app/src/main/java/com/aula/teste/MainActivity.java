package com.aula.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aula.teste.activity.GridActivity;
import com.aula.teste.activity.RecyclerActivity;
import com.aula.teste.activity.RecyclerGridActivity;

public class MainActivity extends AppCompatActivity {
    Button btnRecycler,btnRecyclerGrid,btnGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBtn();
        setOnClicker();
    }
    private void initBtn(){
        btnRecycler = findViewById(R.id.btnRecycler);
        btnRecyclerGrid = findViewById(R.id.btnRecyclerGrid);
        btnGrid = findViewById(R.id.btnGrid);
    }
    private void setOnClicker(){
        btnRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(intent);
            }
        });
        btnRecyclerGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerGridActivity.class);
                startActivity(intent);
            }
        });
        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GridActivity.class);
                startActivity(intent);
            }
        });
    }

}