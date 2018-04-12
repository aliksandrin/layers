package com.javaextreme.carstore.repository;

import com.javaextreme.carstore.domain.clients.Customer;
import com.javaextreme.carstore.domain.clients.Order;

import java.util.List;
import java.util.Set;

public interface CustomerDAO {
    void addCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    Customer getCustomer(Integer customerId);

    @SuppressWarnings("unchecked")
    List<Customer> findAll();

    void delete(Customer customer);

    Set<Order> getOrders(Integer customerId);
}
