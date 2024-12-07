package Interfaces;

import java.util.List;

public interface ICategory {

    int getId();
    String getName();
    List<IProduct> getProducts();
    void addProduct(IProduct product);
}
