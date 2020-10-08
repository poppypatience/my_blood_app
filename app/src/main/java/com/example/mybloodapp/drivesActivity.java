package com.example.mybloodapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
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
import com.example.mybloodapp.Adapters.drivesAddapter;
import com.example.mybloodapp.Models.BloodgroupsModel;
import com.example.mybloodapp.Models.drivesModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class drivesActivity extends AppCompatActivity {


    private static final String DRIVES_LIST_URL= "http://192.168.1.40/mybloodapp/drives.php";
    RecyclerView recyclerView;
    List<drivesModel> mData;
    drivesAddapter adapter;
    SessionManager sessionManager;
    String bbggg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.drives);

        Toolbar toolbar = findViewById(R.id.toolbar);
        /*setSupportActionBar(toolbar);*/
        recyclerView = findViewById(R.id.recyclerview);
        mData = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new drivesAddapter(this,mData);
        recyclerView.setAdapter(adapter);


Intent ggg = getIntent();
bbggg = ggg.getStringExtra("drives");

        LoadNotificationsList();

        sessionManager = new SessionManager(this);
        HashMap<String, String> user = sessionManager.getUserDetail();
//        fullname = user.get(SessionManager.FULLNAME);
        bbggg= user.get(SessionManager.bloodgroup);



    }

    private void LoadNotificationsList(){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, DRIVES_LIST_URL,

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
                                String donation_date = object.getString("donation_date");



                               drivesModel drivesModel = new drivesModel(id, name, location, donation_date);

                                mData.add(drivesModel);
                                /* error_message.setVisibility(View.GONE);*/

                            }
                            adapter = new drivesAddapter(drivesActivity.this, mData);
                            recyclerView.setAdapter(adapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
//                            loading.dismiss();
//                            login.setVisibility(View.VISIBLE);
                            Toast.makeText(drivesActivity.this, "failed to save........ "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        loading.dismiss();
//                        login.setVisibility(View.VISIBLE);
                        Toast.makeText(drivesActivity.this, "Saving continues to  fail"+error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            protected Map<String,String> getParams()throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("drives",bbggg);
//                params.put("password",password);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}