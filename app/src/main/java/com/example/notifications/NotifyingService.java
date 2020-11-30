package com.example.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class NotifyingService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String status = intent.getStringExtra(IntentExtra.EXTRA.key);

        Intent notificationIntent = new Intent(this, NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);
        Notification notification = new NotificationCompat.Builder(this, IntentExtra.CHANNEL_ID.key)
                .setContentTitle(IntentExtra.CONTENT_TITLE.key)
                .setContentText(status)
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setContentIntent(pendingIntent)
                .build();
        if (status.equalsIgnoreCase(IntentExtra.FOREGROUND.key)) {
            startForeground(1, notification);
        }

        //do in background
        //stopSelf();
        return START_REDELIVER_INTENT;

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
