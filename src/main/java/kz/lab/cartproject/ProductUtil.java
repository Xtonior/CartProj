package kz.lab.cartproject;

public class ProductUtil {
    public static boolean checkProduct(Product item) {
        if (item.getName() == null || item.getName().isBlank())
            return false;
        if (item.getCategory() == null || item.getCategory().isBlank())
            return false;
        if (item.getPrice() <= 0.0)
            return false;

        return true;
    }
}
