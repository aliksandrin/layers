package com.javaextreme.carstore.repository;

import com.javaextreme.carstore.domain.vehicles.Brand;
import com.javaextreme.carstore.domain.vehicles.Type;

import java.util.List;
import java.util.Set;

public interface BrandDAO {
    void addBrand(Brand brand);

    Brand updateBrand(Brand brand);

    Brand getBrand(Integer brandId);

    @SuppressWarnings("unchecked")
    List<Brand> findAll();

    void delete(Brand brand);

    Set<Type> getTypes(Integer brandId);
}
