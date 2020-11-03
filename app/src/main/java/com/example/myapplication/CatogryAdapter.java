package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CatogryAdapter extends RecyclerView.Adapter<CatogryAdapter.CatogryHolder> {
List<Category>categoryList;
Context context;
public CatogryAdapter(List<Category>categoryList, Context context)
{
    this.categoryList=categoryList;
    this.context=context;
}
    @NonNull
    @Override
    public CatogryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CatogryHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.catagoryitem,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CatogryHolder holder, int position) {
    Category category=categoryList.get(position);
        Glide.with(context).load(category.getStrCategoryThumb()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class CatogryHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
        public CatogryHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }
}
