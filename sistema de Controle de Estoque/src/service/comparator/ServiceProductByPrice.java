package service.comparator;

import model.Product;

import java.util.Comparator;

public class ServiceProductByPrice implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {

        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
