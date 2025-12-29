package kz.lab.cartproject.CartContext;

import java.util.ArrayList;
import java.util.stream.IntStream;

import kz.lab.cartproject.Product;
import kz.lab.cartproject.ProductUtil;

public class CartCtx {
    private ArrayList<CartProduct> products;

    public CartCtx() {
        products = new ArrayList<CartProduct>();
    }

    public boolean addProduct(Product item) {
        if (ProductUtil.checkProduct(item) == false)
            return false;

        int idx = IntStream.range(0, products.size())
                .filter(i -> products.get(i).getName().equals(item.getName()))
                .findFirst()
                .orElse(-1);

        if (idx != -1) {
            CartProduct product = products.get(idx);
            product.setQuanity(product.getQuanity() + 1);

            return true;
        } else {
            CartProduct cp = new CartProduct(item.getName(), item.getCategory(), item.getPrice());
            products.add(cp);

            return true;
        }
    }

    public boolean removeProduct(Product item) {
        if (item == null)
            return true;

        int idx = IntStream.range(0, products.size())
                .filter(i -> products.get(i).getName().equals(item.getName()))
                .findFirst()
                .orElse(-1);

        if (idx != -1) {
            products.remove(idx);
        }

        return true;
    }

    public Product[] getProducts() {
        return products.toArray(new Product[0]);
    }
}
