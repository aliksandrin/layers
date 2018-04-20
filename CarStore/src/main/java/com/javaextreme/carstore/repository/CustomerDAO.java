package com.javaextreme.carstore.repository;

import com.javaextreme.carstore.domain.clients.Customer;
import com.javaextreme.carstore.domain.clients.Order;

import java.util.Set;

public interface CustomerDAO extends BasicDAO<Customer>{
    Set<Order> getOrders(Integer customerId);
}
