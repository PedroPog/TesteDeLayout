package com.aula.teste.retrofit;

import com.aula.teste.model.ModelCategorias;
import com.aula.teste.model.ModelImagem;
import com.aula.teste.model.ModelProdutos;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("buscar/categoria/todas")
    Call<ArrayList<ModelCategorias>> getCategoria(@Body ModelCategorias modelCategorias);

    @POST("buscar/produto/todos")
    Call<ArrayList<ModelProdutos>> getProdutos(@Body ModelProdutos modelProdutos);

    @POST("downloadimagem")
    Call<ResponseBody> downloadImagem(@Body ModelImagem imagem);
}
