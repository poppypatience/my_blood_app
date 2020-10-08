package com.example.mybloodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Account extends AppCompatActivity {
     TextView security,changenumber,accountinfo,delete,privacy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        security= findViewById(R.id.security);
        security.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Security= new Intent(getApplicationContext(),Security.class);
                startActivity(Security);
            }
        });
        changenumber=findViewById(R.id.changenumber);
        changenumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent changenumber  = new Intent(getApplicationContext(),changenumber.class);
                startActivity(changenumber);
            }
        });

        accountinfo=findViewById(R.id.accountinfo);
        accountinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent accountinfo = new Intent(getApplicationContext(), accountinfo.class);
                startActivity(accountinfo);
            }
        });

        delete=findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent deleteaccount = new Intent(getApplicationContext(),deleteaccount.class);
                startActivity(deleteaccount);
            }
        });


        privacy=findViewById(R.id.privacy);
        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent privacy = new Intent(getApplicationContext(),privacy.class);
                startActivity(privacy);
            }
        });


    }
}