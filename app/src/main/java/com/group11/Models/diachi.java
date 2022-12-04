package com.group11.Models;

public class diachi {
    int diachiID;
     String HoTen;
     String DiaChi;
     String SDT;
     String loai;

    public diachi(int anInt, String hoTen, String diaChi, String SDT, String loai) {
        this.diachiID = diachiID;
        HoTen = hoTen;
        DiaChi = diaChi;
        this.SDT = SDT;
        this.loai = loai;
    }

    public String getHoTen() {
        return HoTen;
    }

    public int getdiachiID() {
        return diachiID;
    }

    public void setdiachiID(int productID) {
        this.diachiID = productID;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
}