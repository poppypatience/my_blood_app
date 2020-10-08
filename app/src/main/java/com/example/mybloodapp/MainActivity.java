package com.example.mybloodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }
}
