package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.clients.Customer;
import com.javaextreme.carstore.domain.clients.Order;
import com.javaextreme.carstore.repository.CustomerDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public class CustomerDAOImpl extends BasicDAOImpl<Customer> implements CustomerDAO {
    public CustomerDAOImpl() {
        super(Customer.class);
    }

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public List<Customer> findAll() {
        return (List<Customer>) entityManager.createNativeQuery("SELECT * from CUSTOMERS", Customer.class).getResultList();
    }

    @Transactional
    @Override
    public Set<Order> getOrders(Integer customerId) {
        return read(customerId).getOrders();
    }
}
