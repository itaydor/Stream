package Calsses;

import Interfaces.ICategory;
import Interfaces.IProduct;

import java.util.ArrayList;
import java.util.List;

public class Category implements ICategory {
    private int id;
    private String name;
    private List<IProduct> products;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
        products = new ArrayList<>();
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
    public List<IProduct> getProducts() {
        return products;
    }

    @Override
    public void addProduct(IProduct product) {
        products.add(product);
    }
}
