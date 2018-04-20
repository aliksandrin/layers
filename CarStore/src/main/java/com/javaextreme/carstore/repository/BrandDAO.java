package com.javaextreme.carstore.repository;

import com.javaextreme.carstore.domain.vehicles.Brand;
import com.javaextreme.carstore.domain.vehicles.Type;

import java.util.List;

public interface BrandDAO extends BasicDAO<Brand> {
    List<Type> getTypes(Integer brandId);
    Integer getBrandIdByName(String name);
}
