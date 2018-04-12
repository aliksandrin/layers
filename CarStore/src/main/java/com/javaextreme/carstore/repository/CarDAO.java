package com.javaextreme.carstore.repository;

public interface CarDAO extends VehicleDAO{
    Byte getNoOfPassengers(Integer vehicleId);
}
