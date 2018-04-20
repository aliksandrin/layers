package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.vehicles.ElectroCar;
import com.javaextreme.carstore.repository.ElectroCarDAO;
import org.springframework.transaction.annotation.Transactional;

public class ElectroCarDAOImpl extends CarDAOImpl implements ElectroCarDAO{

    @Transactional
    @Override
    public Integer getBatteryPower(Integer vehicleId) {
        ElectroCar result = (ElectroCar) read(vehicleId);
        return result.getBatteryPower();
    }
}
