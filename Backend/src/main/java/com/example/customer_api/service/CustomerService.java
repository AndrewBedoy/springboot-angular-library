package com.example.customer_api.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.customer_api.model.Customer;
import com.example.customer_api.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public List<Customer> getAll() {
        return repo.findAll();
    }

    public Customer getById(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Customer create(Customer c) {
        return repo.save(c);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Customer update(Long id, Customer updated) {
    Customer customer = repo.findById(id)
        .orElseThrow(() -> new RuntimeException("Customer not found"));

    customer.setName(updated.getName());
    customer.setEmail(updated.getEmail());

    return repo.save(customer);
    }
}