package kz.lab.cartproject.StoreContext;

import kz.lab.cartproject.Product;
import kz.lab.cartproject.ProductUtil;
import kz.lab.cartproject.Repository;

public class StoreCtx {
    private final Repository db;

    public StoreCtx(Repository repository) {
        db = repository;
    }

    public boolean addProduct(Product item) {
        if (ProductUtil.checkProduct(item) == false) return false;

        if (db == null)
            throw new NullPointerException();

        return db.writeProduct(item);
    }

    public boolean removeProduct(Product item) {
        if (item == null)
            return true;
        if (db == null)
            throw new NullPointerException();

        return db.removeProduct(item);
    }

    public Product getProduct(String name) {
        if (name == null || name.isBlank())
            return null;
        if (db == null)
            throw new NullPointerException();

        return db.selectProduct(name);
    }
}
