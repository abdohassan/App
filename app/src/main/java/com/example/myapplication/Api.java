package com.example.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String baseUrl="https://www.themealdb.com/api/json/v1/1/";

    @GET("categories.php")
    Call<CatogryResponse>getCatogry();

}
