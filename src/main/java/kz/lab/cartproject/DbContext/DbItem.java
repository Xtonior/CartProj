package kz.lab.cartproject.DbContext;

import kz.lab.cartproject.Product;

public class DbItem implements Product {
    private String name;
    private String category;
    private double price;

    public DbItem(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String toJson() {
        return String.format("{\"name\":\"%s\",\"category\":\"%s\",\"price\":%s}",
                name, category, price);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public double getPrice() {
        return price;
    }
}