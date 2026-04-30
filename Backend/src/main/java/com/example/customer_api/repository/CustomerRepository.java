package com.example.customer_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.customer_api.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}