package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.vehicles.Car;
import com.javaextreme.carstore.repository.CarDAO;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
public class CarDAOImpl extends VehicleDAOImpl implements CarDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Byte getNoOfPassengers(Integer vehicleId) {
        Car result = entityManager.find(Car.class, vehicleId);
        Byte res = result.getNoOfPassengers();
        return res;
    }
}
