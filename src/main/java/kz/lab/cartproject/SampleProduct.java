package kz.lab.cartproject;

public class SampleProduct implements Product {
    private String name = "default name";
    private String category = "default category";
    private double price = 1.0;

    public SampleProduct() {

    }

    public SampleProduct(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
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
}
