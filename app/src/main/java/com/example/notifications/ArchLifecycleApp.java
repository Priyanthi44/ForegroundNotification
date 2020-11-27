package com.example.notifications;

import android.app.Application;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

public class ArchLifecycleApp extends Application implements LifecycleObserver {

    @Override
    public void onCreate() {
        super.onCreate();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onAppBackgrounded() {
        //App in background

        Intent serviceIntent =new Intent(this,NotifyingService.class);
        serviceIntent.putExtra(IntentExtra.EXTRA.key,
                IntentExtra.BACKGROUND);
        ContextCompat.startForegroundService(this,serviceIntent);

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onAppForegrounded() {
        Intent serviceIntent =new Intent(this,NotifyingService.class);
        serviceIntent.putExtra(IntentExtra.EXTRA.key,
                IntentExtra.FOREGROUND.key);
        startService(serviceIntent);

    }
}