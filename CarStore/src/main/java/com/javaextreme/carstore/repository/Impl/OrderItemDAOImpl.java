package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.clients.Order;
import com.javaextreme.carstore.domain.clients.OrderItem;
import com.javaextreme.carstore.domain.vehicles.Product;
import com.javaextreme.carstore.repository.OrderItemDAO;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
public class OrderItemDAOImpl implements OrderItemDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addOrderItem(OrderItem orderItem) {
        entityManager.persist(orderItem);
    }

    @Override
    public OrderItem updateOrderItem(OrderItem orderItem) {
        return entityManager.merge(orderItem);
    }

    @Override
    public OrderItem getOrderItem(Integer orderItemId) {
        return entityManager.find(OrderItem.class, orderItemId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderItem> findAll() {
        List<OrderItem> orderItems = entityManager.createNativeQuery("SELECT * from ORDER_ITEMS").getResultList();
        return orderItems;
    }

    @Override
    public void delete(OrderItem orderItem) {
        entityManager.remove(orderItem);
    }

    @Override
    public Order getOrder(Integer orderItemId) {
        return entityManager.find(OrderItem.class, orderItemId).getOrder();
    }

    @Override
    public Product getProduct(Integer orderItemId) {
        return entityManager.find(OrderItem.class, orderItemId).getProduct();
    }
}
