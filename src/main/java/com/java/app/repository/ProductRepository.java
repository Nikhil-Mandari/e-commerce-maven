package com.java.app.repository;

import com.java.app.model.Product;
import com.java.app.util.CsvParser;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private final List<Product> products;
    CsvParser csvParser;

    public ProductRepository(CsvParser csvParser) throws IOException {
        this.csvParser = csvParser;
        products = csvParser.getProductsFromCsv();
    }
    public List<Product> getAll(){
        return products;
    }
    public Optional<Product> getById(int id){
        return products.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }
    public Product save(Product product){
        products.add(product);
        return product;
    }
    public Product update(int id, Product product){
        products.replaceAll(p -> p.getId() == id ? product : p);
        return product;
    }
    public boolean delete(int id){
        return products.removeIf(p -> p.getId() == id);
    }
    public boolean delete(Product product){
        return products.removeIf(p -> p.getId() == product.getId());
    }



}