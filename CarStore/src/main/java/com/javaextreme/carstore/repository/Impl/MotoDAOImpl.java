package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.vehicles.Moto;
import com.javaextreme.carstore.repository.MotoDAO;
import org.springframework.transaction.annotation.Transactional;

public class MotoDAOImpl extends VehicleDAOImpl implements MotoDAO {

    @Transactional
    @Override
    public String getFrame(Integer vehicleId) {
        Moto result = (Moto) read(vehicleId);
        return result.getFrame();
    }
}
