package com.example.mybloodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class get_matchings extends AppCompatActivity {

    Button match;
EditText bgg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_matchings);

        match = findViewById(R.id.match);
        bgg = findViewById(R.id.bloodgroups);
        match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String bg = bgg.getText().toString().trim();
                if (bg.isEmpty()){
                    Toast.makeText(get_matchings.this, "enter blood group", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(get_matchings.this, BloodgroupActivity.class);
                    intent.putExtra("bloodgroup", bg);
                    startActivity(intent);

                }
            }
        });
    }
}