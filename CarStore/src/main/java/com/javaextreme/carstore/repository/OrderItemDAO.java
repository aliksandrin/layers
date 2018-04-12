package com.javaextreme.carstore.repository;

import com.javaextreme.carstore.domain.clients.Order;
import com.javaextreme.carstore.domain.clients.OrderItem;
import com.javaextreme.carstore.domain.vehicles.Product;

import java.util.List;

public interface OrderItemDAO {
    void addOrderItem(OrderItem orderItem);

    OrderItem updateOrderItem(OrderItem orderItem);

    OrderItem getOrderItem(Integer orderItemId);

    @SuppressWarnings("unchecked")
    List<OrderItem> findAll();

    void delete(OrderItem orderItem);

    Order getOrder(Integer orderItemId);

    Product getProduct(Integer orderItemId);
}
