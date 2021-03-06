package com.example.dream_house2.Modules;


public class User {
    private String gmail;
    private String password;
    private String name;
    private String image;
    private String phone;
    private String date;

    public User() {
    }

    public User(String gmail, String password, String name, String image, String phone, String date) {
        this.gmail = gmail;
        this.password = password;
        this.name = name;
        this.image = image;
        this.phone = phone;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
