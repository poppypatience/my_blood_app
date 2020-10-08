package com.example.mybloodapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    TextView sub_header,loginlink;
    EditText fullname,emailaddress,phonenumber,username,enterpassword;
    Button register;
    private ProgressBar Loading;
    private String names_val, email_val, phone_val,  username_val, password_val;
    private static String URL_REGISTER = "http://192.168.1.40/sal/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Loading = findViewById(R.id.Loading);

        sub_header = findViewById(R.id.sub_header);
        fullname = findViewById(R.id.fullname);
        emailaddress =findViewById(R.id.emailaddress);
        phonenumber =findViewById(R.id.phonenumber);
        username =findViewById(R.id.username);
        enterpassword =findViewById(R.id.enterpassord);
        loginlink = findViewById(R.id.loginlink);
        loginlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, com.example.mybloodapp.login.class);
                startActivity(intent);
            }
        });

        register =findViewById(R.id.register);
        loginlink =findViewById(R.id.loginlink);

       register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               names_val = fullname.getText(). toString(). trim().toLowerCase();
              email_val = emailaddress.getText(). toString(). trim().toLowerCase();
              phone_val = phonenumber.getText(). toString(). trim().toLowerCase();
            username_val = username.getText(). toString(). trim().toLowerCase();
               password_val = enterpassword.getText(). toString(). trim().toLowerCase();

               if (!names_val.isEmpty()|| !email_val.isEmpty()|| !phone_val.isEmpty()|| !username_val.isEmpty()|| !password_val.isEmpty()) {

                 Register();
               }



               else {
                   fullname.setError("Enter full names");
                   emailaddress.setError("Enter email");
                   phonenumber.setError("Enter phone number");
                  username.setError("Enter full username");
                  enterpassword.setError("Enter password");

               }



           }
       });

    }





    private  void Register(){
     Loading. setVisibility(View.VISIBLE);
        register.setVisibility(View.GONE);
        final String fullname = this.fullname.getText().toString().trim();
        final String emailaddress = this.emailaddress.getText().toString().trim();
        final String phonenumber = this.phonenumber.getText().toString().trim();
        final String username= this.username.getText().toString().trim();
        final String enterpassword = this.enterpassword.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.i("tagconvertstr","["+response+"]");
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            if (success.equals("1")) {
                                Toast.makeText(getApplicationContext(), "Registration Successfull", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Register.this, com.example.mybloodapp.Home.class);
                                startActivity(intent);

                                Loading.setVisibility(View.GONE);
                                register.setVisibility(View.VISIBLE);
                            }
                           else if (success.equals("2")) {
                                Toast.makeText(getApplicationContext(), "Either email or phone no or username already exist so make changes", Toast.LENGTH_SHORT).show();
                                Loading.setVisibility(View.GONE);
                                register.setVisibility(View.VISIBLE);
                            }





                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Registration Error" + e.toString(), Toast.LENGTH_SHORT).show();
                            Loading.setVisibility(View.GONE);
                            register.setVisibility(View.VISIBLE);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Registration Error" + error.toString(), Toast.LENGTH_SHORT).show();
                        Loading.setVisibility(View.GONE);
                        register.setVisibility(View.VISIBLE);
                    }
                }

        )
        {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String , String>paramas = new HashMap<>();
                paramas.put("fullname",fullname);
                paramas.put("email",emailaddress);
                paramas.put("phone",phonenumber);
                paramas.put("username",username);
                paramas.put("password",enterpassword);
                return paramas;


            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
