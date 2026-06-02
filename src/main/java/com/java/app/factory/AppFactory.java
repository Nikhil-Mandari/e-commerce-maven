package com.java.app.factory;

import com.java.app.controller.AuthController;
import com.java.app.controller.CustomerController;
import com.java.app.controller.ProductController;
import com.java.app.repository.CustomerRepository;
import com.java.app.repository.ProductRepository;
import com.java.app.service.*;
import com.java.app.ui.AuthUI;
import com.java.app.util.CsvParser;

import java.io.IOException;

public class AppFactory {

    //--------------------------
    private static CsvParser csvParser;
    private static CsvParser getCsvParser(){
        if (csvParser == null)
            csvParser = new CsvParser();
        return csvParser;
    }


    //PRODUCT DEPENDENCIES
    //--------------------------
    private static ProductRepository productRepository;
    private static ProductRepository getProductRepository() throws IOException {
        if (productRepository == null)
            productRepository = new ProductRepository(getCsvParser());
        return productRepository;
    }
    //--------------------------
    private static ProductService productService;
    public static ProductService getProductService() throws IOException {
        if (productService == null) {
            productService = new ProductServiceImpl(getProductRepository());
        }
        return productService;
    }
    //---------------------------
    private static ProductController productController;
    public static ProductController getProductController() throws IOException {
        if (productController == null) {
            productController = new ProductController(getProductService());
        }
        return productController;
    }



    //CUSTOMER DEPENDENCIES
    //---------------------------
    private static CustomerRepository customerRepository;
    public static CustomerRepository getCustomerRepository() throws IOException {
        if (customerRepository == null) {
            customerRepository = new CustomerRepository(getCsvParser());
        }
        return customerRepository;
    }
    //---------------------------
    private static CustomerService customerService;
    public static CustomerService getCustomerService() throws IOException {
        if (customerService == null) {
            customerService = new CustomerServiceImpl(getCustomerRepository());
        }
        return customerService;
    }
    //--------------------------
    private static CustomerController customerController;
    public static CustomerController getCustomerController() throws IOException {
        if (customerController == null) {
            customerController = new CustomerController(getCustomerService());
        }
        return customerController;
    }

    //AUTH DEPENDENCIES
    private static AuthService authService;
    public static AuthService getAuthService() throws IOException {
        if (authService == null) {
            authService = new AuthServiceImpl(getCustomerService());
        }
        return authService;
    }

    private static AuthController authController;
    public static AuthController getAuthController() throws IOException {
        if (authController == null) {
            authController = new AuthController(getAuthService());
        }
        return authController;
    }

    //UI DEPENDENCIES
    //------------------------
    private static AuthUI authUI;

    public static AuthUI getAuthUI() throws IOException{
        if (authUI == null)
            authUI = new AuthUI(getAuthController());
        return authUI;
    }

}