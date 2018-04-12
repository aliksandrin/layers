package com.javaextreme.carstore.repository;

public interface ElectroCarDAO extends CarDAO{
    Integer getBatteryPower(Integer vehicleId);
}
