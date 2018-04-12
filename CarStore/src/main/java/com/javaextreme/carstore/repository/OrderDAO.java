package com.javaextreme.carstore.repository;

import com.javaextreme.carstore.domain.clients.Customer;
import com.javaextreme.carstore.domain.clients.Order;
import com.javaextreme.carstore.domain.clients.OrderItem;

import java.util.List;
import java.util.Set;

public interface OrderDAO {
    void addOrder(Order order);

    Order updateOrder(Order order);

    Order getOrder(Integer orderId);

    @SuppressWarnings("unchecked")
    List<Order> findAll();

    void delete(Order order);

    Set<OrderItem> getOrderItems(Integer orderId);

    Customer getOrderCustomer(Integer orderId);
}
