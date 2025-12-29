package kz.lab.cartproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import kz.lab.cartproject.CartContext.CartCtx;
import kz.lab.cartproject.CartDealContext.CartDealCtx;
import kz.lab.cartproject.DbContext.DbCtx;
import kz.lab.cartproject.StoreContext.StoreCtx;

public class Main {
    public static void main(String[] args) {
        Repository dbRepository = new DbCtx();
        StoreCtx store = new StoreCtx(dbRepository);
        CartCtx cart = new CartCtx();
        CartDealCtx cartDeal = new CartDealCtx();

        store.addProduct((Product) new SampleProduct("Apple", "Food", 10.0));
        store.addProduct((Product) new SampleProduct("Pear", "Food", 15.0));
        store.addProduct((Product) new SampleProduct("Bread", "Food", 12.0));

        store.addProduct((Product) new SampleProduct("Laptop", "Tech", 1200.0));
        store.addProduct((Product) new SampleProduct("Smartphone", "Tech", 800.0));

        cart.addProduct(store.getProduct("Apple"));
        cart.addProduct(store.getProduct("Apple"));

        cart.addProduct(store.getProduct("Pear"));
        cart.addProduct(store.getProduct("Laptop"));
        cart.addProduct(store.getProduct("Smartphone"));

        ArrayList<Product> list = new ArrayList<>(Arrays.asList(cart.getProducts()));
        cartDeal.updateProducts(list);

        Product[] sprods = cartDeal.search(15.0);
        
        System.out.println("\nSearch by price:");
        for (Product product : sprods) {
            System.out.printf("%s: %.2f\n", product.getName(), product.getPrice());
        }

        Map<String,Integer> mp = cartDeal.getGroupedItems();

        System.out.println("\nGroup by price:");
        for (String name : mp.keySet()) {
            System.out.printf("%s: %d\n", name, mp.get(name));
        }
    }
}