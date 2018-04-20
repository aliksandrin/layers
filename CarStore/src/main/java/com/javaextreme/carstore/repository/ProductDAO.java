package com.javaextreme.carstore.repository;

import com.javaextreme.carstore.domain.vehicles.Product;
import com.javaextreme.carstore.domain.vehicles.Vehicle;

public interface ProductDAO extends BasicDAO<Product>{
    Vehicle getVehicle(Integer productId);
}
