package com.javaextreme.carstore.repository.Impl;

import com.javaextreme.carstore.domain.vehicles.Brand;
import com.javaextreme.carstore.domain.vehicles.Type;
import com.javaextreme.carstore.repository.BrandDAO;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

@Transactional
public class BrandDAOImpl implements BrandDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addBrand(Brand brand) {
        entityManager.persist(brand);
    }

    @Override
    public Brand updateBrand(Brand brand) {
        Brand result = entityManager.merge(brand);
        return result;
    }

    @Override
    public Brand getBrand(Integer brandId) {
        Brand result = entityManager.find(Brand.class, brandId);
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Brand> findAll() {
        List<Brand> brands = entityManager.createNativeQuery("SELECT * from BRANDS").getResultList();
        return brands;
    }

    @Override
    public void delete(Brand brand) {
        entityManager.remove(brand);

    }

    @Override
    public Set<Type> getTypes(Integer brandId) {
        Brand result = entityManager.find(Brand.class, brandId);
        Set<Type> res = result.getTypes();
        return res;
    }
}
