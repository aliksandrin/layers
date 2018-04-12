package com.javaextreme.carstore.repository;

import com.javaextreme.carstore.domain.vehicles.Brand;
import com.javaextreme.carstore.domain.vehicles.Type;
import com.javaextreme.carstore.domain.vehicles.Vehicle;

import java.util.List;

public interface VehicleDAO {
    void addVehicle(Vehicle vehicle);

    Vehicle updateVehicle(Vehicle vehicle);

    Vehicle getVehicle(Integer vehicleId);

    @SuppressWarnings("unchecked")
    List<Vehicle> findAll();

    void deleteVehicle(Vehicle vehicle);

    Brand getBrand(Integer vehicleId);

    Type getType(Integer vehicleId);

}
