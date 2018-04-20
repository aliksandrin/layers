package com.javaextreme.carstore.repository;

import com.javaextreme.carstore.domain.vehicles.Brand;
import com.javaextreme.carstore.domain.vehicles.Type;
import com.javaextreme.carstore.domain.vehicles.Vehicle;

import java.util.List;

public interface VehicleDAO extends BasicDAO<Vehicle>{
    Brand getBrand(Integer vehicleId);

    Type getType(Integer vehicleId);

    List<String> getCategories();

}
