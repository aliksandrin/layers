package com.javaextreme.carstore.repository;

import com.javaextreme.carstore.domain.clients.Customer;
import com.javaextreme.carstore.domain.clients.Order;
import com.javaextreme.carstore.domain.clients.OrderItem;

import java.util.Set;

public interface OrderDAO extends BasicDAO<Order>{
    Set<OrderItem> getOrderItems(Integer orderId);

    Customer getOrderCustomer(Integer orderId);
}
