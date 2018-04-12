package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.clients.Customer;
import com.javaextreme.carstore.domain.clients.Order;
import com.javaextreme.carstore.domain.clients.OrderItem;
import com.javaextreme.carstore.repository.OrderDAO;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

@Transactional
public class OrderDAOImpl implements OrderDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addOrder(Order order) {
        entityManager.persist(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return entityManager.merge(order);
    }

    @Override
    public Order getOrder(Integer orderId) {
        return entityManager.find(Order.class, orderId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Order> findAll() {
        List<Order> orders = entityManager.createNativeQuery("SELECT * from ORDERS").getResultList();
        return orders;
    }

    @Override
    public void delete(Order order) {
        entityManager.remove(order);
    }

    @Override
    public Set<OrderItem> getOrderItems(Integer orderId) {
        Order order = entityManager.find(Order.class, orderId);
        return order.getOrderItems();
    }

    @Override
    public Customer getOrderCustomer(Integer orderId) {
        Order order = entityManager.find(Order.class, orderId);
        return order.getCustomer();
    }
}
