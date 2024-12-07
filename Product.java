package Calsses;

import Interfaces.IProduct;

public class Product implements IProduct {

    private int id;
    private String name;
    private double price;
    private double profit;

    public Product(int id, String name, double price, double profit) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.profit = profit;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getProfit() {
        return profit;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
