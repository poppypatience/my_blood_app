package com.example.mybloodapp.Models;

public class drivesModel {
    String id,names,location,donation_date;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDonation_date() {
        return donation_date;
    }

    public void setDonation_date(String donation_date) {
        this.donation_date = donation_date;
    }


    public drivesModel(String id, String names, String location, String donation_date) {
        this.id = id;
        this.names = names;
        this.location = location;
        this.donation_date = donation_date;

    }
}
