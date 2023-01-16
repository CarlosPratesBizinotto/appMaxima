package com.example.appmaxima.utils

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.example.appmaxima.R


class SampleAlarmReceiver : BroadcastReceiver() {


    override fun onReceive(c: Context, i: Intent) {
        val mBuilder = NotificationCompat.Builder(c, "123")
            .setSmallIcon(R.mipmap.ic_max_teste)
            .setContentTitle("Title")
            .setContentText("Executando um AlarmManager")
            .setAutoCancel(true)

        val mNotificationManager = c.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        mNotificationManager.notify(100, mBuilder.build())
    }

}