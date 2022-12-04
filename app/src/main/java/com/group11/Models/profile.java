package com.group11.Models;

public class profile {
    int ProfileID;
    String Ten;
    String Ho;
    String Email;
    String SDT;

    public profile(int profileID, String ten, String ho, String email, String SDT) {
        this.ProfileID = profileID;
        Ten = ten;
        Ho = ho;
        Email = email;
        this.SDT = SDT;
    }

    public int getProfileID() {
        return ProfileID;
    }

    public void setProfileID(int profileID) {
        this.ProfileID = profileID;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String ho) {
        Ho = ho;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
}
