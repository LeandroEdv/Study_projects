package service;

import model.Product;
import service.comparator.ServiceProductByAmount;
import service.comparator.ServiceProductByName;
import service.comparator.ServiceProductByPrice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortProducts {
    List<Product> productList;

    public SortProducts(List<Product> productList) {
        this.productList = productList;
    }

    private List<Product> sortedList(Comparator comparator){
        List<Product> products= new ArrayList<>(productList);
        products.sort(comparator);
        return products;
    }

    public List<Product> listProductByName(){

        return sortedList(new ServiceProductByName()) ;
    }

    public List<Product> listProductByPrice(){

        return sortedList(new ServiceProductByPrice());
    }

    public List<Product> listProductByAmount(){
        return sortedList(new ServiceProductByAmount());
    }

    public List<Product> getProductList() {
        return productList;
    }
}
