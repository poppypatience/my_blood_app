package com.example.mybloodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class consult extends AppCompatActivity {
    CardView donation,nutrition,tips;
    LinearLayout ll;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        BottomNavigationView navigation =findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.ic_home:
                        Intent home = new Intent(getApplicationContext(),Home.class);
                        startActivity(home);
                        break;

                    case R.id.ic_help:
                        Intent help = new Intent(getApplicationContext(),help.class);
                        startActivity(help);
                        break;

                    case R.id.ic_settings:
                        Intent settings = new Intent(getApplicationContext(),settings.class);
                        startActivity(settings);
                        break;

                    case R.id.ic_list:
                        Intent MainActivity = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(MainActivity);
                        break;

                    case R.id.ic_logout:
                        Intent logout = new Intent(getApplicationContext(),login.class);
                        startActivity(logout);
                        break;


                }





                return false;
            }
        });
        ll=findViewById(R.id.ll);
        donation=findViewById(R.id.donation);
        donation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent donation = new Intent(getApplicationContext(),help.class);
                startActivity(donation);
            }
        });

        tips=findViewById(R.id.tips);
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tips = new Intent(getApplicationContext(),exercisetips.class);
                startActivity(tips);
            }
        });

       nutrition=findViewById(R.id.nutrition);
        nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nutrition = new Intent(getApplicationContext(),nutrition.class);
                startActivity(nutrition);
            }
        });


    }
}
