package com.example.mybloodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mybloodapp.Home;
import com.example.mybloodapp.R;
import com.example.mybloodapp.Register;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {

    TextView Createaccount,sub_header;
    EditText username, password;
    Button login;
    ImageView arr;
    /*
        private ProgressBar wait;
        private String email_val, password_val ;*/
    private static String URL_LOGIN= "http://192.168.1.41/mybloodapp/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        sub_header = findViewById(R.id.sub_header);
        username = findViewById(R.id.enterusername);
        password = findViewById(R.id.enterpassword);
        login= findViewById(R.id.login);
        Createaccount = findViewById(R.id.createaccount);
//arr = findViewById(R.id.)
//
//        Createaccount.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(login.this,Register.class);
//                startActivity(intent);
//            }
//        });


//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(login.this,Home.class);
//                startActivity(intent);
//            }
//        });

        Createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,Register.class);
                startActivity(intent);
            }
        });




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if(!user.isEmpty() || !pass.isEmpty()) {
                    Login(user,pass);
                }

                else{
                    username.setError("Enter a valid Email");
                    password.setError("Enter  Password");
                }
            }
        });


    }

    private void Login(final String username, final String password){

//        final ProgressDialog loading = new ProgressDialog(login.this);
//        loading.setMessage("loging in please wait...");
//        loading.show();
//        login.setVisibility(View.GONE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Log.i("tagconvertstr","["+response+"]");
                    JSONObject jsonObject = new JSONObject(response);
                    String success = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("login");
                    if (success.equals("1")) {
                        Toast.makeText(login.this, "login success", Toast.LENGTH_SHORT).show();
                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject object = jsonArray.getJSONObject(i);
                            String id = object.getString("id").trim();
                            String username = object.getString("username").trim();
                            String password= object.getString("password").trim();


                            Intent intent = new Intent(login.this, Home.class);
                            startActivity(intent);
//                            loading.dismiss();
//                            login.setVisibility(View.GONE);

                        }
                    } else if (success.equals("0")) {
//                        loading.dismiss();
//                        login.setVisibility(View.GONE);
                        Toast.makeText(login.this, "login error account not found", Toast.LENGTH_SHORT);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
//                    loading.dismiss();
//                    login.setVisibility(View.VISIBLE);
                    Toast.makeText(login.this, "login error "+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        loading.dismiss();
//                        login.setVisibility(View.VISIBLE);
                        Toast.makeText(login.this, "login error"+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            protected Map<String,String> getParams()throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("password",password);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
