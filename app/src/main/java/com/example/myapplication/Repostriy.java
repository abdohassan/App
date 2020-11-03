package com.example.myapplication;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repostriy {
    private MutableLiveData<CatogryResponse>mutableLiveData=new MutableLiveData<>();
    private Application application;
    public Repostriy (Application application)
    {
        this.application=application;
    }

    public MutableLiveData<CatogryResponse> getMutableLiveData() {
        Call <CatogryResponse>call=RetrofitClient.getInstance().getMyApi().getCatogry();
        call.enqueue(new Callback<CatogryResponse>() {
            @Override
            public void onResponse(Call<CatogryResponse> call, Response<CatogryResponse> response) {
                CatogryResponse catogryResponse=response.body();
                mutableLiveData.setValue(catogryResponse);

            }

            @Override
            public void onFailure(Call<CatogryResponse> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
