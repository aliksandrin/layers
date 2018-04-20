package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.vehicles.Car;
import com.javaextreme.carstore.repository.CarDAO;
import org.springframework.transaction.annotation.Transactional;

public class CarDAOImpl extends VehicleDAOImpl implements CarDAO{

    @Transactional
    @Override
    public Byte getNoOfPassengers(Integer vehicleId) {
        Car result = (Car) read(vehicleId);
        return result.getNoOfPassengers();
    }
}
