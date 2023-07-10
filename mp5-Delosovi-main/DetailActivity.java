package com.example.foodieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView FoodTitle = findViewById(R.id.titleDetail);
        ImageView FoodImage = findViewById(R.id.foodImageDetail);

        FoodTitle.setText(getIntent().getStringExtra("title"));
        //FoodImage.setImageResource(currentFood.getImageID());

    }
}