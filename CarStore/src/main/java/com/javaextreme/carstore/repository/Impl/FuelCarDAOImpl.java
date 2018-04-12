package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.vehicles.FuelCar;
import com.javaextreme.carstore.repository.FuelCarDAO;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
public class FuelCarDAOImpl extends CarDAOImpl implements FuelCarDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Integer getEngineVolume(Integer vehicleId) {
        FuelCar result = entityManager.find(FuelCar.class, vehicleId);
        Integer volume = result.getEngineVolume();
        return volume;
    }
}
