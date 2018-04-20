package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.clients.Customer;
import com.javaextreme.carstore.domain.clients.Order;
import com.javaextreme.carstore.domain.clients.OrderItem;
import com.javaextreme.carstore.repository.OrderDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public class OrderDAOImpl extends BasicDAOImpl<Order> implements OrderDAO {
    public OrderDAOImpl() {
        super(Order.class);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public List<Order> findAll() {
        return (List<Order>) entityManager.createNativeQuery("SELECT * from ORDERS", Order.class).getResultList();
    }

    @Transactional
    @Override
    public Set<OrderItem> getOrderItems(Integer orderId) {
        Order order = read(orderId);
        return order.getOrderItems();
    }

    @Transactional
    @Override
    public Customer getOrderCustomer(Integer orderId) {
        Order order = read(orderId);
        return order.getCustomer();
    }

}
