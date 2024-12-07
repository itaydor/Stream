package Interfaces;

import javafx.util.Pair;

import java.util.List;

public interface ICompany {
    int getId();
    String getName();
    List<ICategory> getCategories();
    void addCategory(ICategory category);
    List<IProduct> getProductsWithMultipleCategories();
    Pair<String, Double> getCategoryWithTotalHighestPrice();
    List<Pair<String, Double>> getCategoriesTotalPriceList();
    List<Pair<String, Integer>> getCategoriesNumberOfProductsList();
    Pair<String, Double> getCategoryWithHighestAvgProfit();
    List<Pair<IProduct, List<ICategory>>> getProductCategoriesList();
}

