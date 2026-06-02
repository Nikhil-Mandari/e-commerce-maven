package com.java.app.service;

import com.java.app.exception.CustomerExistsException;
import com.java.app.exception.CustomerNotFoundException;
import com.java.app.exception.InvalidCredentialsException;
import com.java.app.model.Customer;

import java.time.LocalDateTime;

public class AuthServiceImpl implements AuthService{
    CustomerService customerService;
    public AuthServiceImpl(CustomerService customerService) {
        this.customerService = customerService;
    }
    @Override
    public Customer signup(Customer customer) throws CustomerExistsException{

        if (customerService.exists(customer.getEmail())) {
            throw new CustomerExistsException(
                    "Customer already exists with email: " + customer.getEmail());
        }

        return customerService.save(customer);
    }
    @Override
    public Customer login(String email, String password) throws InvalidCredentialsException {

        try {
            Customer customer = customerService.getByEmail(email);

            if (password == null || !customer.getPassword().equals(password)) {
                throw new InvalidCredentialsException("Invalid email or password");
            }

            customer.setLastLoggedIn(LocalDateTime.now());
            return customer;

        } catch (CustomerNotFoundException e) {
            throw new InvalidCredentialsException("Invalid email or password");
        }
    }
    @Override
    public Customer getCustomerByEmail(String email) throws CustomerNotFoundException {
        return customerService.getByEmail(email);
    }


}