package com.example.thread02062020;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    int a , b  ,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = b = c = 0;

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1 ; i <= 10 ; i++){
                    a = i;
                    Log.d("BBB" , "A : " + i);
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1 ; i <= 10 ; i++){
                    b = i;
                    Log.d("BBB" , "B : " + i);
                }
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1 ; i <= 10 ; i++){
                    c = a + b;
                    Log.d("BBB" , "c : " + i);
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }

}