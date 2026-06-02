package com.java.app.controller;

import com.java.app.enums.Membership;
import com.java.app.exception.CustomerExistsException;
import com.java.app.exception.CustomerNotFoundException;
import com.java.app.model.Customer;
import com.java.app.service.CustomerService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public Customer getCustomerById(int id) throws CustomerNotFoundException {
        return customerService.getCustomerById(id);
    }

    public void addCustomer(Customer customer) throws CustomerExistsException {
        customerService.addCustomer(customer);
    }

    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
        return customerService.updateCustomer(customer);
    }

    public boolean deleteCustomer(Customer customer) throws CustomerNotFoundException {
        return customerService.deleteCustomer(customer);
    }

    public List<Customer> getActiveCustomers() {
        return customerService.getActiveCustomers();
    }

    public List<Customer> getCustomersByMembership(Membership membership) {
        return customerService.getCustomersByMembership(membership);
    }

    public List<Customer> getCustomersGreaterThan(int age) {
        return customerService.getCustomersGreaterThan(age);
    }

    public List<String> getCustomerNames() {
        return customerService.getCustomerNames();
    }

    public int getActiveCustomersCount() {
        return customerService.getActiveCustomersCount();
    }

    public boolean isAllCustomersActive() {
        return customerService.isAllCustomersActive();
    }

    public Optional<Customer> getFirstCustomer() throws CustomerNotFoundException {
        return customerService.getFirstCustomer();
    }

    public List<Membership> getUniqueMembership() {
        return customerService.getUniqueMembership();
    }

    public List<Customer> getOldestCustomers(int N) {
        return customerService.getOldestCustomers(N);
    }

    public List<Customer> sortCustomerByAge() {
        return customerService.sortCustomerByAge();
    }

    public List<Customer> sortCustomersByName() {
        return customerService.sortCustomersByName();
    }

    public double getAverageAge() {
        return customerService.getAverageAge();
    }

    public Map<Membership, Long> getTotalCustomersForEachMembershipType() {
        return customerService.getTotalCustomersForEachMembershipType();
    }
}