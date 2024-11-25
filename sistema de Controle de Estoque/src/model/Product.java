package model;

import java.util.Objects;

public class Product implements Comparable<Product> {

    private Integer id;
    private String name;
    private double price;
    private int amount;
    private int minAmount;

    public Product(int id, String name, double price, int amount, int minAmount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.minAmount = minAmount;
    }


    @Override
    public int compareTo(Product o) {
        return id.compareTo(o.getId());
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0){
            this.price = price;
        }else {
            System.out.println("The price of the product cannot be less than zero");
        }
    }

    public int getAmount() {
        return amount;

    }

    public void setAmount(int amount) {
        if (amount >= 0){
            this.amount = amount;
        }else {
            System.out.println("The amount of the product cannot be less than zero");
        }
    }

    public int getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(int minAmount) {
        if (minAmount >= 0){
            this.minAmount = minAmount;
        }else {
            System.out.println("The min amount of the product cannot be less than zero");
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", nimAmont=" + minAmount +
                '}';
    }
}
