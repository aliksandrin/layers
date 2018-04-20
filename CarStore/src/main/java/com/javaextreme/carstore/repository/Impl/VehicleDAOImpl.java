package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.vehicles.Brand;
import com.javaextreme.carstore.domain.vehicles.Type;
import com.javaextreme.carstore.domain.vehicles.Vehicle;
import com.javaextreme.carstore.repository.VehicleDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class VehicleDAOImpl extends BasicDAOImpl<Vehicle> implements VehicleDAO {

    public VehicleDAOImpl() {
        super(Vehicle.class);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public List<Vehicle> findAll() {
        return (List<Vehicle>) entityManager.createNativeQuery("SELECT * from CATALOG", Vehicle.class).getResultList();
    }

    @Transactional
    @Override
    public Brand getBrand(Integer vehicleId) {
        Vehicle result = read(vehicleId);
        return result.getBrand();
    }

    @Transactional
    @Override
    public Type getType(Integer vehicleId) {
        Vehicle result = read(vehicleId);
        return result.getType();
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<String> getCategories() {
        return (List<String>) entityManager.createNativeQuery("SELECT CATEGORY FROM CATALOG GROUP BY CATEGORY", String.class).getResultList();
    }
}
