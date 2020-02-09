package com.example.dilek.ingilizcequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread splashThread;
        splashThread = new Thread(){
            @Override public void run(){
                try{
                    synchronized (this){
                        wait(1500);
                    }
                }catch (InterruptedException ex){

                }
                finally {
                    startActivity(new Intent(getApplicationContext(), GirisActivity.class));
                    finish();
                }
            }
        };
        splashThread.start();
    }
}
