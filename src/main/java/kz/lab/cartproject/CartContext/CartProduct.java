package kz.lab.cartproject.CartContext;

import kz.lab.cartproject.Product;

public class CartProduct implements Product {
    private String name = "default name";
    private String category = "default category";
    private double price = 1.0;
    private int quanity = 1;

    public CartProduct() {

    }

    public CartProduct(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public CartProduct(String name, String category, double price, int quanity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quanity = quanity;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }
}
