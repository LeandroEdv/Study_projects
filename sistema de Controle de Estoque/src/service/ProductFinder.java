package service;

import model.Product;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProductFinder {
    List<Product> productList;

    public ProductFinder(List<Product> productList) {
        this.productList = productList;
    }

    public Optional<Product> findProduct(Predicate<Product> predicate) {
        Product productFound = null;
        for (Product product : productList) {
            if (predicate.test(product)) {
                productFound = product;
                break;
            }
        }
        return Optional.ofNullable(productFound);
    }

    public Optional<Product> productById(int id) {
      return findProduct(product -> product.getId().equals(id));
    }

    public Optional<Product> productByName(String name) {
        return findProduct(product -> product.getName().equals(name));
    }

}
