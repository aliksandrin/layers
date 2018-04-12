package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.clients.Customer;
import com.javaextreme.carstore.domain.clients.Order;
import com.javaextreme.carstore.repository.CustomerDAO;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

@Transactional
public class CustomerDAOImpl implements CustomerDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return entityManager.merge(customer);
    }

    @Override
    public Customer getCustomer(Integer customerId) {
        Customer result = entityManager.find(Customer.class, customerId);
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Customer> findAll() {
        List<Customer> customers = (List<Customer>) entityManager.createNativeQuery("SELECT * from CUSTOMERS").getResultList();
        return customers;
    }

    @Override
    public void delete(Customer customer) {
        entityManager.remove(customer);
    }

    @Override
    public Set<Order> getOrders(Integer customerId) {
        Set<Order> result = entityManager.find(Customer.class, customerId).getOrders();
        return result;
    }
}
