package com.javaextreme.carstore.repository;

public interface TruckDAO extends VehicleDAO{
    Integer getCapacity(Integer vehicleId);
}
