package com.aula.teste.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRetrofit {

    private final ApiService apiService;
    private final ApiService apiServiceNuvem;


    public ApiRetrofit(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.10.16:8081")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        apiService = retrofit.create(ApiService.class);

        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl("http://168.138.152.47:8081")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        apiServiceNuvem = retrofit2.create(ApiService.class);
    }

    public ApiService getUrlLocal() {
        return apiService;
    }
    public ApiService getUrl() {
        return apiServiceNuvem;
    }
}
