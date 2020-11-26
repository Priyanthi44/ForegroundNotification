package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View v){
        Intent serviceIntent =new Intent(this,NotifyingService.class);
        serviceIntent.putExtra("input","ForegroundService");
        startService(serviceIntent);

    }
    public void stopService(View view){
        Intent serviceIntent =new Intent(this,NotifyingService.class);
        stopService(serviceIntent);
    }
}