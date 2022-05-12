package com.arun.sampletaskkings;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserPerReport extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userper_report_progress);
        ProgressBar progressBar1 =  (ProgressBar) findViewById(R.id.progress_bar1);
        ProgressBar progressBar2 =  (ProgressBar) findViewById(R.id.progress_bar2);
        ProgressBar progressBar3 =  (ProgressBar) findViewById(R.id.progress_bar3);
        ProgressBar progressBar4 =  (ProgressBar) findViewById(R.id.progress_bar4);
        ProgressBar progressBar5 =  (ProgressBar) findViewById(R.id.progress_bar5);

        progressBar1.setProgress(80);
        progressBar2.setProgress(60);
        progressBar3.setProgress(90);
        progressBar4.setProgress(80);
        progressBar5.setProgress(76);
    }
}
