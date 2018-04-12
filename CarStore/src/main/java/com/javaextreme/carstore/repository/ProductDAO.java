package com.javaextreme.carstore.repository;

import com.javaextreme.carstore.domain.vehicles.Product;
import com.javaextreme.carstore.domain.vehicles.Vehicle;

import java.util.List;

public interface ProductDAO {
    void addProduct(Product product);

    Product updateProduct(Product product);

    Product getProduct(Integer productId);

    @SuppressWarnings("unchecked")
    List<Product> findAll();

    void delete(Product product);

    Vehicle getVehicle(Integer productId);
}
