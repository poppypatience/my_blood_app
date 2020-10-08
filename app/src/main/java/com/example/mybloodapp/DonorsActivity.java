package com.example.mybloodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mybloodapp.Adapters.DonorsAddapter;
import com.example.mybloodapp.Models.DonorsModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class DonorsActivity extends AppCompatActivity {
    private static final String DONORS_LIST ="http://192.168.1.40/salapp/getdonors.php";
    RecyclerView recyclerView;
    List<DonorsModel> mData;
    DonorsAddapter addapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.recyclerview);
        mData = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        addapter = new DonorsAddapter(this,mData);
        recyclerView.setAdapter(addapter);

        Loaddonorslist();



    }

    private void  Loaddonorslist(){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, DONORS_LIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONArray donors = new JSONArray(response);
                            for (int i = 0; i < donors.length(); i++) {
                                JSONObject object = donors.getJSONObject(i);
                                String id = object.getString("id");
                                String names = object.getString("names");
                                String email = object.getString("email");
                                String phone = object.getString("phone");
                                String username = object.getString("username");
                                String password = object.getString("password");

                                DonorsModel donorsModel = new DonorsModel(id, names, email, phone, username, password);
                                mData.add(donorsModel);


                            }
                            addapter = new DonorsAddapter(DonorsActivity.this, mData);
                            recyclerView.setAdapter(addapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Donors list un available" + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Donors list un available" + error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        Volley.newRequestQueue(this).add(stringRequest);
    }

}