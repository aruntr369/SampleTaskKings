package com.arun.sampletaskkings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences shared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button start = (Button) findViewById(R.id.startButton);
//        Button stop = (Button) findViewById(R.id.stopButton);
//        TextView textView = (TextView) findViewById(R.id.textView);
//
//        shared = getSharedPreferences("time",MODE_PRIVATE);
//        textView.setText(shared.getString("currentime",null));
//
//
//
//
//        start.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(),MyService.class);
//                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//                    startForegroundService(intent);
//                }
//                else {
//                    startService(intent);
//                }
//            }
//        });
//        stop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                stopService(new Intent(getApplicationContext(),MyService.class));
//            }
//        });
    }
}