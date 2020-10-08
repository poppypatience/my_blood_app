package com.example.mybloodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class questionare extends AppCompatActivity {

    CheckBox hivyes,hivno,pregnantyes,pregnantno,weakyes,weakno,issuesyes,issuesno,treatmentyes,treatmentno;
    Button submit;
    String answer;
    TextView answers;
            
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionare);

        hivyes = findViewById(R.id.hiv_yes);
        hivno =findViewById(R.id.hiv_no);
        pregnantyes = findViewById(R.id.preganant_yes);
        pregnantno =findViewById(R.id.pregnant_no);
       weakyes = findViewById(R.id.weak_yes);
        weakno =findViewById(R.id.weak_no);
        issuesyes = findViewById(R.id.issues_yes);
        issuesno =findViewById(R.id.issues_no);
        treatmentyes = findViewById(R.id.treatment_yes);
        treatmentno =findViewById(R.id.treatment_no);
        submit =findViewById(R.id.submit);
        answers =findViewById(R.id.answers);

        hivyes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    hivno.setEnabled(false);
                    submit.setEnabled(true);
                }

                else if (!isChecked){
                    hivno.setEnabled(true);
                    submit.setEnabled(false);
                }
            }
        });

        hivno.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    hivyes.setEnabled(false);
                    submit.setEnabled(true);
                }

                else if (!isChecked){
                    hivyes.setEnabled(true);
                    submit.setEnabled(false);
                }
            }
        });




        pregnantyes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    pregnantno.setEnabled(false);
                    submit.setEnabled(true);
                    /* Toast.makeText(questionare.this,"not eligible to donate",Toast.LENGTH_SHORT).show();*/
                }

                else if (!isChecked){
                    pregnantno.setEnabled(true);
                    submit.setEnabled(false);
                }
            }
        });


        pregnantno.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    pregnantyes.setEnabled(false);
                    submit.setEnabled(true);
                    /* Toast.makeText(questionare.this,"not eligible to donate",Toast.LENGTH_SHORT).show();*/
                }

                else if (!isChecked){
                    pregnantyes.setEnabled(true);
                    submit.setEnabled(false);
                }
            }
        });



        weakyes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    weakno.setEnabled(false);
                     /*Toast.makeText(questionare.this,"not eligible to donate",Toast.LENGTH_SHORT).show();*/
                }

                else if (!isChecked){
                    weakno.setEnabled(true);
                }
            }
        });


        issuesyes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    issuesno.setEnabled(false);
                     /*Toast.makeText(questionare.this,"not eligible to donate",Toast.LENGTH_SHORT).show();*/
                }

                else if (!isChecked){
                    issuesno.setEnabled(true);
                }
            }
        });


        treatmentyes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked){
                    treatmentno.setEnabled(false);
                     /*Toast.makeText(questionare.this,"not eligible to donate",Toast.LENGTH_SHORT).show();*/
                }

                else if (!isChecked){
                    treatmentno.setEnabled(true);
                }
            }
        });




 submit.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         if (treatmentyes.isChecked() || issuesyes.isChecked()||weakyes.isChecked()||pregnantyes.isChecked()||hivyes.isChecked()){
             Toast.makeText(questionare.this,"not eligible to donate",Toast.LENGTH_SHORT).show();

         }else
         {

             Intent intent = new Intent(questionare.this, com.example.mybloodapp.blood_banks.class);
             startActivity(intent);
         }



     }
 });


    }
}