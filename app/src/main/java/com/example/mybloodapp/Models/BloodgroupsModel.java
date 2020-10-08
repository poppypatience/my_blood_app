package com.example.mybloodapp.Models;

public class BloodgroupsModel {
    String id,name,location,phonenumber,bloodgroup;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setNames(String names) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }


    public BloodgroupsModel(String id, String name, String location, String phonenumber, String bloodgroup) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phonenumber = phonenumber;
        this.bloodgroup = bloodgroup;
    }
}
