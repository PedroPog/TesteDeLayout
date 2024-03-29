package com.aula.teste.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.aula.teste.R;
import com.aula.teste.adapter.MyAdapter;
import com.aula.teste.itens.Item;
import com.aula.teste.itens.RecyclerData;
import com.aula.teste.model.ModelProdutos;
import com.aula.teste.retrofit.ApiRetrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Item> items = new ArrayList<Item>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerView  = findViewById(R.id.recyclerview);


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
                        items.add(new Item(temporario.get(i).getDescricao(),
                                temporario.get(i).getDescricaocateg(),temporario.get(i).getImagem()));
                    }
                    adicionar();
                }else{
                    Toast.makeText(RecyclerActivity.this, "Problema ao carregar Produtos", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ArrayList<ModelProdutos>> call, Throwable t) {

            }
        });




    }

    private void adicionar(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));
    }
}