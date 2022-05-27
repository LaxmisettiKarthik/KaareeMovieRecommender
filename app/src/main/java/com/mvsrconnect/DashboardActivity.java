package com.mvsrconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {
Button suggester;
Button recommender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        suggester = findViewById(R.id.Suggesterbtn);
        recommender = findViewById(R.id.Recommenderbtn);

        suggester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        recommender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}