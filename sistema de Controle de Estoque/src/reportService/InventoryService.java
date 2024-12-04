package reportService;

import model.Product;
import service.ProductFinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryService {

    private List<Product> productList;
    ProductFinder productFinder;

    public InventoryService() {
        this.productList = new ArrayList();
        productFinder = new ProductFinder(productList);
    }

    public List<Product> getProductList() {
        Collections.sort(productList);
        return productList;
    }

    public void addProduct(Product product) {
        if (!productList.contains(product)) {
            this.productList.add(product);
        } else {
            System.out.println("Product with id:" + product.getId() + "already registered");
        }
    }

    public Product productById(int id) {

        return productFinder.productById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product id: " + id + " not found"));
    }

    public Product productByName(String name) {

        return productFinder.productByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Product: " + name + " not found"));
    }

    public void deleteProductById(int id) {

        Product productToDelete = productById(id);
        if (productToDelete != null) {
            productList.remove(productToDelete);
            System.out.println("product: " + productToDelete.getName() + " deleted successfully");
        } else {
            System.out.println("Product not found with ID: " + id);
        }
    }

    public void updateProductAmount(int id, int newAmount) {

        Product productToUpdate = productById(id);
        if (productToUpdate != null) {
            productToUpdate.setAmount(newAmount);
        } else {

            System.out.println("Product not found with ID: " + id);

        }
    }

    public void decrementProduct(int id) {
        Product product = productById(id);
        if (product != null) {
            product.setAmount(product.getAmount() - 1);
        }

    }

}
