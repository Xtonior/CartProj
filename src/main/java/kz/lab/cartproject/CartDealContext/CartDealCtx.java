package kz.lab.cartproject.CartDealContext;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

import kz.lab.cartproject.Product;
import kz.lab.cartproject.CartContext.CartProduct;

public class CartDealCtx {
    ArrayList<Product> products;

    public CartDealCtx() {
        products = new ArrayList<Product>();
    }

    public void updateProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public Product[] search(double price) {
        return products.stream()
                .filter(x -> x.getPrice() >= price)
                .toArray(Product[]::new);
    }

    public Map<String, Integer> getGroupedItems() {
        return products.stream()
                .filter(p -> p instanceof CartProduct)
                .map(p -> (CartProduct) p)
                .collect(Collectors.groupingBy(
                        Product::getName,
                        Collectors.summingInt(p -> ((CartProduct) p).getQuanity())));
    }
}
