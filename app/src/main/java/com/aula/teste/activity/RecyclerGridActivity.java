package com.aula.teste.activity;

import static java.lang.System.out;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import com.aula.teste.R;
import com.aula.teste.adapter.RecyclerViewAdapter;
import com.aula.teste.itens.RecyclerData;
import com.aula.teste.model.ModelImagem;
import com.aula.teste.model.ModelProdutos;
import com.aula.teste.retrofit.ApiRetrofit;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerGridActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<RecyclerData> recyclerDataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_grid);

        recyclerView=findViewById(R.id.idCourseRV);
        recyclerDataArrayList=new ArrayList<>();
        ApiRetrofit apiRetrofit = new ApiRetrofit();


        //recyclerDataArrayList.add(new RecyclerData("Node Js",R.drawable.e));

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
                        recyclerDataArrayList.add(new RecyclerData(temporario.get(i).getDescricao(),
                                temporario.get(i).getImagem()));
                    }
                    adicionar();
                }else{
                    Toast.makeText(RecyclerGridActivity.this, "Problema ao carregar Produtos", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ArrayList<ModelProdutos>> call, Throwable t) {

            }
        });



    }
    private void adicionar(){

        RecyclerViewAdapter adapter=new RecyclerViewAdapter(recyclerDataArrayList,this);
        GridLayoutManager layoutManager=new GridLayoutManager(this,4);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    private void downloadImagem(String imagemrecebida) {
        ModelImagem imagem = new ModelImagem();
        imagem.setNomePasta(imagemrecebida);
        String nomeImagem[] = imagem.getNomePasta().split("/");
        if (nomeImagem.length > 1) {
            out.println("nomeimagem[1]==" + nomeImagem[1]);
        } else {
            out.println("Array de nomeImagem não possui índice 1.");
        }
        ApiRetrofit retrofit = new ApiRetrofit();
        // String caminhoImagem = imagem.getNomePasta();
        Call<ResponseBody> request = retrofit.getUrlLocal().downloadImagem(imagem);
        request.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {
                    if(response.isSuccessful() && response.body() != null){
                        FileOutputStream out = new FileOutputStream( Environment.getExternalStorageDirectory() + "/satflex/imagens/"+response.headers().get("Nome do Arquivo"));
                        out.write(response.body().bytes());
                    }else{

                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    out.close();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                out.println("error.onFailure()+++++" + t.getMessage());
            }
        });
    }
}