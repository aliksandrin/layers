package com.javaextreme.carstore.repository;

import com.javaextreme.carstore.domain.vehicles.Brand;
import com.javaextreme.carstore.domain.vehicles.Type;

import java.util.List;

public interface TypeDAO extends BasicDAO<Type>{
    List<Brand> getBrands(Integer typeId);

    Type getTypeByName(String value);
}
