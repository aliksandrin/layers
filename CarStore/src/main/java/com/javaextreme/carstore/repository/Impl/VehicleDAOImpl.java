package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.vehicles.Brand;
import com.javaextreme.carstore.domain.vehicles.Type;
import com.javaextreme.carstore.domain.vehicles.Vehicle;
import com.javaextreme.carstore.repository.VehicleDAO;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
public class VehicleDAOImpl implements VehicleDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addVehicle(Vehicle vehicle) {
        entityManager.persist(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return entityManager.merge(vehicle);
    }

    @Override
    public Vehicle getVehicle(Integer vehicleId) {
        Vehicle result = entityManager.find(Vehicle.class, vehicleId);
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Vehicle> findAll() {
        List<Vehicle> vehicles = entityManager.createNativeQuery("SELECT * from CATALOG").getResultList();
        return vehicles;
    }

    @Override
    public void deleteVehicle(Vehicle vehicle) {
        entityManager.remove(vehicle);
    }

    @Override
    public Brand getBrand(Integer vehicleId) {
        Vehicle result = entityManager.find(Vehicle.class, vehicleId);
        Brand brand = result.getBrand();
        return brand;
    }

    @Override
    public Type getType(Integer vehicleId) {
        Vehicle result = entityManager.find(Vehicle.class, vehicleId);
        Type type = result.getType();
        return type;
    }
}
