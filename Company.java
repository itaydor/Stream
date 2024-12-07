package Calsses;

import Interfaces.ICategory;
import Interfaces.ICompany;
import Interfaces.IProduct;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Company implements ICompany {
    private int id;
    private String name;
    private List<ICategory> categories;

    public Company(int id, String name) {
        this.id = id;
        this.name = name;
        categories = new ArrayList<>();
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
    public List<ICategory> getCategories() {
        return categories;
    }

    @Override
    public void addCategory(ICategory category){
        categories.add(category);
    }

    @Override
    public List<IProduct> getProductsWithMultipleCategories() {
        return categories.stream()
                .flatMap(c -> c.getProducts().stream())
                .collect(Collectors.groupingBy(IProduct::getId))
                .values().stream()
                .filter(iProducts -> iProducts.size() > 1)
                .map(iProducts -> iProducts.get(0))
                .collect(Collectors.toList());
    }

    @Override
    public Pair<String, Double> getCategoryWithTotalHighestPrice() {
        return categories.stream()
                .map(c -> new Pair<>(c.getName(),
                        c.getProducts().stream().mapToDouble(IProduct::getPrice).sum()))
                .max(Comparator.comparingDouble(Pair::getValue))
                .orElse(new Pair<>(null, 0.0));
    }

    @Override
    public List<Pair<String, Double>> getCategoriesTotalPriceList() {
        return categories.stream()
                .map(c -> new Pair<>(c.getName(),
                        c.getProducts().stream().mapToDouble(IProduct::getPrice).sum()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Pair<String, Integer>> getCategoriesNumberOfProductsList() {
        return categories.stream()
                .map(c -> new Pair<>(c.getName(),
                        c.getProducts().size()))
                .collect(Collectors.toList());
    }

    @Override
    public Pair<String, Double> getCategoryWithHighestAvgProfit() {
        return categories.stream()
                .map(c -> new Pair<>(c.getName(),
                        c.getProducts().stream()
                                .mapToDouble(IProduct::getProfit)
                                .average()
                                .orElse(-1)
                ))
                .max(Comparator.comparingDouble(Pair::getValue))
                .orElse(new Pair<>("NO CATEGORY", -1.0));
    }

    @Override
    public List<Pair<IProduct, List<ICategory>>> getProductCategoriesList() {
        return categories.stream()
                .flatMap(c -> c.getProducts().stream()
                        .map(p -> new Pair<>(p, c)))
                .collect(Collectors.groupingBy(
                        Pair::getKey,
                        Collectors.mapping(Pair::getValue, Collectors.toList())))
                .entrySet().stream()
                .map(e -> new Pair<>(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }
}
