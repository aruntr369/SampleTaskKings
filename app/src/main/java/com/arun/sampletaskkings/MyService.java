package com.arun.sampletaskkings;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyService extends Service {
    private static final String TAG = "MyService";
        Handler mHandler;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        createNotificationChannel();

        Intent intent1 = new Intent(this,MainActivity.class);




        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent1,PendingIntent.FLAG_IMMUTABLE);
        Notification notification = new NotificationCompat.Builder(this,"ChannelId1")
                .setContentTitle("My Sample")
                .setContentText("app running")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent).build();

        startForeground(1,notification);
        mHandler = new Handler();
        startRepeatingTask();

        return START_STICKY;
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(
                    "ChannelId1","Foreground notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(notificationChannel);
        }
    }

    @Override
    public void onDestroy() {
        stopForeground(true);
        stopSelf();
        super.onDestroy();
    }

    Runnable mStatusChecker = new Runnable() {
        @Override
        public void run() {
            try {
                Log.d(TAG, "run: aaa");
                Toast.makeText(MyService.this, "test", Toast.LENGTH_SHORT).show();
                //updateStatus(); //this function can change value of mInterval.
            } finally {
                // 100% guarantee that this always happens, even if
                // your update method throws an exception
                mHandler.postDelayed(mStatusChecker, 5000);
            }
        }
    };

    void startRepeatingTask() {
        mStatusChecker.run();
    }


}
