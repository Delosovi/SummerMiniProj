package com.example.scorecounterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int myCounterA = 0;
    private int myCounterB = 0;
    private TextView ScoreA = null;
    private TextView ScoreB = null;
    private Button ButtonA = null;
    private Button ButtonB = null;


    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ScoreA = (TextView) findViewById(R.id.count_initial_value_A);
        ScoreB = (TextView) findViewById(R.id.count_initial_value_B);
        ButtonA = (Button) findViewById(R.id.button_A);
        ButtonB = (Button) findViewById(R.id.button_B);

        ButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCounterA++;
                if (myCounterA == 5) {
                    launchSecondActivity(view);
                }
                ScoreA.setText(Integer.toString(myCounterA));
            }
        });

    ButtonB.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            myCounterB++;
            if (myCounterB == 5) {
                launchSecondActivity(view);
            }
            ScoreB.setText(Integer.toString(myCounterB));
        }
    });
}


        public void launchSecondActivity (View view){
            Log.d(LOG_TAG, "Button clicked!");
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        }
    }
