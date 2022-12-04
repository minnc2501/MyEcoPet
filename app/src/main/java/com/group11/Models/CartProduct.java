package com.group11.Models;

public class CartProduct {
    int photo;
    String name;
    int quantity;
    double price;
    //Constructor

    public CartProduct(int photo, String name, int quantity, double price) {
        this.photo = photo;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    //Getter and Setter

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
