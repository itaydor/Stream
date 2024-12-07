import java.util.List;
import Interfaces.*;
import Calsses.*;
import javafx.util.Pair;

public class Main {
    public static void main(String[] args) {
        // Create products
        IProduct product1 = new Product(1, "Laptop", 999.99, 200.00);
        IProduct product2 = new Product(2, "Novel", 19.99, 5.00);
        IProduct product3 = new Product(3, "T-shirt", 14.99, 3.00);
        IProduct product4 = new Product(4, "Smartphone", 699.99, 150.00);
        IProduct product5 = new Product(5, "Tablet", 299.99, 50.00);
        IProduct product6 = new Product(6, "Headphones", 49.99, 10.00);
        IProduct product7 = new Product(7, "E-reader", 129.99, 20.00);
        IProduct product8 = new Product(8, "Jacket", 89.99, 15.00);
        IProduct product9 = new Product(9, "Shoes", 59.99, 10.00);

        // Create categories and add products
        ICategory electronics = new Category(1, "Electronics");
        electronics.addProduct(product1);
        electronics.addProduct(product4);
        electronics.addProduct(product5);

        ICategory books = new Category(2, "Books");
        books.addProduct(product2);
        books.addProduct(product7);

        ICategory clothing = new Category(3, "Clothing");
        clothing.addProduct(product3); // Same product in multiple categories
        clothing.addProduct(product8);
        clothing.addProduct(product9);

        ICategory gadgets = new Category(4, "Gadgets");
        gadgets.addProduct(product1);
        gadgets.addProduct(product4);
        gadgets.addProduct(product6);

        ICategory apparel = new Category(5, "Apparel");
        apparel.addProduct(product3); // Same product in multiple categories
        apparel.addProduct(product8);
        apparel.addProduct(product9); // Same product in multiple categories

        ICategory accessories = new Category(6, "Accessories");
        accessories.addProduct(product6);
        accessories.addProduct(product7);
        accessories.addProduct(product9); // Same product in multiple categories

        // Create companies and add categories
        Company company1 = new Company(1, "TechBooksClothing Inc.");
        company1.addCategory(electronics);
        company1.addCategory(books);
        company1.addCategory(clothing);

        Company company2 = new Company(2, "GadgetsApparelAccessories Ltd.");
        company2.addCategory(gadgets);
        company2.addCategory(apparel);
        company2.addCategory(accessories);

        // Get products with multiple categories for each company
        List<IProduct> productsWithMultipleCategoriesCompany1 = company1.getProductsWithMultipleCategories();
        List<IProduct> productsWithMultipleCategoriesCompany2 = company2.getProductsWithMultipleCategories();

        System.out.println("Company 1 - Products with multiple categories: " + productsWithMultipleCategoriesCompany1);
        System.out.println("Company 2 - Products with multiple categories: " + productsWithMultipleCategoriesCompany2);

        // Get the category with the highest total price for each company
        Pair<String, Double> highestPriceCategoryCompany1 = company1.getCategoryWithTotalHighestPrice();
        Pair<String, Double> highestPriceCategoryCompany2 = company2.getCategoryWithTotalHighestPrice();

        System.out.println("Company 1 - Category with highest total price: " + highestPriceCategoryCompany1);
        System.out.println("Company 2 - Category with highest total price: " + highestPriceCategoryCompany2);

        // Get the list of categories with their total prices for each company
        List<Pair<String, Double>> categoriesTotalPriceListCompany1 = company1.getCategoriesTotalPriceList();
        List<Pair<String, Double>> categoriesTotalPriceListCompany2 = company2.getCategoriesTotalPriceList();

        // Print the results in a readable format
        System.out.println("Company 1 - Categories with total prices:");
        categoriesTotalPriceListCompany1.forEach(pair ->
                System.out.println("Category: " + pair.getKey() + ", Total Price: " + pair.getValue()));

        System.out.println("Company 2 - Categories with total prices:");
        categoriesTotalPriceListCompany2.forEach(pair ->
                System.out.println("Category: " + pair.getKey() + ", Total Price: " + pair.getValue()));

        // Get the list of categories with their number of products for each company
        List<Pair<String, Integer>> categoriesNumberOfProductsListCompany1 = company1.getCategoriesNumberOfProductsList();
        List<Pair<String, Integer>> categoriesNumberOfProductsListCompany2 = company2.getCategoriesNumberOfProductsList();

        // Print the results in a readable format
        System.out.println("Company 1 - Categories with number of products:");
        categoriesNumberOfProductsListCompany1.forEach(pair ->
                System.out.println("Category: " + pair.getKey() + ", Number of Products: " + pair.getValue()));

        System.out.println("Company 2 - Categories with number of products:");
        categoriesNumberOfProductsListCompany2.forEach(pair ->
                System.out.println("Category: " + pair.getKey() + ", Number of Products: " + pair.getValue()));

        Pair<String, Double> highestAvgProfitCategoryCompany1 = company1.getCategoryWithHighestAvgProfit();
        Pair<String, Double> highestAvgProfitCategoryCompany2 = company2.getCategoryWithHighestAvgProfit();

        System.out.println("Company 1 - Category with highest average profit: " + highestAvgProfitCategoryCompany1.getKey() + " with average profit: " + highestAvgProfitCategoryCompany1.getValue());
        System.out.println("Company 2 - Category with highest average profit: " + highestAvgProfitCategoryCompany2.getKey() + " with average profit: " + highestAvgProfitCategoryCompany2.getValue());

        List<Pair<IProduct, List<ICategory>>> productCategoriesListCompany1 = company1.getProductCategoriesList();
        System.out.println("Company 1 - Product categories list:");
        productCategoriesListCompany1.forEach(pair -> {
            System.out.print("Product: " + pair.getKey().getName() + " - Categories: ");
            pair.getValue().forEach(category -> System.out.print(category.getName() + " "));
            System.out.println();
        });

        List<Pair<IProduct, List<ICategory>>> productCategoriesListCompany2 = company2.getProductCategoriesList();
        System.out.println("Company 2 - Product categories list:");
        productCategoriesListCompany2.forEach(pair -> {
            System.out.print("Product: " + pair.getKey().getName() + " - Categories: ");
            pair.getValue().forEach(category -> System.out.print(category.getName() + " "));
            System.out.println();
        });


    }
}
