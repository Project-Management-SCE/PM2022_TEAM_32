package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

public class UsersDataModel {

    String email, userName, profile;

    //empty constructor required for firebase
    public UsersDataModel() {}

    //constructor for our object class.
    public UsersDataModel(String email, String userName, String profile) {
        this.email = email;
        this.userName = userName;
        this.profile = profile;
    }

    //getter and setter methods
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return userName;
    }
    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getProfile() {
        return profile;
    }
    public void setProfile(String profile) {
        this.profile = profile;
    }
}
