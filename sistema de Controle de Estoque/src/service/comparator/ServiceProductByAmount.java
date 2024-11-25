package service.comparator;

import model.Product;

import java.util.Comparator;

public class ServiceProductByAmount implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {

        return Integer.compare(o1.getAmount(), o2.getAmount());
    }
}
