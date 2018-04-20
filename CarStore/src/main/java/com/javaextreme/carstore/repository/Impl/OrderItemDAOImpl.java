package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.clients.Order;
import com.javaextreme.carstore.domain.clients.OrderItem;
import com.javaextreme.carstore.domain.vehicles.Product;
import com.javaextreme.carstore.repository.OrderItemDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class OrderItemDAOImpl extends BasicDAOImpl<OrderItem> implements OrderItemDAO {

    public OrderItemDAOImpl() {
        super(OrderItem.class);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public List<OrderItem> findAll() {
        return (List<OrderItem>) entityManager.createNativeQuery("SELECT * from ORDER_ITEMS", OrderItem.class).getResultList();
    }

    @Transactional
    @Override
    public Order getOrder(Integer orderItemId) {
        return read(orderItemId).getOrder();
    }

    @Transactional
    @Override
    public Product getProduct(Integer orderItemId) {
        return read(orderItemId).getProduct();
    }

    @Override
    public void addItemToOrder(Order order, OrderItem orderItem) {
        orderItem.setOrder(order);
        create(orderItem);
    }
}
