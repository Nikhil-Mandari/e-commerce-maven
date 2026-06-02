package com.java.app.service;

import com.java.app.exception.ProductExistsException;
import com.java.app.exception.ProductNotFoundException;
import com.java.app.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    // 1. Get all products
    List<Product> getAllProducts();

    // 2. Get product by ID
    Product getProductById(int id) throws ProductNotFoundException;

    // 3. Add new product
    Product addProduct(Product product) throws ProductExistsException;

    // 4. Update existing product
    Product updateProduct(Product product) throws ProductNotFoundException;

    // 5. Delete product
    boolean deleteProduct(int id) throws ProductNotFoundException;
    List<Product> getProductsByAvailability();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsWithPriceAbove(int price);
    List<String> getProductNames();
    int getCountOfProducts();
    boolean existsByCompany(String company);
    boolean areAllProductsAvailable();
    Product getFirstProduct() throws ProductNotFoundException;
    List<Product> getExpensiveProducts(int N);
    List<Product> sortbyPriceAsc();
    List<Product> sortByPriceDesc();
    double getTotalProductsValue();
    double getTotalProductsDiscountedValue();
    List<Product> getProductsAfterYear(int year);
    List<Product> getAvailableProductsWithPriceAbove(int price);
    Map<String,Long> countProductsInEachCategory();
    Map<String,List<Product>> groupByCategory();
    List<String> getUniqueProductsByCategory();
}