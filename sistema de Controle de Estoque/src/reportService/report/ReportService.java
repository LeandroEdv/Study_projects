package reportService.report;

import model.Product;
import reportService.InventoryService;
import service.SortProducts;

import java.util.List;

public class ReportService {
    InventoryService inventoryService;
    private SortProducts sortProducts;

    public ReportService(InventoryService inventoryService) {

        this.inventoryService = inventoryService;
        this.sortProducts = new SortProducts(this.inventoryService.getProductList());
    }

    public List<Product> listProductByName(){

        return sortProducts.listProductByName();
    }

    public List<Product> listProductByPrice(){

        return sortProducts.listProductByPrice();
    }

    public List<Product> listProductByAmount(){

        return sortProducts.listProductByAmount();
    }

    public double inventoryTotalPrice(){

        return inventoryService.getProductList()
                .stream()
                .mapToDouble(i -> i.getAmount() * i.getPrice())
                .sum();

    }

}
