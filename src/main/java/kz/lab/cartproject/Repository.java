package kz.lab.cartproject;

public interface Repository {
    boolean writeProduct(Product product);
    boolean removeProduct(Product product);

    Product selectProduct(String name);
}
