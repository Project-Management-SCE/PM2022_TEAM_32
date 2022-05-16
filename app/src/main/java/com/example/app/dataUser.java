package com.example.app;

public class dataUser {
    private String address;
    private String city;
    private String time;
    private String date;
    private String name;


    //Constructors
    public dataUser() {}
    public dataUser(String address, String city, String time, String date, String name) {
        this.address = address;
        this.city = city;
        this.time = time;
        this.date = date;
        this.name = name;
    }

    //Getters and Setters
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

}
