package com.java.app.service;

import com.java.app.enums.Membership;
import com.java.app.exception.CustomerExistsException;
import com.java.app.exception.CustomerNotFoundException;
import com.java.app.model.Customer;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CustomerService {

    List<Customer> getAllCustomers();
    Customer getCustomerById(int id) throws CustomerNotFoundException;
    Customer addCustomer(Customer customer) throws CustomerExistsException;
    Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
    boolean deleteCustomer(Customer customer) throws CustomerNotFoundException;
    List<Customer> getActiveCustomers();
    List<Customer> getCustomersByMembership(Membership membership);
    List<Customer> getCustomersGreaterThan(int age);
    List<String> getCustomerNames();
    int getActiveCustomersCount();
    boolean isAllCustomersActive();
    Optional<Customer> getFirstCustomer() throws CustomerNotFoundException;
    List<Membership> getUniqueMembership();
    List<Customer> getOldestCustomers(int N);
    List<Customer> sortCustomerByAge();
    List<Customer> sortCustomersByName();
    double getAverageAge();
    Map<Membership,Long> getTotalCustomersForEachMembershipType();
    boolean exists(String email) ;
    Customer save(Customer customer) throws CustomerExistsException;
    Customer getByEmail(String email) throws CustomerNotFoundException;

}