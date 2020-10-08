package com.example.mybloodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class notifications extends AppCompatActivity {
    TextView notifications;
    Button alerts, drives,communication;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        drives=findViewById(R.id.drives);
        drives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent drives = new Intent(getApplicationContext(),drivesActivity.class);
                startActivity(drives);
            }
        });
    }
}