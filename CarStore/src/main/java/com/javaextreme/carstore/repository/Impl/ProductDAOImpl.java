package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.vehicles.Product;
import com.javaextreme.carstore.domain.vehicles.Vehicle;
import com.javaextreme.carstore.repository.ProductDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ProductDAOImpl extends BasicDAOImpl<Product> implements ProductDAO{
    public ProductDAOImpl() {
        super(Product.class);
    }

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public List<Product> findAll() {
        return (List<Product>) entityManager.createNativeQuery("SELECT * from STOCK", Product.class).getResultList();
    }

    @Transactional
    @Override
    public Vehicle getVehicle(Integer productId) {
        Product result = read(productId);
        return result.getVehicle();
    }
}
