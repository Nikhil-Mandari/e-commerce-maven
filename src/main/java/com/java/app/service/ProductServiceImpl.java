package com.java.app.service;

import com.java.app.exception.ProductExistsException;
import com.java.app.exception.ProductNotFoundException;
import com.java.app.model.Product;
import com.java.app.repository.ProductRepository;

import java.nio.file.ProviderNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 1. GET ALL
    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAll();
    }

    // 2. GET BY ID
    @Override
    public Product getProductById(int id) throws ProductNotFoundException {
        return productRepository.getById(id).orElseThrow(() -> new ProductNotFoundException("product not found"));
    }

    // 3. ADD PRODUCT
    @Override
    public Product addProduct(Product product) throws ProductExistsException {
        return productRepository.save(product);
    }

    // 4. UPDATE PRODUCT
    @Override
    public Product updateProduct(Product product) throws ProductNotFoundException {
        return productRepository.update(product.getId(), product);
    }

    // 5. DELETE PRODUCT
    @Override
    public boolean deleteProduct(int id) throws ProductNotFoundException {
        return productRepository.delete(id);
    }
    public List<Product> getProductsByAvailability() {
        return productRepository.getAll().stream()
                .filter(p -> p.isAvailable() == true)
                .toList();
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.getAll().stream()
                .filter(p -> p.getCategory().equals(category))
                .toList();
    }

    public List<Product> getProductsWithPriceAbove(int price) {
        return productRepository.getAll().stream()
                .filter(p -> p.getMaxRetailPrice() > price)
                .toList();
    }

    public List<String> getProductNames() {
        return productRepository.getAll().stream()
                .map(p -> p.getName())
                .toList();
    }

    public int getCountOfProducts() {
        return (int) productRepository.getAll().stream()
                .count();
    }

    public boolean existsByCompany(String company) {
        return productRepository.getAll().stream()
                .anyMatch(p -> p.getCompany().equals(company));
    }

    public boolean areAllProductsAvailable() {
        return productRepository.getAll().stream()
                .allMatch(p -> p.isAvailable());
    }

    public Product getFirstProduct() throws ProviderNotFoundException {
        return productRepository.getAll().stream().findFirst().orElseThrow(() -> new ProviderNotFoundException());
    }

    public List<String> getUniqueProductsByCategory() {
        return productRepository.getAll().stream()
                .map(product -> product.getCategory())
                .distinct()
                .toList();
    }

    public List<Product> getExpensiveProducts(int N) {
        return productRepository.getAll().stream()
                .sorted((p1, p2) -> Double.compare(p2.getMaxRetailPrice(), p1.getMaxRetailPrice()))
                .limit(N)
                .toList();
    }

    public List<Product> sortbyPriceAsc() {
        return productRepository.getAll().stream()
                .sorted(Comparator.comparing(Product::getMaxRetailPrice))
                .toList();
    }

    public List<Product> sortByPriceDesc() {
        return productRepository.getAll().stream()
                .sorted(Comparator.comparing(Product::getMaxRetailPrice).reversed())
                .toList();
    }

    public double getTotalProductsValue() {
        return productRepository.getAll().stream()
                .map(Product::getMaxRetailPrice)
                .reduce(0.0, Double::sum);
    }

    public double getTotalProductsDiscountedValue() {
        return productRepository.getAll().stream()
                .map(product -> product.getMaxRetailPrice() * product.getDiscountPercentage() / 100)
                .reduce(0.0, Double::sum);
    }

    public List<Product> getProductsAfterYear(int year) {
        return productRepository.getAll().stream()
                .filter(product -> product.getManufacturedYear() > year)
                .toList();
    }

    public List<Product> getAvailableProductsWithPriceAbove(int price) {
        return getProductsByAvailability().stream()
                .filter(product -> product.getMaxRetailPrice() > price)
                .toList();
    }

    public Map<String,Long> countProductsInEachCategory() {
        return productRepository.getAll()
                .stream()
                .collect(Collectors.groupingBy(Product::getCategory,Collectors.counting()));
    }
    public Map<String,List<Product>> groupByCategory(){
        return productRepository.getAll()
                .stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }
}