package com.example.foodieapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Reciever extends BroadcastReceiver {

    private Context context;
    protected static final String ACTION_CUSTOM_BROADCAST = "com.example.foodieapp.ACTION_CUSTOM";
    @Override
    public void onReceive(Context context, Intent intent) {

    }
}
