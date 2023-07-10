package com.example.scorecounternew;

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

    public static final String EXTRA_MESSAGE =
            "com.example.android.twoactivities.extra.MESSAGE";


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
                    launchSecondActivity("Team A", myCounterA - myCounterB);
                }
                ScoreA.setText(Integer.toString(myCounterA));
            }
        });

        ButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCounterB++;
                if (myCounterB == 5) {
                    launchSecondActivity("Team B",myCounterB - myCounterA);
                }
                ScoreB.setText(Integer.toString(myCounterB));
            }
        });
    }


    public void launchSecondActivity (String Winner, int dif){
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("Winning Team", Winner);
        startActivity(intent);


        // "" + dif or String.valueOf(diff);
        if (dif == 5) {
            intent.putExtra("Score line", "Kinda overkill, congrats " + Winner + ", on winning by: " + dif);
        }
        if (dif == 1){
            intent.putExtra("Score line", "Cutting it close, congrats " + Winner + ", on winning by: " + dif);
        }
        else {
            intent.putExtra("Score line", "Congrats " + Winner + ", on winning by: " + dif);
        }
        //String.valueOf(dif);
        startActivity(intent);

    }
}
