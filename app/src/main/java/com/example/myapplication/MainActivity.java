package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
CatogryAdapter catogryAdapter;
MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel= ViewModelProviders.of(this).get(MainViewModel.class);
        recyclerView=findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainViewModel.getResponse().observe(this, new Observer<CatogryResponse>() {
            @Override
            public void onChanged(CatogryResponse catogryResponse) {
                setAdapter(catogryResponse.getCategories());

            }
        });
    }
    public void setAdapter(List <Category>categoryList)
    {
        catogryAdapter=new CatogryAdapter(categoryList,MainActivity.this);
        recyclerView.setAdapter(catogryAdapter);
        catogryAdapter.notifyDataSetChanged();

    }
}