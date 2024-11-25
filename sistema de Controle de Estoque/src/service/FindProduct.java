package service;

import model.Product;

import java.util.List;

public class FindProduct {
    List<Product> productList;

    public FindProduct(List<Product> productList) {
        this.productList = productList;
    }

    public Product productById(int id) {
        Product productById = null;

        for (Product product : productList) {
            if (product.getId().equals(id)) {
                productById = product;
                break;
            }
        }
            return productById;
    }

    public Product productByName(String name) {
        Product productByName = null;

        for (Product product : productList) {
            if (product.getName().equals(name)) {
                productByName = product;
                break;
            }
        }
        return productByName;
    }

}
