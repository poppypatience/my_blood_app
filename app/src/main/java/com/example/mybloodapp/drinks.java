package com.example.mybloodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.net.URI;

public class drinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipsforgoodbloodcirculation);
    }

    public void browser4(View view) {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/search?client=firefox-b-d&q=%22http%3A%2F%2F+tips+for+good+blood+circulation"));
        startActivity(browserIntent);
    }
}