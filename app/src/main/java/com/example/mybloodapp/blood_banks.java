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

public class blood_banks extends AppCompatActivity {
    CardView westernuganda,easternuganda,nothernuganda,southernuaganda;
    LinearLayout ll;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_banks);
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
        westernuganda=findViewById(R.id.westernuganda);
        westernuganda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent westernuganda= new Intent(getApplicationContext(),westernuganda.class);
                startActivity(westernuganda);
            }
        });

        easternuganda=findViewById(R.id.easternuganda);
        easternuganda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent easternuganda = new Intent(getApplicationContext(),easternuganda.class);
                startActivity(easternuganda);
            }
        });



        nothernuganda=findViewById(R.id.nothernuganda);
        nothernuganda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nothernuganda = new Intent(getApplicationContext(),nothernuganda.class);
                startActivity(nothernuganda);
            }
        });

        southernuaganda=findViewById(R.id.southernuganda);
        southernuaganda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent southernuaganda = new Intent(getApplicationContext(),southernuganda.class);
                startActivity(southernuaganda);
            }
        });







    }
}
