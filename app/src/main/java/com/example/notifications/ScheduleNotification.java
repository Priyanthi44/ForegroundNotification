package com.example.notifications;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

public class ScheduleNotification {
    private  Context mContext;
    public ScheduleNotification(Context context){
        this.mContext=context;
    }
    private void scheduleNotification(Notification notification, int delay) {

        Intent notificationIntent = new Intent(this.mContext, NotificationPublisher.class);
        String name =mContext.getString(IntentExtra(NOTIFICATION_ID));
        notificationIntent.putExtra(, 1);
        notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        long futureInMillis = SystemClock.elapsedRealtime() + delay;
        AlarmManager alarmManager = (AlarmManager) mContext.getSystemService();
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
    }

    private Notification getNotification(String content) {
        Notification.Builder builder = new Notification.Builder(this.mContext);
        builder.setContentTitle(mContext.getString(IntentExtra.DATA));
        builder.setContentText(content);
        builder.setSmallIcon(R.drawable.ic_android_black_24dp);
        return builder.build();
    }
}
