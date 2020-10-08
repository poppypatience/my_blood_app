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

public class Home extends AppCompatActivity {
    CardView Blood_Banks,Donate_Blood,matchings,ratings,consultation,notifications;
    LinearLayout ll;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


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
        Blood_Banks=findViewById(R.id.bloodbank);
        Blood_Banks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Blood_Bank = new Intent(getApplicationContext(),blood_banks.class);
                startActivity(Blood_Bank);
            }
        });

        consultation=findViewById(R.id.consultation);
        consultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent consultation = new Intent(getApplicationContext(),consult.class);
                startActivity(consultation);
            }
        });
        notifications=findViewById(R.id.notifications);
        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notifications = new Intent(getApplicationContext(), notifications.class);
                startActivity( notifications);
            }
        });

        ratings=findViewById(R.id.ratings);
        ratings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ratings = new Intent(getApplicationContext(),ratings.class);
                startActivity(ratings);
            }
        });

       matchings=findViewById(R.id.matchings);
       matchings.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent matchings = new Intent(getApplicationContext(),get_matchings.class);
               startActivity(matchings);
           }
       });
       consultation=findViewById(R.id.consultation);
       consultation.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent consultation = new Intent(getApplicationContext(),consult.class);
               startActivity(consultation);
           }
       });




     Donate_Blood=findViewById(R.id.donate);
Donate_Blood.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent Donate_Blood = new Intent(getApplicationContext(),questionare.class);
        startActivity(Donate_Blood);
    }
});


    }
}
