package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.vehicles.Truck;
import com.javaextreme.carstore.repository.TruckDAO;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
public class TruckDAOImpl extends VehicleDAOImpl implements TruckDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Integer getCapacity(Integer vehicleId) {
        Truck result = entityManager.find(Truck.class, vehicleId);
        Integer capacity = result.getCargoCapacity();
        return capacity;
    }
}
