package service.comparator;

import model.Product;

import java.util.Comparator;

public class ServiceProductByName implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
