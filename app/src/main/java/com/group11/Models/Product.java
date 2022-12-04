package com.group11.Models;

import java.io.Serializable;

public class Product  implements Serializable {
    int productId;
    String productName;
    int image;
    String productPrice;

    public Product(int productId, String productName, int image, String productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.image = image;
        this.productPrice = productPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
