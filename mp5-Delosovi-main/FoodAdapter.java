package com.example.foodieapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    private ArrayList<Food> foodsData;
    private Context context;

    public FoodAdapter(Context context, ArrayList<Food> foodArrayList){
        this.context = context;
        foodsData = foodArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder((LayoutInflater.from(context).inflate(R.layout.list_items,parent,false)));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Food currFood = foodsData.get(position);
        holder.bindItem(currFood);
    }

    @Override
    public int getItemCount() {
        return foodsData.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView textTitle, textInfo;
        private ImageView imageViewFood;

        public ViewHolder(View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.title);
            textInfo = itemView.findViewById(R.id.subTitle);
            imageViewFood = itemView.findViewById(R.id.imageViewFood);
            itemView.setOnClickListener(this);
        }
        public void bindItem(Food currentFoods) {
            textTitle.setText(currentFoods.getTitle());
            textInfo.setText(currentFoods.getInfo());
            imageViewFood.setImageResource(currentFoods.getImageID());
           // Glide.with(context).load(currentFoods.getImageID()).into(imageViewFood);
        }


        @Override
        public void onClick(View view) {
            Food currentFood = foodsData.get(getAdapterPosition());
            Intent detailIntent = new Intent(context, DetailActivity.class);
            detailIntent.putExtra("title", currentFood.getTitle());
            detailIntent.putExtra("image_resource",
                    currentFood.getImageID());
            context.startActivity(detailIntent);

        }
    }
}
