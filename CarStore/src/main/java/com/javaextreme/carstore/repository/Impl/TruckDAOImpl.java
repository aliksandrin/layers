package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.vehicles.Truck;
import com.javaextreme.carstore.repository.TruckDAO;
import org.springframework.transaction.annotation.Transactional;

public class TruckDAOImpl extends VehicleDAOImpl implements TruckDAO {
    @Transactional
    @Override
    public Integer getCapacity(Integer vehicleId) {
        Truck result = (Truck) read(vehicleId);
        return result.getCargoCapacity();
    }
}
