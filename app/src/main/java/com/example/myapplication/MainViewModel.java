package com.example.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MainViewModel extends AndroidViewModel {
    private Repostriy repostriy;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repostriy=new Repostriy(application);
    }
    public LiveData<CatogryResponse>getResponse()
    {
        return repostriy.getMutableLiveData();
    }
}
