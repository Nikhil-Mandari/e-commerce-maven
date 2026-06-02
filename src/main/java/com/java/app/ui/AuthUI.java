package com.java.app.ui;

import com.java.app.controller.AuthController;
import com.java.app.enums.Gender;
import com.java.app.enums.Membership;
import com.java.app.enums.Status;
import com.java.app.model.Address;
import com.java.app.model.Customer;

import java.time.LocalDateTime;

public class AuthUI {
    AuthController authController;

    public AuthUI(AuthController authController) {
        this.authController = authController;
    }

    public void signup(){
        try {
            // =========================
            // STEP 1: BASIC DETAILS
            // =========================
            System.out.println("\nEnter Basic Details:");

            int id = InputUtil.getInt("ID: ");
            String name = InputUtil.getString("Name: ");
            String email = InputUtil.getString("Email: ");
            String phone = InputUtil.getString("Phone No: ");
            String password = InputUtil.getString("Password: ");
            byte age = InputUtil.getByte("Age: ");

            Gender gender = Gender.valueOf(
                    InputUtil.getString("Gender (MALE/FEMALE): ").toUpperCase()
            );
            // =========================
            // STEP 2: ADDRESS DETAILS
            // =========================
            Address residential = readAddress("Residential");

            String same = InputUtil.getString("Is Shipping same as Residential? (yes/no): ");

            Address shipping;
            if (same.equalsIgnoreCase("yes")) {
                shipping = residential;
            } else {
                shipping = readAddress("Shipping");
            }
            // =========================
            // BUILD CUSTOMER
            // =========================
            Customer customer = Customer.builder()
                    .id(id)
                    .name(name)
                    .email(email)
                    .password(password)
                    .phoneNo(Long.parseLong(phone))
                    .age(age)
                    .gender(gender)
                    .status(Status.ACTIVE)
                    .membershipType(Membership.BRONZE)
                    .createdOn(LocalDateTime.now())
                    .lastLoggedIn(null)
                    .residentialAddress(residential)
                    .shippingAddress(shipping)
                    .build();

            // Call service/controller
            Customer savedCustomer = authController.signup(customer);
            System.out.println(" Welcome, " + savedCustomer.getGender().getSalutation() + " " + savedCustomer.getName() + "✅ Registration Successful");


        } catch (Exception e) {
            e.printStackTrace();;
        }
    }
    private Address readAddress(String type) {
        System.out.println("\nEnter " + type + " Address:");

        return Address.builder()
                .houseNo(InputUtil.getString("House No: ").trim())
                .streetName(InputUtil.getString("Street Name: ").trim())
                .area(InputUtil.getString("Area: ").trim())
                .city(InputUtil.getString("City: ").trim())
                .pincode(InputUtil.getInt("Pincode: "))
                .build();
    }
    public void login() {
        try {
            String email = InputUtil.getString("Email: ");
            String password = InputUtil.getString("Password: ");

            Customer customer = authController.getCustomerByEmail(email);

            if (!customer.getPassword().equals(password)) {
                System.out.println("❌ Invalid credentials");
                return;
            }

            System.out.println("✅ Welcome , " + customer.getGender().getSalutation()+ ":" +customer.getName());

            new DashBoardUI(customer).show();

        } catch (Exception e) {
            System.out.println("❌ Login failed: " + e.getMessage());
        }
    }

}