package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.vehicles.ElectroCar;
import com.javaextreme.carstore.repository.ElectroCarDAO;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
public class ElectroCarDAOImpl extends CarDAOImpl implements ElectroCarDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Integer getBatteryPower(Integer vehicleId) {
        ElectroCar result = entityManager.find(ElectroCar.class, vehicleId);
        Integer power = result.getBatteryPower();
        return power;
    }
}
