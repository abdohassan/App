package com.example.myapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient mInstance;
    private Api myApi;
    private RetrofitClient()
    {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(Api.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi=retrofit.create(Api.class);
    }
    public static synchronized RetrofitClient getInstance()
    {
        if (mInstance==null)return new RetrofitClient();
        return mInstance;

    }
    public Api getMyApi()
    {
        return myApi;
    }
}
