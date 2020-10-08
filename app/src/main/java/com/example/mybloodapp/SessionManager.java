package com.example.mybloodapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

import static android.provider.Telephony.Carriers.PASSWORD;

public class SessionManager {
    public static final String name = "name";
    public static final String location= "location";
    public static final String bloodgroup = "bloodgroup";
    public static final String ID = "ID";
    public static final String phonenumber = "phonenumber";


    private static final String PREF_NAME = "LOGIN";
    private static final String LOGIN = "IS_LOGIN";
    public SharedPreferences.Editor editor;
    public Context context;
    SharedPreferences sharedPreferences;
    int PRIVATE_MODE = 0;

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createSession(String name, String location, String bloodgroup, String id, String phonenumber) {
        editor.putBoolean(LOGIN, true);
        editor.putString(name, name);
        editor.putString(location, location);
        editor.putString(bloodgroup, bloodgroup);
        editor.putString(ID, id);
        editor.putString(phonenumber, phonenumber);
        editor.apply();

    }

    public boolean isLogin() {
        return sharedPreferences.getBoolean(LOGIN, false);
    }

    public void checkLogin() {
        if (!this.isLogin()) {
            Intent i = new Intent(context, login.class);
            context.startActivity(i);
            ((Home) context).finish();
        }
    }

    public HashMap<String, String> getUserDetail() {
        HashMap<String, String> user = new HashMap<>();
        user.put(name, sharedPreferences.getString(name, null));
        user.put(location, sharedPreferences.getString(location, null));
        user.put(bloodgroup, sharedPreferences.getString(bloodgroup, null));
        user.put(ID, sharedPreferences.getString(ID, null));
        user.put(phonenumber, sharedPreferences.getString(phonenumber, null));


        return user;
    }

}
