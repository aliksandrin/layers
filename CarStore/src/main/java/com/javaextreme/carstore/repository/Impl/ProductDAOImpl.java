package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.vehicles.Product;
import com.javaextreme.carstore.domain.vehicles.Vehicle;
import com.javaextreme.carstore.repository.ProductDAO;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
public class ProductDAOImpl implements ProductDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addProduct(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return entityManager.merge(product);
    }

    @Override
    public Product getProduct(Integer productId) {
        Product result = entityManager.find(Product.class, productId);
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Product> findAll() {
        List<Product> products = entityManager.createNativeQuery("SELECT * from STOCK").getResultList();
        return products;
    }

    @Override
    public void delete(Product product) {
        entityManager.remove(product);
    }

    @Override
    public Vehicle getVehicle(Integer productId) {
        Product result = entityManager.find(Product.class, productId);
        return result.getVehicle();
    }
}
