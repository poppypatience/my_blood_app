package com.example.mybloodapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mybloodapp.Adapters.BloodgroupsAddapter;
import com.example.mybloodapp.Models.BloodgroupsModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BloodgroupActivity extends AppCompatActivity {


    private static final String NOTIFICATIONS_LIST_URL= "http://192.168.1.40/sal/get_bloodgroup.php";
    RecyclerView recyclerView;
    List<BloodgroupsModel> mData;
    BloodgroupsAddapter adapter;
    TextView error_message;
    BottomNavigationView bottomNavigationView;
    SessionManager sessionManager;
    String contact;
    String bbggg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.bloodgroup);

        Toolbar toolbar = findViewById(R.id.toolbar);
        /*setSupportActionBar(toolbar);*/
        recyclerView = findViewById(R.id.recyclerview);
        mData = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BloodgroupsAddapter(this,mData);
        recyclerView.setAdapter(adapter);


Intent ggg = getIntent();
bbggg = ggg.getStringExtra("bloodgroup");

        LoadNotificationsList();

        sessionManager = new SessionManager(this);
        HashMap<String, String> user = sessionManager.getUserDetail();
//        fullname = user.get(SessionManager.FULLNAME);
        bbggg= user.get(SessionManager.bloodgroup);

   /*     BottomNavigationView navigation = findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()){
                    case R.id.ic_home:
                        Intent home = new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(home);
                        break;

                    case R.id.ic_help:
                        Intent help = new Intent(getApplicationContext(),HelpActivity.class);
                        startActivity(help);
                        break;

                    case R.id.ic_settings:
                        Intent settings = new Intent(getApplicationContext(),Settings_Activity.class);
                        startActivity(settings);
                        break;

                    case R.id.ic_exit:
                        Intent logout = new Intent(getApplicationContext(),join.class);
                        startActivity(logout);
                        break;
                }


                return false;
            }
        });*/




    }

    private void LoadNotificationsList(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, NOTIFICATIONS_LIST_URL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            Log.i("tagconvertstr", "[" + response + "]");
                            JSONArray users = new JSONArray(response);
                            for (int i = 0; i < users.length(); i++) {
                                JSONObject object = users.getJSONObject(i);





                                String id = object.getString("id");
                                String name = object.getString("name");
                                String location = object.getString("location");
                                String blood_group = object.getString("blood_group");
                                String phone_number = object.getString("phone_number");


                                BloodgroupsModel BloodgroupsModel = new BloodgroupsModel(id, name, location, blood_group, phone_number);

                                mData.add(BloodgroupsModel);
                                /* error_message.setVisibility(View.GONE);*/

                            }
                            adapter = new BloodgroupsAddapter(BloodgroupActivity.this, mData);
                            recyclerView.setAdapter(adapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
//                            loading.dismiss();
//                            login.setVisibility(View.VISIBLE);
                            Toast.makeText(BloodgroupActivity.this, "failed to save........ "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        loading.dismiss();
//                        login.setVisibility(View.VISIBLE);
                        Toast.makeText(BloodgroupActivity.this, "Saving continues to  failllllllllllll"+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            protected Map<String,String> getParams()throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("bloodgroup",bbggg);
//                params.put("password",password);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}