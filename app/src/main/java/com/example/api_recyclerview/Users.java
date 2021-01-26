package com.example.api_recyclerview;

public class Users {

    private String fname;
    private String lname;
    private String email;
    private String img_url;

//    public Users(String fname, String lname, String email) {
//        this.fname = fname;
//        this.lname = lname;
//        this.email = email;
//    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
