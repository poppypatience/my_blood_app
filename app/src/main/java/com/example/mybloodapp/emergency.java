package com.example.mybloodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class emergency extends AppCompatActivity {
    TextView generate;
    EditText patients_name,location,deadline,blood_units,blood_group;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);


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

