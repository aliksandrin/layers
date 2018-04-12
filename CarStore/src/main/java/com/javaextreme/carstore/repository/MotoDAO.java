package com.javaextreme.carstore.repository;

public interface MotoDAO extends VehicleDAO{
    String getFrame(Integer vehicleId);
}
