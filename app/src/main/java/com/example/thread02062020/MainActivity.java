package com.example.thread02062020;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int a , b  ,c;
    MyFlag mMyFlag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = b = c = 0;

        mMyFlag = new MyFlag(0);

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (mMyFlag){
                    for (int i = 1 ; i <= 1000 ; ){
                        if (mMyFlag.count == 0){
                            a = i;
                            Log.d("BBB" , "A : " + i);
                            mMyFlag.count = 1;
                            mMyFlag.notifyAll();
                            i++;
                        }else{
                            try {
                                mMyFlag.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (mMyFlag){
                    for (int i = 1 ; i <= 1000 ;){
                       if (mMyFlag.count == 1){
                           b = i;
                           Log.d("BBB" , "B : " + i);
                           mMyFlag.count = 2;
                           mMyFlag.notifyAll();
                           i++;
                       }else{
                           try {
                               mMyFlag.wait();
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                       }
                    }
                }
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (mMyFlag){
                    for (int i = 1 ; i <= 1000 ;){
                        if (mMyFlag.count == 2){
                            c = a + b;
                            Log.d("BBB" , "c : " + c);
                            mMyFlag.count = 0;
                            mMyFlag.notifyAll();
                            i++;
                        }else{
                            try {
                                mMyFlag.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }

}