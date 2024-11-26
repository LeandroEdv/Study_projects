package app;

import model.Product;
import reportService.InventoryService;
import reportService.report.ReportService;

public class Main {
    public static void main(String[] args) {
        InventoryService inventoryService = new InventoryService();
        inventoryService.addProduct(new Product(04,"Pc - Gamer",1500.15,15,1));
        inventoryService.addProduct(new Product(03,"Pc - Gamer X",2000.15,5,1));
        inventoryService.addProduct(new Product(02,"noteBook",1000.15,20,1));
        inventoryService.addProduct(new Product(01,"noteBook - Gamer",1000.15,2,2));

        ReportService reportService = new ReportService(inventoryService);


        //System.out.println(inventoryService.getProductList());
        //inventoryService.deleteProductById(01);
        //inventoryService.updateAmongProductById(05,6);
        System.out.println(inventoryService.productByName("Pc - Gamer"));
        //System.out.println(inventoryService.productById(2));

        //inventoryService.decrementProduct(01);

        //System.out.println(reportService.invetaryTotalPrice());
        //System.out.println(reportService.listProductByAmount());
        //System.out.println(reportService.listProductByName());
       // for (Product product : reportService.listProductByName()) {
       //     System.out.println(product);
       // }

        //System.out.println(inventoryService.getProductList());



    }
}