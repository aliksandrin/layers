package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.vehicles.Brand;
import com.javaextreme.carstore.domain.vehicles.Type;
import com.javaextreme.carstore.repository.TypeDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class TypeDAOImpl extends BasicDAOImpl<Type> implements TypeDAO {
    public TypeDAOImpl() {
        super(Type.class);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public List<Type> findAll() {
        return (List<Type>) entityManager.createNativeQuery("SELECT * from TYPES", Type.class).getResultList();
    }

    @Transactional
    @Override
    public List<Brand> getBrands(Integer typeId) {
        Type result = read(typeId);
        List<Brand> res = result.getBrands();
        return res;
    }

    @Override
    public Type getTypeByName(String value) {
        return (Type) entityManager.createNativeQuery(
                "SELECT * from TYPES WHERE TYPE_TITLE='" + value + "'", Type.class).getResultList().get(0);
    }
}
