package com.example.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationPublisher extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification = intent.getParcelableExtra(IntentExtra.NOTIFICATION.key);
        int id = intent.getIntExtra(IntentExtra.NOTIFICATION_ID.key, 0);
        notificationManager.notify(id, notification);
    }
}
