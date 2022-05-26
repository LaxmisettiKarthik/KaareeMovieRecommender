package com.mvsrconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity3 extends AppCompatActivity {
    TextView appname;
    LottieAnimationView lottie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        appname = findViewById(R.id.textView);
        lottie =findViewById(R.id.lottieAnimationView);

        appname.animate().translationY(1500).setDuration(3000).setStartDelay(0);
       lottie.animate().translationX(-2000).setDuration(3500).setStartDelay(1500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        },3500);

    }
}