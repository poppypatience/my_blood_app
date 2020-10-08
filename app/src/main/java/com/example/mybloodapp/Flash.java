package com.example.mybloodapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Flash extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH =5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);

        new Handler ().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Flash.this,Register.class);
                startActivity(intent);
                finish();

            }
        },SPLASH_DISPLAY_LENGTH);
    }
}
