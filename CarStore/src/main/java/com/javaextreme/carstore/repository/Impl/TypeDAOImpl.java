package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.vehicles.Brand;
import com.javaextreme.carstore.domain.vehicles.Type;
import com.javaextreme.carstore.repository.TypeDAO;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

@Transactional
public class TypeDAOImpl implements TypeDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addType(Type type) {
        entityManager.persist(type);
    }

    @Override
    public Type updateType(Type type) {
        Type result = entityManager.merge(type);
        return result;
    }

    @Override
    public Type getType(Integer typeId) {
        Type result = entityManager.find(Type.class, typeId);
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Type> findAll() {
        List<Type> brands = entityManager.createNativeQuery("SELECT * from TYPES").getResultList();
        return brands;
    }

    @Override
    public void delete(Type type) {
        entityManager.remove(type);
    }

    @Override
    public Set<Brand> getTypes(Integer typeId) {
        Type result = entityManager.find(Type.class, typeId);
        Set<Brand> res = result.getBrands();
        return res;
    }
}
