package com.example.task.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.task.UserModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


public class SharedPref {
    Context context;
    public SharedPref(Context context) {
        this.context = context;
    }

    ///////////////////////////////////////////user login///////////////////////////////////////////////
    public Boolean userIsLogin() {
        SharedPreferences sharedPref = context.getSharedPreferences("userLogin", MODE_PRIVATE);
        return sharedPref.getBoolean("userLogin", false);
    }
    public void setUserLogin(Boolean islogin) {
        SharedPreferences sharedPref = context.getSharedPreferences("userLogin", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.putBoolean("userLogin", islogin);
        editor.apply();
    }
    ///////////////////////////////////////////user info//////////////////////////////////////////////////////////
    public String getUserInfo() {
        SharedPreferences sharedPref = context.getSharedPreferences("userInfo", MODE_PRIVATE);
        return sharedPref.getString("userInfo", null);
    }
    public void setUserinfo(String  userInfo) {
        SharedPreferences sharedPref = context.getSharedPreferences("userInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.putString("userInfo", userInfo);
        editor.apply();
    }
    ///////////////////////////////////////////all users //////////////////////////////
    public void saveUserObject(UserModel list){
        SharedPreferences prefs = context.getSharedPreferences("allUsers", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        ArrayList<UserModel> arr;
        if (getAllUsers()==null)
         arr = new ArrayList<>();
        else
         arr = getAllUsers();
        arr.add(list);
        String json = gson.toJson(arr);
        editor.putString("allUsers", json);
        editor.apply();
    }

    public ArrayList<UserModel> getAllUsers(){
        SharedPreferences prefs = context.getSharedPreferences("allUsers", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("allUsers", null);
        Type type = new TypeToken<ArrayList<UserModel>>() {}.getType();
        return gson.fromJson(json, type);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
}