package com.aula.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.aula.chat.LoginActivity;
import com.aula.teste.activity.GridActivity;
import com.aula.teste.activity.RecyclerActivity;
import com.aula.teste.activity.RecyclerGridActivity;
import com.aula.teste.fragment.FragActivity;

public class MainActivity extends AppCompatActivity {
    Button btnRecycler,btnRecyclerGrid,btnGrid,btnFrag,btnChat;
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
        btnFrag = findViewById(R.id.btnFrag);
        btnChat = findViewById(R.id.btnChat);
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
        btnFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragActivity.class);
                startActivity(intent);
            }
        });
        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}