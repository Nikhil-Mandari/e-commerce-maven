package com.java.app.ui;

import com.java.app.model.Customer;

public class DashBoardUI {

    private Customer customer;

    public DashBoardUI(Customer customer) {
        this.customer = customer;
    }

    public void show() {
        while (true) {
            System.out.println("1. Customer");
            System.out.println("2. Product");

            int choice = InputUtil.getInt("Enter your choice: ");

            switch (choice) {
                case 1 -> new CustomerUI(customer).menu();
                case 2 -> new ProductUI().menu();
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}