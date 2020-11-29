package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.notifications.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding= ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(mBinding.getRoot());

        System.out.println(IntentExtra.CHANNEL_ID.key);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    public void startService(View v){
        if(mBinding.checkBox.isChecked()){
            ArchLifecycleApp archLifecycleApp=new ArchLifecycleApp();
            archLifecycleApp.onAppForegrounded();

        }else{
            stopService(v);
        }


    }
    public void stopService(View view){
        Intent serviceIntent =new Intent(this,NotifyingService.class);
        stopService(serviceIntent);
    }
}