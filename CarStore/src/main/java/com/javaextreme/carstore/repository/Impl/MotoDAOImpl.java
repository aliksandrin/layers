package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.vehicles.Moto;
import com.javaextreme.carstore.repository.MotoDAO;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
public class MotoDAOImpl extends VehicleDAOImpl implements MotoDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String getFrame(Integer vehicleId) {
        Moto result = entityManager.find(Moto.class, vehicleId);
        String frame = result.getFrame();
        return frame;
    }
}
