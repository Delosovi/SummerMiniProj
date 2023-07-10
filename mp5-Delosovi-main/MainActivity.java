package com.example.foodieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Food>foodsData;
    private FoodAdapter foodAdapter;

    private int gridColmCount;

    ItemTouchHelper itemTouchHelper; // drag and swipe
    private int dragDirections = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.UP | ItemTouchHelper.DOWN;
    private int swipeDirections = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gridColmCount = getResources().getInteger(R.integer.grid_column_count);
        if(gridColmCount > 1) {
            swipeDirections = 0; // prevents swipe in a landscape direction
        }

        itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(dragDirections, swipeDirections) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
               int from = viewHolder.getAdapterPosition();
               int to = target.getAdapterPosition();
                Collections.swap(foodsData, from, to);
                foodAdapter.notifyItemMoved(from, to);
                return false;
            }
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                foodsData.remove(viewHolder.getAdapterPosition());
                foodAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, gridColmCount));


        itemTouchHelper.attachToRecyclerView(recyclerView);


        foodsData = new ArrayList<>();
        foodAdapter = new FoodAdapter(this,foodsData);
        recyclerView.setAdapter(foodAdapter);

        loadFoodData();



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFoodData();
            }
        });
    }

    private void loadFoodData() {
        foodsData.clear();

        String [] foodTitles = getResources().getStringArray(R.array.foods_titles);
        String [] foodInfo = getResources().getStringArray(R.array.foods_info);
        TypedArray foodsImages = getResources().obtainTypedArray(R.array.food_images);

        for(int i = 0; i < foodTitles.length; i++){
            foodsData.add(new Food(foodTitles[i], foodInfo[i], foodsImages.getResourceId(i,0)));

        }

        foodAdapter.notifyDataSetChanged();
        foodsImages.recycle();

    }

    public void sendTheBroadcast(View view) {

    }
}