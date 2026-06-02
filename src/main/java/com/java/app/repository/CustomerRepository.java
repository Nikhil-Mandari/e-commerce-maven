package com.java.app.repository;

import com.java.app.model.Customer;
import com.java.app.util.CsvParser;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private final List<Customer> customers;
    CsvParser csvParser;

    public CustomerRepository(CsvParser csvParser) throws IOException{
        this.csvParser = csvParser;
        this.customers = initialCustomers();
    }

    public List<Customer> initialCustomers() throws IOException {
        return csvParser.getCustomersFromCsv();
    }

    public List<Customer> getAll() {
        return customers;
    }

    public Optional<Customer> getCustomerById(int id) {
        return customers.stream()
                .filter(customer -> customer.getId() == id)
                .findFirst();
    }
    public Optional<Customer> findById(int id) {
        return customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }


    public Customer save(Customer customer) {
        this.customers.add(customer);
        return customer;
    }

    public Customer update(int id, Customer updatedCustomer) {
        customers.replaceAll(c -> c.getId() == id ? updatedCustomer : c);
        return updatedCustomer;
    }
    public Optional<Customer> findByEmail(String email) {
        return customers.stream()
                .filter(c -> c.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }
    public boolean exists(String email) {
        return customers.stream()
                .anyMatch(c -> c.getEmail().equalsIgnoreCase(email));
    }

    public boolean delete(int id) {
        return customers.removeIf(c -> c.getId() == id);
    }
    public int size(){
        return customers.size();
    }
    public boolean delete(Customer customer){
        return customers.removeIf(c -> c.getId() == customer.getId());
    }
}