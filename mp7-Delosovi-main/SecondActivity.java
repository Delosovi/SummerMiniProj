package com.example.scorecounternew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView Title = null;
    private TextView Display = null;

    //private EditText PhoneNumber;
    private Button  ButtonCall;
    private Button ButtonMap;

    private static final String LOG_TAG =
            SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Display = (TextView) findViewById(R.id.Winner_Logo);
        Title = (TextView) findViewById((R.id.Winner_ID));


        ButtonCall = findViewById(R.id.Button_call);
        ButtonMap = findViewById(R.id.Map_button);


        Intent intent = getIntent();
        String winner = intent.getStringExtra("Winning Team");
        Display.setText(winner);

        String champs = intent.getStringExtra("Score line");
        Title.setText(champs);


        ButtonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:40.91039496110987,-73.82048928974326");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        ButtonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchThirdActivity("Call");
            }
        });
    }

    public void launchThirdActivity (String Call){
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);


    }

}
