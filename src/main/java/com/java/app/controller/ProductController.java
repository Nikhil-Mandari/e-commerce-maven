package com.java.app.controller;

import com.java.app.exception.ProductExistsException;
import com.java.app.exception.ProductNotFoundException;
import com.java.app.model.Product;
import com.java.app.service.ProductService;

import java.util.List;
import java.util.Map;

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    public List<Product> getProductsByAvailability() {
        return productService.getProductsByAvailability();
    }

    public List<Product> getProductsByCategory(String category) {
        return productService.getProductsByCategory(category);
    }

    public List<Product> getProductsWithPriceAbove(int price) {
        return productService.getProductsWithPriceAbove(price);
    }

    public List<String> getProductNames() {
        return productService.getProductNames();
    }

    public long getCountOfProducts() {
        return productService.getCountOfProducts();
    }

    public boolean existsByCompany(String company) {
        return productService.existsByCompany(company);
    }

    public boolean areAllProductsAvailable() {
        return productService.areAllProductsAvailable();
    }

    public Product getFirstProduct() throws ProductNotFoundException {
        return productService.getFirstProduct();
    }

    public List<String> getUniqueProductsByCategory() {
        return productService.getUniqueProductsByCategory();
    }

    public List<Product> getExpensiveProducts(int N) {
        return productService.getExpensiveProducts(N);
    }

    public List<Product> sortbyPriceAsc() {
        return productService.sortbyPriceAsc();
    }

    public List<Product> sortByPriceDesc() {
        return productService.sortByPriceDesc();
    }

    public double getTotalProductsValue() {
        return productService.getTotalProductsValue();
    }

    public double getTotalProductsDiscountedValue() {
        return productService.getTotalProductsDiscountedValue();
    }

    public List<Product> getProductsAfterYear(int year) {
        return productService.getProductsAfterYear(year);
    }

    public List<Product> getAvailableProductsWithPriceAbove(int price) {
        return productService.getAvailableProductsWithPriceAbove(price);
    }
    public Product save(Product product) throws ProductExistsException {
        return productService.addProduct(product);
    }

    public Product getById(int id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    public Product update(int id, Product product) throws ProductNotFoundException {
        return productService.updateProduct(product);
    }

    public void delete(int id) throws ProductNotFoundException {
        productService.deleteProduct(id);
    }

    public Map<String, Long> countProductsInEachCategory() {
        return productService.countProductsInEachCategory();
    }

    public Map<String, List<Product>> groupByCategory() {
        return productService.groupByCategory();
    }
}