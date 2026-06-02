package com.java.app.service;

import com.java.app.exception.CustomerExistsException;
import com.java.app.exception.CustomerNotFoundException;
import com.java.app.exception.InvalidCredentialsException;
import com.java.app.model.Customer;

public interface AuthService {
    Customer signup(Customer customer) throws CustomerExistsException;

    Customer login(String email, String password) throws InvalidCredentialsException;

    Customer getCustomerByEmail(String email) throws CustomerNotFoundException;
}