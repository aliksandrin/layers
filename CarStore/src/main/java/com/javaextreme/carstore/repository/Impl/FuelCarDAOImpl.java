package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.vehicles.FuelCar;
import com.javaextreme.carstore.repository.FuelCarDAO;
import org.springframework.transaction.annotation.Transactional;

public class FuelCarDAOImpl extends CarDAOImpl implements FuelCarDAO {

    @Transactional
    @Override
    public Integer getEngineVolume(Integer vehicleId) {
        FuelCar result = (FuelCar) read(vehicleId);
        return result.getEngineVolume();
    }
}
