package com.example.mybloodapp.Models;

public class DonorsModel {
    String id,names,email,phone,username,password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DonorsModel(String id, String names, String email, String phone, String username, String password) {
        this.id = id;
        this.names = names;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }
}
