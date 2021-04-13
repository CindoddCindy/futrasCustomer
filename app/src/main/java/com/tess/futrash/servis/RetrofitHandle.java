package com.tess.futrash.servis;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHandle {

    private static Retrofit retrofit=null;
    private RetrofitHandle(){

    }

    public static Retrofit getRetrofitLink() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

// set log level
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

//add logging
        okHttpClient.addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.100.22:8080/api/foodTrash/")
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;

    }
}
