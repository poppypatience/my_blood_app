package com.example.mybloodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mybloodapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class settings extends AppCompatActivity {

    TextView aboutus,help,account,inviteafriend;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


      aboutus = findViewById(R.id.textView3);
      help = findViewById(R.id.textView5);
      account =findViewById(R.id.textView6);
      inviteafriend = findViewById(R.id.textView7);


      aboutus.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(settings.this, com.example.mybloodapp.aboutus.class);
              startActivity(intent);
          }
      });

      help.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent =new Intent(settings.this, com.example.mybloodapp.help.class);
              startActivity(intent);
          }
      });

      account.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent =new Intent(settings.this, com.example.mybloodapp.Account.class);
              startActivity(intent);
          }
      });


        BottomNavigationView navigation =findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.ic_home:
                        Intent home = new Intent(getApplicationContext(), com.example.mybloodapp.Home.class);
                        startActivity(home);
                        break;

                    case R.id.ic_help:
                        Intent help = new Intent(getApplicationContext(), com.example.mybloodapp.help.class);
                        startActivity(help);
                        break;

                    case R.id.ic_settings:
                        Intent settings = new Intent(getApplicationContext(),settings.class);
                        startActivity(settings);
                        break;

                    case R.id.ic_list:
                        Intent MainActivity = new Intent(getApplicationContext(), com.example.mybloodapp.MainActivity.class);
                        startActivity(MainActivity);
                        break;

                    case R.id.ic_logout:
                        Intent logout = new Intent(getApplicationContext(), com.example.mybloodapp.login.class);
                        startActivity(logout);
                        break;


                }





                return false;
            }
        });
    }
}