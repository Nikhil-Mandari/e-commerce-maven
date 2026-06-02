package com.java.app.controller;

import com.java.app.exception.CustomerExistsException;
import com.java.app.exception.CustomerNotFoundException;
import com.java.app.model.Customer;
import com.java.app.service.AuthService;

public class AuthController {
    AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    public Customer signup(Customer customer) throws CustomerExistsException {
        return authService.signup(customer);
    }

    public Customer login(String email, String password) throws Exception {
        return authService.login(email, password);
    }
    public Customer getCustomerByEmail(String email) throws CustomerNotFoundException {
        return authService.getCustomerByEmail(email);
    }
}