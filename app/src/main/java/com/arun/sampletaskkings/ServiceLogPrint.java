package com.arun.sampletaskkings;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ServiceLogPrint extends Service {
    private static final String TAG = "ServiceLogPrint";
    Date currentTime = Calendar.getInstance().getTime();
    SharedPreferences shp;








    private static Timer timer = new Timer();
    private Context ctx;

    public IBinder onBind(Intent arg0)
    {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        ctx = this;
        startService();
    }

    private void startService() {
        timer.scheduleAtFixedRate(new mainTask(), 0, 10000);
    }

    private class mainTask extends TimerTask {
        public void run() {
            toastHandler.sendEmptyMessage(0);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
        Toast.makeText(this, "Service Stopped ...", Toast.LENGTH_SHORT).show();
    }

    private final Handler toastHandler = new Handler() {
        @Override
        public void handleMessage(Message msg)
        {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
            String currentDateandTime = sdf.format(new Date());

            shp = getSharedPreferences("time",MODE_PRIVATE);

            SharedPreferences.Editor editor = shp.edit();

            editor.putString("currentime",currentDateandTime);

            //editor.putString("password",password);
            editor.commit();

            String valuess = shp.getString("currentime",null);


            Log.d(TAG, "handleMessage: log print after 10sec"+valuess);
            Toast.makeText(getApplicationContext(), "test" + valuess, Toast.LENGTH_SHORT).show();
        }
    };
}