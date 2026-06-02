package com.java.app.service;

import com.java.app.enums.Membership;
import com.java.app.enums.Status;
import com.java.app.exception.CustomerExistsException;
import com.java.app.exception.CustomerNotFoundException;
import com.java.app.model.Customer;
import com.java.app.repository.CustomerRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.getAll();
    }
    public Customer getCustomerById(int id) throws CustomerNotFoundException{
        return customerRepository.getAll().stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
    }
    public Customer addCustomer(Customer customer) throws CustomerExistsException {
        boolean exists = customerRepository.getAll().stream()
                .anyMatch(c -> c.getId() == customer.getId());
        if (exists)
            throw new CustomerExistsException("Customer already exists");
        customerRepository.save(customer);
        return customer;
    }
    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException{
        return customerRepository.update(customer.getId(), customer);
    }


    @Override
    public boolean deleteCustomer(Customer customer) throws CustomerNotFoundException {
        boolean removed = customerRepository.delete(customer);
        if (!removed )
            throw new CustomerNotFoundException("Customer was not found");
        return true;

    }

    @Override
    public List<Customer> getActiveCustomers() {
        return customerRepository.getAll().stream()
                .filter(c -> c.getStatus() == Status.ACTIVE)
                .toList();
    }
    public List<Customer> getCustomersByMembership(Membership membership){
        return customerRepository.getAll().stream()
                .filter(c -> c.getMembershipType() == membership)
                .toList();
    }

    @Override
    public List<Customer> getCustomersGreaterThan(int age) {
        return customerRepository.getAll().stream()
                .filter(c -> c.getAge() > age)
                .toList();
    }

    @Override
    public List<String> getCustomerNames() {
        return customerRepository.getAll().stream()
                .map(c -> c.getName())
                .toList();
    }

    @Override
    public int getActiveCustomersCount() {
        return (int) customerRepository.getAll().stream()
                .filter(c -> c.getStatus() == Status.ACTIVE)
                .count();
    }

    @Override
    public boolean isAllCustomersActive() {
        return customerRepository.getAll().stream()
                .allMatch(c -> c.getStatus() == Status.ACTIVE);
    }

    @Override
    public Optional<Customer> getFirstCustomer() throws CustomerNotFoundException {
        return customerRepository.getAll().stream().findFirst();
    }

    @Override
    public List<Membership > getUniqueMembership() {
        return customerRepository.getAll().stream()
                .map(c -> c.getMembershipType())
                .distinct()
                .toList();

    }

    @Override
    public List<Customer> getOldestCustomers(int N) {
        return customerRepository.getAll().stream()
                .sorted((a,b) ->Integer.compare(b.getAge(), a.getAge()))
                .limit(N)
                .toList();
    }

    @Override
    public List<Customer> sortCustomerByAge() {
        return customerRepository.getAll().stream()
                .sorted((a,b) -> Integer.compare(a.getAge(),b.getAge()))
                .toList();
    }

    @Override
    public List<Customer> sortCustomersByName() {
        return customerRepository.getAll().stream()
                .sorted((a,b) -> b.getName().compareTo(a.getName()))
                .toList();
    }

    @Override
    public double getAverageAge() {
        return customerRepository.getAll().stream()
                .collect(Collectors.averagingInt(Customer::getAge));

    }

    @Override
    public Map<Membership, Long> getTotalCustomersForEachMembershipType() {
        return customerRepository.getAll().stream()
                .collect(Collectors.groupingBy(Customer::getMembershipType,Collectors.counting()));
    }

    @Override
    public boolean exists(String email) {
        return this.customerRepository.exists(email);
    }

    @Override
    public Customer getByEmail(String email) throws CustomerNotFoundException {

        return customerRepository.findByEmail(email)
                .orElseThrow(() ->
                        new CustomerNotFoundException("Customer not found with email: " + email));
    }
    @Override
    public Customer save(Customer customer) throws CustomerExistsException {
        // 1. Check if email already exists
        if (customerRepository.exists(customer.getEmail())) {
            throw new CustomerExistsException(
                    "Customer already exists with email: " + customer.getEmail()
            );
        }
        // 2. Set default values (good practice 🔥)
        customer.setCreatedOn(LocalDateTime.now());
        customer.setLastLoggedIn(null);

        // Optional defaults (if not set)
        if (customer.getStatus() == null) {
            customer.setStatus(Status.ACTIVE);
        }

        if (customer.getMembershipType() == null) {
            customer.setMembershipType(Membership.BRONZE);
        }

        // 3. Save customer
        return customerRepository.save(customer);
    }

}