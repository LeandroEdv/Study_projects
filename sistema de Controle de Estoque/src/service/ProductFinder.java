package service;

import model.Product;

import java.util.List;
import java.util.function.Predicate;

public class ProductFinder {
    List<Product> productList;

    public ProductFinder(List<Product> productList) {
        this.productList = productList;
    }

    public Product findProduct(Predicate<Product> predicate) {
        Product productFound = null;
        for (Product product : productList) {
            if (predicate.test(product)) {
                productFound = product;
                break;
            }
        }
        return productFound;
    }

    public Product productById(int id) {
      return findProduct(product -> product.getId().equals(id));
    }

    public Product productByName(String name) {
        return findProduct(product -> product.getName().equals(name));
    }

}
