package com.aula.teste.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import com.aula.teste.R;
import com.aula.teste.adapter.GridAdapter;
import com.aula.teste.itens.Item;
import com.aula.teste.itens.ItemGrid;
import com.aula.teste.model.ModelProdutos;
import com.aula.teste.retrofit.ApiRetrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GridActivity extends AppCompatActivity {

    GridView gridView;
    private ArrayList<ItemGrid> itemGrids = new ArrayList<ItemGrid>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridView = findViewById(R.id.idGrid);

        ApiRetrofit apiRetrofit = new ApiRetrofit();
        //items.add(new Item("John Wick","john.wick@gmail.com",R.drawable.a));

        ModelProdutos modelProdutos = new ModelProdutos();
        modelProdutos.setNomeBanco("db473376050001361");

        Call<ArrayList<ModelProdutos>> request = apiRetrofit.getUrlLocal()
                .getProdutos(modelProdutos);

        request.enqueue(new Callback<ArrayList<ModelProdutos>>() {
            @Override
            public void onResponse(Call<ArrayList<ModelProdutos>> call, Response<ArrayList<ModelProdutos>> response) {
                if(response.body()!=null){
                    ArrayList<ModelProdutos> temporario = response.body();
                    for(int i=0;i < temporario.size();i++){
                        //downloadImagem(temporario.get(i).getImagem());
                        itemGrids.add(new ItemGrid(temporario.get(i).getDescricao(),
                                temporario.get(i).getImagem()));
                    }
                    adicionar();
                }else{
                    Toast.makeText(GridActivity.this, "Problema ao carregar Produtos", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ArrayList<ModelProdutos>> call, Throwable t) {

            }
        });


    }
    private void adicionar(){
        GridAdapter gridAdapter = new GridAdapter(this,itemGrids);
        gridView.setAdapter(gridAdapter);
    }
}