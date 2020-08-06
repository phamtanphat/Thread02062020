package com.example.thread02062020;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Background Thread
//        MainThread

        Thread threada = new Thread(new Runnable() {
            @Override
            public void run() {
                printLog("A");
            }
        });

        Thread threadb = new Thread(new Runnable() {
            @Override
            public void run() {
                printLog("B");
            }
        });

        threada.start();
        threadb.start();
//
//        Thread xử lý dữ lieu
//        Thread xử lý hình ảnh

    }
    public synchronized void printLog(String name){
        for (int i = 0 ; i < 1000 ; i++){
            Log.d("BBB", name  + " : " + i);
        }
    }
}