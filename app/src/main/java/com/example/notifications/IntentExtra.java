package com.example.notifications;

import java.util.Locale;

public enum IntentExtra {
    EXTRA(R.string.putExtra),
    CHANNEL_ID(R.string.channelID),
    DATA(R.string.dataToSubmit),
    CONTENT_TITLE(R.string.service),
    CONTENT_MSG(R.string.message),
    FOREGROUND(R.string.foreground),
    BACKGROUND(R.string.background),
    NOTIFICATION_ID(R.string.notification_id),
     NOTIFICATION (R.string.notification);

    public final String key;


    IntentExtra(int putExtra) {
        this.key=putExtra;
    }


}
