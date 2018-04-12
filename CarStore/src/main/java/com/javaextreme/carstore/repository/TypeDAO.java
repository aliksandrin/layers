package com.javaextreme.carstore.repository;

import com.javaextreme.carstore.domain.vehicles.Brand;
import com.javaextreme.carstore.domain.vehicles.Type;

import java.util.List;
import java.util.Set;

public interface TypeDAO {
    void addType(Type type);

    Type updateType(Type type);

    Type getType(Integer typeId);

    @SuppressWarnings("unchecked")
    List<Type> findAll();

    void delete(Type type);

    Set<Brand> getTypes(Integer typeId);
}
