package com.javaextreme.carstore.repository;

import com.javaextreme.carstore.domain.clients.Order;
import com.javaextreme.carstore.domain.clients.OrderItem;
import com.javaextreme.carstore.domain.vehicles.Product;

public interface OrderItemDAO extends BasicDAO<OrderItem>{
    Order getOrder(Integer orderItemId);

    Product getProduct(Integer orderItemId);

    void addItemToOrder(Order order, OrderItem orderItem);
}
