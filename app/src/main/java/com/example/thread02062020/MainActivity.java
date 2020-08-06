package com.example.thread02062020;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Background Thread
//        MainThread

        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("BBB","Thread running");
            }
        });
        thread.start();

    }
}